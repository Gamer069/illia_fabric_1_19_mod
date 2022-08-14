package net.illia.illiafabricmod1_19;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.illia.illiafabricmod1_19.client.ThirstHudOverlay;
import net.illia.illiafabricmod1_19.event.KeyInputHandler;
import net.illia.illiafabricmod1_19.fluid.ModFluids;
import net.illia.illiafabricmod1_19.networking.ModMessages;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class IlliaFabricMod1_19Client implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		System.out.println("... Minecraft Is Loaded");
		KeyInputHandler.register();
		ModMessages.registerS2CPackets();
		HudRenderCallback.EVENT.register(new ThirstHudOverlay());
		FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_MELTED_RUBY_FLUID, ModFluids.FLOWING_MELTED_RUBY_FLUID, new SimpleFluidRenderHandler(new Identifier("minecraft:block/water_still"), new Identifier("minecraft:block/water_flow"), 0xA1E038D0));
		BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_MELTED_RUBY_FLUID, ModFluids.FLOWING_MELTED_RUBY_FLUID);
	}
}
