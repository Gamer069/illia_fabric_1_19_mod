package net.illia.illiafabricmod1_19.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
	public void onSteppedOn(World YourMinecraftWorld, BlockPos blockPos, BlockState blockState, Entity MinecraftEntityThatIsExtremelyNormal) {
		if (MinecraftEntityThatIsExtremelyNormal instanceof LivingEntity MinecraftLivingEntityThatIsLivingCosItIsLivingAkaSmileyFace) {
			MinecraftLivingEntityThatIsLivingCosItIsLivingAkaSmileyFace.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 4));
		}
	}
}
