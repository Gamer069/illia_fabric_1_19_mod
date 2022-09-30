package net.illia.illiafabricmod1_19.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.illia.illiafabricmod1_19.block.ModBlocks;

public class ModFlammableBlocks {
	public static void registerFlammableBlocks() {
		FlammableBlockRegistry flammableBlockRegistry = FlammableBlockRegistry.getDefaultInstance();
		flammableBlockRegistry.add(ModBlocks.TEST_LOG, 5, 5);
		flammableBlockRegistry.add(ModBlocks.TEST_WOOD, 5, 5);
		flammableBlockRegistry.add(ModBlocks.STRIPPED_TEST_WOOD, 5, 5);
		flammableBlockRegistry.add(ModBlocks.STRIPPED_TEST_LOG, 5, 5);
		flammableBlockRegistry.add(ModBlocks.TEST_PLANKS, 5, 20);
		flammableBlockRegistry.add(ModBlocks.TEST_LEAVES, 30, 60);
	}
}
