package net.illia.illiafabricmod1_19;

import net.fabricmc.api.ClientModInitializer;
import net.illia.illiafabricmod1_19.event.KeyInputHandler;
import net.illia.illiafabricmod1_19.networking.ModMessages;

public class IlliaFabricMod1_19Client implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		System.out.println("... Minecraft Is Loaded");
		KeyInputHandler.register();
		ModMessages.registerS2CPackets();


	}
}
