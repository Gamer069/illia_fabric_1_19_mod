package net.illia.illiafabricmod1_19.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.illia.illiafabricmod1_19.IlliaFabricMod1_19;
import net.illia.illiafabricmod1_19.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
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
