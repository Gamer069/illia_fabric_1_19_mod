package net.illia.illiafabricmod1_19.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.illia.illiafabricmod1_19.IlliaFabricMod1_19;
import net.illia.illiafabricmod1_19.util.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ThirstHudOverlay implements HudRenderCallback {
	private static final Identifier FULL_THIRST = new Identifier(IlliaFabricMod1_19.MOD_ID, "textures/hud/thirst/filled_thirst.png");
	private static final Identifier EMPTY_THIRST = new Identifier(IlliaFabricMod1_19.MOD_ID, "textures/hud/thirst/empty_thirst.png");
	@Override
	public void onHudRender(MatrixStack matrixStack, float tickDelta) {
		int x = 0;
		int y = 0;
		MinecraftClient client = MinecraftClient.getInstance();
		if (client != null) {
			int width = client.getWindow().getWidth();
			int height = client.getWindow().getHeight();
			x = width / 2;
			y = height;
		}
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		RenderSystem.setShaderTexture(0, EMPTY_THIRST);
		for (int i = 0; i < 10; i++) {
			DrawableHelper.drawTexture(matrixStack, x - 94 + (i * 9), y - 54, 0, 0, 12, 12, 12, 12);
		}
		RenderSystem.setShaderTexture(0, FULL_THIRST);
		for (int i = 0; i < 10; i++) {
			if (((IEntityDataSaver) MinecraftClient.getInstance().player).getPersistentData().getInt("thirst") > i) {
				DrawableHelper.drawTexture(matrixStack, x - 94 + (i * 9), y - 54, 0, 0, 12, 12, 12, 12);
			} else {
				break;
			}
		}
	}
}
