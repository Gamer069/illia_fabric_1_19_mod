package net.illia.illiafabricmod1_19.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.CraftingResultSlot;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import org.checkerframework.checker.units.qual.C;
import org.lwjgl.system.SharedLibrary;

import java.util.Optional;

public class DiamondCraftingTableScreenHandler extends ScreenHandler {
	public static Inventory inventory;
	private final CraftingInventory input;
	private final CraftingResultInventory result;
	private final PropertyDelegate delegate;
	private final PlayerEntity player;

	public DiamondCraftingTableScreenHandler(int syncId, PlayerInventory inventory) {
		this(syncId, inventory, new SimpleInventory(9), new ArrayPropertyDelegate(9));
	}
	public DiamondCraftingTableScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate) {
		super(ModScreenHandlers.DIAMOND_CRAFTING_TABLE_SCREEN_HANDLER, syncId);
		checkSize(inventory, 9);
		this.inventory = inventory;
		inventory.onOpen(playerInventory.player);
		this.delegate = delegate;
		this.input = new CraftingInventory(this, 3, 3);
		this.result = new CraftingResultInventory();
		this.player = playerInventory.player;
		this.addSlot(new CraftingResultSlot(playerInventory.player, this.input, this.result, 0, 124, 35));

		addPlayerInventory(playerInventory);
		addPlayerHotbar(playerInventory);
		addInputSlots(inventory);

		addProperties(delegate);
	}

	@Override
	public ItemStack transferSlot(PlayerEntity player, int invSlot) {
		ItemStack newStack = ItemStack.EMPTY;
		Slot slot = this.slots.get(invSlot);
		if (slot != null && slot.hasStack()) {
			ItemStack originalStack = slot.getStack();
			newStack = originalStack.copy();
			if (invSlot < this.inventory.size()) {
				if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true))
					return ItemStack.EMPTY;
			} else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
				return ItemStack.EMPTY;
			}
			if (originalStack.isEmpty()) {
				slot.setStack(ItemStack.EMPTY);
			} else {
				slot.markDirty();
			}
		}
		return newStack;
	}


	@Override
	public boolean canUse(PlayerEntity player) {
		return this.inventory.canPlayerUse(player);
	}

	private void addPlayerInventory(PlayerInventory inventory) {
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
	}

	private void addPlayerHotbar(PlayerInventory inventory) {
		for(int i = 0; i < 9; ++i) {
			this.addSlot(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}

	private void addInputSlots(Inventory inventory) {
		int i;
		int j;
		for (i = 0; i < 3; ++i) {
			for (j = 0; j < 3; ++j) {
				this.addSlot(new Slot(this.input, j + i * 3, 30 + j * 18, 17 + i * 18));
			}
		}
	}
	public static void updateResult(ScreenHandler handler, World world, PlayerEntity player, CraftingInventory craftingInventory, CraftingResultInventory resultInventory) {
		if (!world.isClient) {
			ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) player;
			ItemStack itemStack = ItemStack.EMPTY;
			Optional<CraftingRecipe> optional = world.getServer().getRecipeManager().getFirstMatch(RecipeType.CRAFTING, craftingInventory, world);
			if (optional.isPresent()) {
				CraftingRecipe craftingRecipe = (CraftingRecipe) optional.get();
				if (resultInventory.shouldCraftRecipe(world, serverPlayerEntity, craftingRecipe)) {
					itemStack = craftingRecipe.craft(craftingInventory);
				}
			}

			resultInventory.setStack(0, itemStack);
			handler.setPreviousTrackedSlot(0, itemStack);
			serverPlayerEntity.networkHandler.sendPacket(new ScreenHandlerSlotUpdateS2CPacket(handler.syncId, handler.nextRevision(), 0, itemStack));
		}
	}

	@Override
	public void onContentChanged(Inventory inventory) {
		updateResult(this, this.player.world, this.player, this.input, this.result);
	}

	@Override
	public ScreenHandlerType<?> getType() {
		return ModScreenHandlers.DIAMOND_CRAFTING_TABLE_SCREEN_HANDLER;
	}
}
