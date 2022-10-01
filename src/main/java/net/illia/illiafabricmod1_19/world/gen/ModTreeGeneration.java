package net.illia.illiafabricmod1_19.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.illia.illiafabricmod1_19.world.feature.ModPlacedFeatures;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
	public static void genTrees() {
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TESTWOOD_PLACED.getKey().get());
	}
}
