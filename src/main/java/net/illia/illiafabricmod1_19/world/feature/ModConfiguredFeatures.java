package net.illia.illiafabricmod1_19.world.feature;

import net.illia.illiafabricmod1_19.IlliaFabricMod1_19;
import net.illia.illiafabricmod1_19.block.ModBlocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
	public static final List<OreFeatureConfig.Target> RUBY_ORES = List.of(
			OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.RUBY_ORE.getDefaultState()),
			OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_RUBY_ORE.getDefaultState()));
	public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> RUBY_ORE =
		ConfiguredFeatures.register("ruby_ore", Feature.ORE, new OreFeatureConfig(RUBY_ORES, 15));
	public static void registerConfiguredFeatures() {
		IlliaFabricMod1_19.LOGGER.debug("Registering The ModConfiguredFeatures For" + IlliaFabricMod1_19.MOD_ID);
	}
}
