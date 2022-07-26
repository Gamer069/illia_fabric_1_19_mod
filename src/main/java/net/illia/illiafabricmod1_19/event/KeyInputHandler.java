package net.illia.illiafabricmod1_19.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
	public static final String KEY_CATEGORY_ILLIA_MOD = "key.category.illiafabricmod_1_19.illia_mod";
	public static final String ILLIA_KEYBIND = "key.illiafabricmod_1_19.illia_keybind";
	public static KeyBinding illiaKeybind;

	public static void registerKeyInputs() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (illiaKeybind.wasPressed()) {
				client.player.sendChatMessage("TEST IS A TEST, WHY DID YOU TESTED THIS TEST?");
			}
		});
	}
	public static void register() {
		illiaKeybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
			ILLIA_KEYBIND,
			InputUtil.Type.KEYSYM,
			GLFW.GLFW_KEY_I,
			KEY_CATEGORY_ILLIA_MOD
		));
		registerKeyInputs();
	}
}
