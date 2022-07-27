package net.illia.illiafabricmod1_19.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.illia.illiafabricmod1_19.IlliaFabricMod1_19;
import net.illia.illiafabricmod1_19.networking.packet.DrinkingC2SPacket;
import net.illia.illiafabricmod1_19.networking.packet.ExampleC2SPacket;
import net.minecraft.util.Identifier;

public class ModMessages {
	public static final Identifier DRINKING_ID = new Identifier(IlliaFabricMod1_19.MOD_ID, "drinking");
	public static final Identifier THIRST_SYNC_ID = new Identifier(IlliaFabricMod1_19.MOD_ID, "thirst_sync");
	public static final Identifier EXAMPLE_ID = new Identifier(IlliaFabricMod1_19.MOD_ID, "example");

	public static void registerC2SPackets() {
		ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExampleC2SPacket::receive);
		ServerPlayNetworking.registerGlobalReceiver(DRINKING_ID, DrinkingC2SPacket::receive);
	}
	public static void registerS2CPackets() {

	}
}
