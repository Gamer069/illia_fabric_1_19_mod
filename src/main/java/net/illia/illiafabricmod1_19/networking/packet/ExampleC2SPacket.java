package net.illia.illiafabricmod1_19.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

public class ExampleC2SPacket {
	public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
							   PacketByteBuf buf, PacketSender responseSender) {
		EntityType.COW.spawn(((ServerWorld) player.world), null, Text.of("cow"), player, player.getBlockPos(),
			SpawnReason.TRIGGERED, true, false);
	}
}
