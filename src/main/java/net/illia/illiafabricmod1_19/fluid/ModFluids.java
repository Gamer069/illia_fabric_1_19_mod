package net.illia.illiafabricmod1_19.fluid;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.illia.illiafabricmod1_19.IlliaFabricMod1_19;
import net.illia.illiafabricmod1_19.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {
	public static FlowableFluid STILL_MELTED_RUBY_FLUID;
	public static FlowableFluid FLOWING_MELTED_RUBY_FLUID;
	public static Block MELTED_RUBY_BLOCK;
	public static Item MELTED_RUBY_BUCKET;
	public static void register() {
		STILL_MELTED_RUBY_FLUID = Registry.register(Registry.FLUID, new Identifier(IlliaFabricMod1_19.MOD_ID, "still_melted_ruby"), new MeltedRubyFluid.Still());
		FLOWING_MELTED_RUBY_FLUID = Registry.register(Registry.FLUID, new Identifier(IlliaFabricMod1_19.MOD_ID, "flowing_melted_ruby"), new MeltedRubyFluid.Flowing());
		MELTED_RUBY_BLOCK = Registry.register(Registry.BLOCK, new Identifier(IlliaFabricMod1_19.MOD_ID, "melted_ruby_block"), new FluidBlock(ModFluids.STILL_MELTED_RUBY_FLUID, FabricBlockSettings.copyOf(Blocks.WATER)) { } );
		MELTED_RUBY_BUCKET = Registry.register(Registry.ITEM, new Identifier(IlliaFabricMod1_19.MOD_ID, "melted_ruby_bucket"), new BucketItem(ModFluids.STILL_MELTED_RUBY_FLUID, new FabricItemSettings().group(ModItemGroup.RUBY).recipeRemainder(Items.BUCKET).maxCount(1)));
	}
}
