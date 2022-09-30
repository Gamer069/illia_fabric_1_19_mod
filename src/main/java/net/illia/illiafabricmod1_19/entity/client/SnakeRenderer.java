package net.illia.illiafabricmod1_19.entity.client;

import net.illia.illiafabricmod1_19.IlliaFabricMod1_19;
import net.illia.illiafabricmod1_19.entity.custom.SnakeEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SnakeRenderer extends GeoEntityRenderer<SnakeEntity> {
	public SnakeRenderer(EntityRendererFactory.Context ctx) {
		super(ctx, new SnakeModel());
		this.shadowRadius = 0.01f;
		this.shadowOpacity = 10f;
	}

	@Override
	public Identifier getTextureResource(SnakeEntity instance) {
		return new Identifier(IlliaFabricMod1_19.MOD_ID, "textures/entity/snake.png");
	}

	@Override
	public RenderLayer getRenderType(SnakeEntity animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
		return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
	}
}
