package net.illia.illiafabricmod1_19.mixin;

import net.illia.illiafabricmod1_19.IlliaFabricMod1_19;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		IlliaFabricMod1_19.LOGGER.info("This line is printed by an example mod mixin!");
	}
}
