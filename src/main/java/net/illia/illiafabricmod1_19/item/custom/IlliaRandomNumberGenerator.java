package net.illia.illiafabricmod1_19.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

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
		return super.use(world, user, hand);
	}
	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		if (Screen.hasShiftDown()) {
			tooltip.add(Text.literal("If You Right Click This Item, you get a random ").formatted(Formatting.GOLD));
			tooltip.add(Text.literal("Number Show Up In Chat, If This Is Your Favorite ").formatted(Formatting.GOLD));
			tooltip.add(Text.literal("Number, You LOSE this Challenge, hahaha").formatted(Formatting.GOLD));
		} else {
			tooltip.add(Text.literal("Press SHIFT For More Info").formatted(Formatting.GOLD));

		}
		super.appendTooltip(stack, world, tooltip, context);
	}
	private void outputRandomNumberChallenge(PlayerEntity player) {
		player.sendMessage(Text.literal(getRandomNumber() + " Is Dumb, If This Is Your Favorite Number Then You Failed This Challenge :("));
	}
	int nextIntBound = 1000000000;
	private int getRandomNumber() {
		return Random.createLocal().nextInt(nextIntBound);
	}
}
