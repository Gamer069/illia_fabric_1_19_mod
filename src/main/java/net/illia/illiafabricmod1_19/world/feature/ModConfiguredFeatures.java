package net.illia.illiafabricmod1_19.world.feature;

import net.illia.illiafabricmod1_19.IlliaFabricMod1_19;
import net.illia.illiafabricmod1_19.block.ModBlocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
	public static final List<OreFeatureConfig.Target> RUBY_ORES = List.of(
			OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.RUBY_ORE.getDefaultState()),
			OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_RUBY_ORE.getDefaultState()));
	public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> RUBY_ORE =
		ConfiguredFeatures.register("ruby_ore", Feature.ORE, new OreFeatureConfig(RUBY_ORES, 15));
	public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> TEST_TREE = ConfiguredFeatures.register("test_tree", Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(ModBlocks.TEST_LOG), new StraightTrunkPlacer(5, 6, 3), BlockStateProvider.of(ModBlocks.TEST_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4), new TwoLayersFeatureSize(1, 0, 2)).build());
	public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> TEST_TREE_SPAWN = ConfiguredFeatures.register("test_tree_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(ModPlacedFeatures.TESTWOOD_CHECKED, 0.5f)), ModPlacedFeatures.TESTWOOD_CHECKED));
	public static void registerConfiguredFeatures() {
		IlliaFabricMod1_19.LOGGER.warn("Registering The ModConfiguredFeatures For" + IlliaFabricMod1_19.MOD_ID);
	}
}
