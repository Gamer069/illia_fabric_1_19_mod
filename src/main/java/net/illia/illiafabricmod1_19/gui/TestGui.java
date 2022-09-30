package net.illia.illiafabricmod1_19.gui;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class TestGui extends LightweightGuiDescription {
	public TestGui() {
		WGridPanel root = new WGridPanel();
		WLabel label = new WLabel(Text.literal("TEST GUI"));
		WButton button = new WButton(Text.literal("CLICK ME RN"));
		button.setOnClick(() -> MinecraftClient.getInstance().player.sendChatMessage("I CLICKED DA BUTTON", Text.literal("I CLICKED DA BUTTON")));
		if (label.isHovered()) {
			label.setText(Text.literal("Congrats, You Found Out An Easter Egg :)"));
		};
		setRootPanel(root);
		root.add(button, 8, 5, 110, 20);
		root.add(label, 6, 1);
		root.setSize(200, 100);
	}
}
