package net.illia.illiafabricmod1_19.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.illia.illiafabricmod1_19.IlliaFabricMod1_19;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
	public static final ItemGroup RUBY = FabricItemGroupBuilder.build(
		new Identifier(IlliaFabricMod1_19.MOD_ID, "ruby"), () -> new ItemStack(ModItems.RUBY));
}
