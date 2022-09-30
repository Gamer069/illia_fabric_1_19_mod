package net.illia.illiafabricmod1_19.world.feature;

import net.illia.illiafabricmod1_19.block.ModBlocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
	public static final RegistryEntry<PlacedFeature> TESTWOOD_CHECKED = PlacedFeatures.register("testwood_checked",
		ModConfiguredFeatures.TEST_TREE, List.of(PlacedFeatures.wouldSurvive(ModBlocks.TEST_SAPLING)));
	public static final RegistryEntry<PlacedFeature> RUBY_ORE_PLACED = PlacedFeatures.register("ruby_ore_placed",
		ModConfiguredFeatures.RUBY_ORE, modifiersWithCount(9,
			HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80))));
	public static final RegistryEntry<PlacedFeature> TESTWOOD_PLACED = PlacedFeatures.register("testwood_placed", ModConfiguredFeatures.TEST_TREE_SPAWN, VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));
	private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
		return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
	}
	private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
		return modifiers(CountPlacementModifier.of(count), heightModifier);
	}
	private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
		return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
	}
}
