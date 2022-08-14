package net.illia.illiafabricmod1_19;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.illia.illiafabricmod1_19.client.ThirstHudOverlay;
import net.illia.illiafabricmod1_19.event.KeyInputHandler;
import net.illia.illiafabricmod1_19.networking.ModMessages;

@Environment(EnvType.CLIENT)
public class IlliaFabricMod1_19Client implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		System.out.println("... Minecraft Is Loaded");
		KeyInputHandler.register();
		ModMessages.registerS2CPackets();
		HudRenderCallback.EVENT.register(new ThirstHudOverlay());
	}
}
