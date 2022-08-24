package net.illia.illiafabricmod1_19.screen;

import net.illia.illiafabricmod1_19.IlliaFabricMod1_19;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModScreenHandlers {
	public static ScreenHandlerType<DiamondCraftingTableScreenHandler> DIAMOND_CRAFTING_TABLE_SCREEN_HANDLER = new ScreenHandlerType<>(DiamondCraftingTableScreenHandler::new);
	public static void registerAllScreenHandlers() {
		Registry.register(Registry.SCREEN_HANDLER, new Identifier(IlliaFabricMod1_19.MOD_ID, "diamond_crafting_table_screen_handler"), DIAMOND_CRAFTING_TABLE_SCREEN_HANDLER);
	}
}
