package net.illia.illiafabricmod1_19;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.illia.illiafabricmod1_19.block.ModBlocks;
import net.illia.illiafabricmod1_19.block.entity.ModBlockEntities;
import net.illia.illiafabricmod1_19.event.PlayerTickHandler;
import net.illia.illiafabricmod1_19.fluid.ModFluids;
import net.illia.illiafabricmod1_19.item.ModItems;
import net.illia.illiafabricmod1_19.networking.ModMessages;
import net.illia.illiafabricmod1_19.screen.ModScreenHandlers;
import net.illia.illiafabricmod1_19.util.ModLootTableModifiers;
import net.illia.illiafabricmod1_19.world.feature.ModConfiguredFeatures;
import net.illia.illiafabricmod1_19.world.gen.ModOreGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//This Is The Main Mod Class :)
public class IlliaFabricMod1_19 implements ModInitializer {
	public static final String MOD_ID = "illiafabricmod1_19";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();

		ModBlocks.registerModBlocks();

		ModOreGeneration.generateOres();

		ModLootTableModifiers.modifyLootTables();

		ModMessages.registerC2SPackets();

		ModFluids.register();

		ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());

		ModBlockEntities.registerBlockEntities();

		ModScreenHandlers.registerAllScreenHandlers();

	}
}
