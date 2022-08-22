package net.illia.illiafabricmod1_19.screen;

import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
	public static ScreenHandlerType<DiamondCraftingTableScreenHandler> DIAMOND_CRAFTING_TABLE_SCREEN_HANDLER;

	public static void registerAllScreenHandlers() {
		DIAMOND_CRAFTING_TABLE_SCREEN_HANDLER = new ScreenHandlerType<>(DiamondCraftingTableScreenHandler::new);
	}
}
