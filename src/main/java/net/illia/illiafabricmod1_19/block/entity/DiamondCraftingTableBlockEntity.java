package net.illia.illiafabricmod1_19.block.entity;

import net.illia.illiafabricmod1_19.item.ModItems;
import net.illia.illiafabricmod1_19.screen.DiamondCraftingTableScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DiamondCraftingTableBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
	private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);
	private static final ScreenHandler handler = new DiamondCraftingTableScreenHandler(0, (PlayerInventory) DiamondCraftingTableScreenHandler.inventory);
	protected final PropertyDelegate delegate;

	public DiamondCraftingTableBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntities.DIAMOND_CRAFTING_TABLE, pos, state);
		this.delegate = new PropertyDelegate() {
			@Override
			public int get(int index) {
				return index;
			}

			@Override
			public void set(int index, int value) {

			}

			@Override
			public int size() {
				return 9 ;
			}
		};
	}

	@Override
	public DefaultedList<ItemStack> getItems() {
		return this.inventory;
	}

	@Override
	public Text getDisplayName() {
		return Text.literal("Diamond Crafting Table ");
	}

	@Nullable
	@Override
	public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
		return new DiamondCraftingTableScreenHandler(syncId, inv, this, this.delegate);
	}

	@Override
	protected void writeNbt(NbtCompound nbt) {
		super.writeNbt(nbt);
		Inventories.writeNbt(nbt, inventory);
	}

	@Override
	public void readNbt(NbtCompound nbt) {
		Inventories.readNbt(nbt, inventory);
		super.readNbt(nbt);
	}

	public static void tick(World world, BlockPos pos, BlockState state, DiamondCraftingTableBlockEntity entity) {
		if (world.isClient) return;
		if (hasRecipe(entity)) {
			craftItem(entity);
		} else {
			markDirty(world, pos, state);
		}
	}

	private static void craftItem(DiamondCraftingTableBlockEntity entity) {
		ScreenHandler handler;
		CraftingInventory inventory = new CraftingInventory(DiamondCraftingTableBlockEntity.handler, entity.size(), entity.size());
		for (int i = 0; i < entity.size(); i++) {
			inventory.setStack(i, entity.getStack(i));
		}
		if (hasRecipe(entity)) {
			entity.removeStack(1, 1);
			entity.setStack(2, new ItemStack(ModItems.RUBY, entity.getStack(2).getCount() + 1));
		}
	}

	private static boolean hasRecipe(DiamondCraftingTableBlockEntity entity) {
		CraftingInventory inventory = new CraftingInventory(DiamondCraftingTableBlockEntity.handler, entity.size(), entity.size());
		for (int i = 0; i < entity.size(); i++) {
			inventory.setStack(i, entity.getStack(i));
		}
		return canInsertAmountIntoOutputSlot(inventory, 1)
			&& canInsertItemIntoOutputSlot(inventory, ModItems.RUBY);
	}

	private static boolean canInsertAmountIntoOutputSlot(CraftingInventory inventory, int amount) {
		return inventory.getStack(2).getMaxCount() > inventory.getStack(2).getCount() + amount;
	}

	private static boolean canInsertItemIntoOutputSlot(CraftingInventory inventory, Item output) {
		return inventory.getStack(2).getItem() == output || inventory.getStack(2).isEmpty();
	}
}
