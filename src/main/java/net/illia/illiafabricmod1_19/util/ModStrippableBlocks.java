package net.illia.illiafabricmod1_19.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.illia.illiafabricmod1_19.block.ModBlocks;

public class ModStrippableBlocks {
	public static void registerStrippables() {
		StrippableBlockRegistry.register(ModBlocks.TEST_WOOD, ModBlocks.STRIPPED_TEST_WOOD);
		StrippableBlockRegistry.register(ModBlocks.TEST_LOG, ModBlocks.STRIPPED_TEST_LOG);
	}
}
