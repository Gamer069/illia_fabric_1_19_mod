package net.illia.illiafabricmod1_19.recipe;

import net.illia.illiafabricmod1_19.IlliaFabricMod1_19;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
	public static void registerRecipes() {
		Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(IlliaFabricMod1_19.MOD_ID, DiamondCraftingTableRecipe.Serializer.ID), DiamondCraftingTableRecipe.Serializer.INSTANCE);
		Registry.register(Registry.RECIPE_TYPE, new Identifier(IlliaFabricMod1_19.MOD_ID, DiamondCraftingTableRecipe.Type.ID), DiamondCraftingTableRecipe.Type.INSTANCE);
	}
}
