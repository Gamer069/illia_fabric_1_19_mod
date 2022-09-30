package net.illia.illiafabricmod1_19.entity.client;

/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import net.illia.illiafabricmod1_19.IlliaFabricMod1_19;
import net.illia.illiafabricmod1_19.entity.custom.SnakeEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SnakeModel extends AnimatedGeoModel<SnakeEntity> {
	@Override
	public Identifier getModelResource(SnakeEntity object) {
		return new Identifier(IlliaFabricMod1_19.MOD_ID, "geo/snake.geo.json");
	}

	@Override
	public Identifier getTextureResource(SnakeEntity object) {
		return new Identifier(IlliaFabricMod1_19.MOD_ID, "textures/entity/snake.png");
	}

	@Override
	public Identifier getAnimationResource(SnakeEntity animatable) {
		return new Identifier(IlliaFabricMod1_19.MOD_ID, "animations/snake.animation.json");
	}
}
