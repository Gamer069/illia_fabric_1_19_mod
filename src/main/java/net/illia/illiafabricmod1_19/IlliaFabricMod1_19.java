package net.illia.illiafabricmod1_19;

import net.fabricmc.api.ModInitializer;
import net.illia.illiafabricmod1_19.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//This Is The Main Mod Class :)
public class IlliaFabricMod1_19 implements ModInitializer {
	public static final String MOD_ID = "illiafabricmod1_19";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}
