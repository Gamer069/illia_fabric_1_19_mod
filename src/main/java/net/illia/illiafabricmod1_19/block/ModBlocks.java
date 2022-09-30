package net.illia.illiafabricmod1_19.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.illia.illiafabricmod1_19.IlliaFabricMod1_19;
import net.illia.illiafabricmod1_19.block.custom.DiamondCraftingTable;
import net.illia.illiafabricmod1_19.block.custom.IlliaAdvancedBlock;
import net.illia.illiafabricmod1_19.item.ModItemGroup;
import net.illia.illiafabricmod1_19.world.feature.tree.TestWoodSaplingGen;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
	public static final Block RUBY_BLOCK = registerBlock("ruby_block",
		new Block(FabricBlockSettings.of(Material.METAL).strength(1f).requiresTool()), ModItemGroup.RUBY);
	public static final Block RUBY_ORE = registerBlock("ruby_ore",
		new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
			UniformIntProvider.create(3, 7)), ModItemGroup.RUBY);
	public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
		new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool(),
			UniformIntProvider.create(7, 9)), ModItemGroup.RUBY);
	public static final Block ILLIA_ADVANCED_BLOCK = registerBlock("illia_advanced_block",
		new IlliaAdvancedBlock(FabricBlockSettings.of(Material.STONE).strength(1f)), ModItemGroup.RUBY);
	public static final Block DIAMOND_CRAFTING_TABLE = registerBlock("diamond_crafting_table", new DiamondCraftingTable(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool().nonOpaque()), ModItemGroup.RUBY);
	public static final Block TEST_LOG = registerBlock("test_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)), ModItemGroup.RUBY);
	public static final Block TEST_WOOD = registerBlock("test_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)), ModItemGroup.RUBY);
	public static final Block STRIPPED_TEST_WOOD = registerBlock("stripped_test_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)), ModItemGroup.RUBY);
	public static final Block STRIPPED_TEST_LOG = registerBlock("stripped_test_log.json", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)), ModItemGroup.RUBY);
	public static final Block TEST_PLANKS = registerBlock("stripped_test_log.json", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)), ModItemGroup.RUBY);
	public static final Block TEST_LEAVES = registerBlock("test_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)), ModItemGroup.RUBY);
	public static final Block TEST_SAPLING = registerBlock("test_sapling.json", new SaplingBlock(new TestWoodSaplingGen(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)), ModItemGroup.RUBY);
private static Block registerBlockWithoutItem(String name, Block block) {
	return Registry.register(Registry.BLOCK, new Identifier(IlliaFabricMod1_19.MOD_ID, name), block);
}
public static Block registerBlock(String name, Block block, ItemGroup itemGroup) {
	registerBlockItem(name, block, itemGroup);
	return Registry.register(Registry.BLOCK, new Identifier(IlliaFabricMod1_19.MOD_ID, name), block);
}
public static Item registerBlockItem(String name, Block block, ItemGroup itemGroup) {
	return Registry.register(Registry.ITEM, new Identifier(IlliaFabricMod1_19.MOD_ID, name),
		new BlockItem(block, new FabricItemSettings().group(itemGroup)));
}
	public static void registerModBlocks() {
		IlliaFabricMod1_19.LOGGER.debug("Registering ModBlocks For " + IlliaFabricMod1_19.MOD_ID);
	}
}
