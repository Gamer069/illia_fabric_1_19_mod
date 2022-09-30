package net.illia.illiafabricmod1_19.item.custom;

import net.illia.illiafabricmod1_19.gui.TestGui;
import net.illia.illiafabricmod1_19.gui.TestScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GuiTestItem extends Item {
	public GuiTestItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		MinecraftClient.getInstance().setScreen(new TestScreen(new TestGui()));
		return super.use(world, user, hand);
	}
}
