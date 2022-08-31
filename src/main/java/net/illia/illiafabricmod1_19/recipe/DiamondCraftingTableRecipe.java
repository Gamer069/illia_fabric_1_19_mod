package net.illia.illiafabricmod1_19.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class DiamondCraftingTableRecipe implements Recipe<CraftingInventory> {
	private final Ingredient input1;
	private final Ingredient input2;
	private final Ingredient input3;
	private final Ingredient input4;
	private final Ingredient input5;
	private final Ingredient input6;
	private final Ingredient input7;
	private final Ingredient input8;
	private final Ingredient input9;
	private final Identifier id;
	private final ItemStack result;
	private final DefaultedList<Ingredient> recipeItems;
	public DiamondCraftingTableRecipe(Identifier id, Ingredient input1, Ingredient input2, Ingredient input3, Ingredient input4, Ingredient input5, Ingredient input6, Ingredient input7, Ingredient input8, Ingredient input9, ItemStack result, DefaultedList<Ingredient> recipeItems) {
		this.id = id;
		this.result = result;
		this.recipeItems = recipeItems;
		this.input1 = input1;
		this.input2 = input2;
		this.input3 = input3;
		this.input4 = input4;
		this.input5 = input5;
		this.input6 = input6;
		this.input7 = input7;
		this.input8 = input8;
		this.input9 = input9;
	}

	@Override
	public boolean matches(CraftingInventory inventory, World world) {
		if (world.isClient()) return false;
		return recipeItems.get(0).test(inventory.getStack(0)) && recipeItems.get(1).test(inventory.getStack(1)) && recipeItems.get(2).test(inventory.getStack(2)) && recipeItems.get(3).test(inventory.getStack(3)) && recipeItems.get(4).test(inventory.getStack(4)) && recipeItems.get(5).test(inventory.getStack(5)) && recipeItems.get(6).test(inventory.getStack(6)) && recipeItems.get(7).test(inventory.getStack(7)) && recipeItems.get(8).test(inventory.getStack(8));
	}

	@Override
	public ItemStack craft(CraftingInventory inventory) {
		return result;
	}

	@Override
	public boolean fits(int width, int height) {
		return true;
	}

	@Override
	public ItemStack getOutput() {
		return result.copy();
	}

	@Override
	public Identifier getId() {
		return id;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}

	@Override
	public RecipeType<?> getType() {
		return Type.INSTANCE;
	}
	public static class Type implements RecipeType<DiamondCraftingTableRecipe> {
		private Type() {}
		public static final Type INSTANCE = new Type();
		public static final String ID = "diamond_crafting";
	}
	public static class Serializer implements RecipeSerializer<DiamondCraftingTableRecipe> {
		public static final Serializer INSTANCE = new Serializer();
		public static final String ID = "diamond_crafting";
		@Override
		public DiamondCraftingTableRecipe read(Identifier id, JsonObject json) {
			 ItemStack result = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "result"));
			 JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
			 DefaultedList<Ingredient> inputs = DefaultedList.ofSize(9, Ingredient.EMPTY);
			 for (int i = 0; i < inputs.size(); i++) {
				 inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
			 }
			 return new DiamondCraftingTableRecipe(id, inputs.get(0), inputs.get(1), inputs.get(2), inputs.get(3), inputs.get(4), inputs.get(5), inputs.get(6), inputs.get(7), inputs.get(8), result, inputs);
		}

		@Override
		public DiamondCraftingTableRecipe read(Identifier id, PacketByteBuf buf) {
			DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);
			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromPacket(buf));
			}
			ItemStack result = buf.readItemStack();
			return new DiamondCraftingTableRecipe(id, inputs.get(0), inputs.get(1), inputs.get(2), inputs.get(3), inputs.get(4), inputs.get(5), inputs.get(6), inputs.get(7), inputs.get(8), result, inputs);
		}

		@Override
		public void write(PacketByteBuf buf, DiamondCraftingTableRecipe recipe) {
			buf.writeInt(recipe.getIngredients().size());
			for (Ingredient ingredient : recipe.getIngredients()) {
				ingredient.write(buf);
			}
			buf.writeItemStack(recipe.getOutput());
		}
	}
}
