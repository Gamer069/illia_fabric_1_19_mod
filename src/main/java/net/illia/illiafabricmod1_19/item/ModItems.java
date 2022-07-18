package net.illia.illiafabricmod1_19.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.illia.illiafabricmod1_19.IlliaFabricMod1_19;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
	public static final Item RUBY = registerItem("ruby",
		new Item(new FabricItemSettings().group(ModItemGroup.RUBY)));

	private static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(IlliaFabricMod1_19.MOD_ID, name), item);
	}
	public static void registerModItems() {
		IlliaFabricMod1_19.LOGGER.debug("Registering Mod Items for " + IlliaFabricMod1_19.MOD_ID);
	}
}
