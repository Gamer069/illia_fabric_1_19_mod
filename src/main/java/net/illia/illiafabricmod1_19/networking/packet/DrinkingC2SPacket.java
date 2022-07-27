package net.illia.illiafabricmod1_19.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.block.Blocks;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;


public class DrinkingC2SPacket {
	private static final String MESSAGE_DRINKING_WATER = "message.illiafabricmod_1_19.drank_water";
	private static final String MESSAGE_WATER_ERROR = "message.illiafabricmod_1_19.error";
	public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
		ServerWorld world = player.getWorld();
		if (isAroundWater(player, world, 2)) {
			player.sendMessage(Text.translatable(MESSAGE_DRINKING_WATER)
				.fillStyle(Style.EMPTY.withColor(Formatting.DARK_PURPLE)), false);
			world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_GENERIC_DRINK, SoundCategory.NEUTRAL, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
		} else {
			player.sendMessage(Text.translatable(MESSAGE_WATER_ERROR).fillStyle(Style.EMPTY.withColor(Formatting.DARK_RED)), true);
		}
		if (isAroundWaterCauldron(player, world, 2)) {
			player.sendMessage(Text.translatable(MESSAGE_DRINKING_WATER)
				.fillStyle(Style.EMPTY.withColor(Formatting.DARK_PURPLE)), false);
			world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_GENERIC_DRINK, SoundCategory.NEUTRAL, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
		} else {
			player.sendMessage(Text.translatable(MESSAGE_WATER_ERROR));
		}
	}

	private static boolean isAroundWaterCauldron(ServerPlayerEntity player, ServerWorld world, int size) {
		return BlockPos.stream(player.getBoundingBox().expand(2))
			.map(player.getWorld()::getBlockState).filter(state -> state.isOf(Blocks.WATER_CAULDRON)).toArray().length > 0;
	}

	private static boolean isAroundWater(ServerPlayerEntity player, ServerWorld world, int size) {
		return BlockPos.stream(player.getBoundingBox().expand(2))
			.map(player.getWorld()::getBlockState).filter(state -> state.isOf(Blocks.WATER)).toArray().length > 0;
	}
}
