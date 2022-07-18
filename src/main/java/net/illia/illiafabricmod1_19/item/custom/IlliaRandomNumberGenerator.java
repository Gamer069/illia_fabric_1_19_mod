package net.illia.illiafabricmod1_19.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.item.*;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class IlliaRandomNumberGenerator extends Item {
	public IlliaRandomNumberGenerator(Settings settings) {
		super(settings);
	}
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if (!world.isClient() && hand == hand.MAIN_HAND) {
			outputRandomNumberChallenge(user);
			user.getItemCooldownManager().set(this, 199);
		}
//		TODO = (
//		1. outputting a random number
//		2. saying a player that this number is dumb
		/*3. We Are DONE!*/
//		)
		return super.use(world, user, hand);
	}
	private void outputRandomNumberChallenge(PlayerEntity player) {
		player.sendMessage(Text.literal(getRandomNumber() + " Is Dumb, If This Is Your Favorite Number Then You Failed This Challenge :("));
	}
	int nextIntBound = 1000000000;
	private int getRandomNumber() {
		return Random.createLocal().nextInt(nextIntBound);
	}
}
