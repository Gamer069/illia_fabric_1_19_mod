package net.illia.illiafabricmod1_19.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class IlliaAdvancedBlock extends Block {
	public IlliaAdvancedBlock(Settings settings) {
		super(settings);
	}
	@Override
	public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity,
							  Hand hand, BlockHitResult hitResult) {
		playerEntity.sendMessage(Text.literal(playerEntity.getEntityName() + " Is So Dumb, That He Clicked On This Block :)"));
		playerEntity.kill();
		playerEntity.setMainArm(Arm.LEFT);

		return super.onUse(blockState, world, blockPos, playerEntity, hand, hitResult);
	}
	@Override
	public void onSteppedOn(World YourMinecraftWorld, BlockPos blockPos, BlockState blockState, Entity entity) {
		if (entity instanceof LivingEntity entity1) {
			entity1.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 4));
		}
	}

	@Override
	public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
		PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, true);
		if (player != null) {
			if (player.isPlayer()) {
				player.onDeath(DamageSource.explosion(explosion));
				player.setInvulnerable(true);
				player.requestRespawn();
			}
		}
	}

	@Override
	public PistonBehavior getPistonBehavior(BlockState state) {
		return PistonBehavior.DESTROY;
	}

	@Override
	public float getJumpVelocityMultiplier() {
		return 2.0f;
	}

	@Override
	public float getVelocityMultiplier() {
		return 2.0f;
	}

	@Override
	public float getBlastResistance() {
		return 1000.0f;
	}

	@Override
	public boolean isShapeFullCube(BlockState state, BlockView world, BlockPos pos) {
		return true;
	}
}
