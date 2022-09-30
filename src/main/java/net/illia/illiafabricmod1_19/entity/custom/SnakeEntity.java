package net.illia.illiafabricmod1_19.entity.custom;

/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class SnakeEntity extends HostileEntity implements IAnimatable {
	private AnimationFactory factory = new AnimationFactory(this);
	public SnakeEntity(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
	}
	public static DefaultAttributeContainer.Builder setAttributes() {
		return HostileEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 5.1D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0f).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.1f).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f);
	}

	@Override
	public SoundCategory getSoundCategory() {
		return SoundCategory.HOSTILE;
	}

	private<E extends IAnimatable>PlayState predicate(AnimationEvent<E> event) {
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.snake.idle", true));
		return PlayState.CONTINUE;
	}
	@Override
	public void registerControllers(AnimationData animationData) {
		animationData.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return factory;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return SoundEvents.AMBIENT_CAVE;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.ENTITY_PIG_HURT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_CHICKEN_DEATH;
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState state) {
		super.playSound(SoundEvents.ENTITY_PIG_STEP, 10.0f, 2.0f);
	}

	@Override
	public void initGoals() {
		this.goalSelector.add(0, new AttackGoal(this));
		this.goalSelector.add(1, new MeleeAttackGoal(this, 0.2D, false));
		this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.1, 20));
		this.goalSelector.add(3, new SwimGoal(this));
		this.goalSelector.add(4, new SwimAroundGoal(this, 9, 1));
		this.goalSelector.add(5, new LookAroundGoal(this));

		this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.add(1, new ActiveTargetGoal<>(this, MerchantEntity.class, true));
		this.targetSelector.add(2, new ActiveTargetGoal<>(this, MerchantEntity.class, true));
		this.targetSelector.add(2, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
		this.targetSelector.add(0, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
	}
}
