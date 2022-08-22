package net.illia.illiafabricmod1_19.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.illia.illiafabricmod1_19.IlliaFabricMod1_19;
import net.illia.illiafabricmod1_19.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
	public static BlockEntityType<DiamondCraftingTableBlockEntity> DIAMOND_CRAFTING_TABLE;

	public static void registerBlockEntities() {
		DIAMOND_CRAFTING_TABLE = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(IlliaFabricMod1_19.MOD_ID, "diamond_crafting_table"), FabricBlockEntityTypeBuilder.create(DiamondCraftingTableBlockEntity::new, ModBlocks.DIAMOND_CRAFTING_TABLE).build(null));
	}
}
