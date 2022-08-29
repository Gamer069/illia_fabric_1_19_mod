package net.illia.illiafabricmod1_19.world.dimension;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.illia.illiafabricmod1_19.IlliaFabricMod1_19;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.kyrptonaught.customportalapi.util.PortalLink;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
	public static final RegistryKey<World> SUPERFLAT_DIMENSION_KEY = RegistryKey.of(Registry.WORLD_KEY, new Identifier(IlliaFabricMod1_19.MOD_ID, "superflat"));
	public static final RegistryKey<DimensionType> SUPERFLAT_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, ModDimensions.SUPERFLAT_DIMENSION_KEY.getValue());
	public static void register() {
		CustomPortalBuilder.beginPortal().frameBlock(Blocks.DIRT).lightWithItem(Items.FLINT_AND_STEEL).onlyLightInOverworld().tintColor(0, 255, 17).destDimID(ModDimensions.SUPERFLAT_DIMENSION_KEY.getValue()).registerPortal();
		CustomPortalApiRegistry.addPortal(Blocks.DIRT, new PortalLink());
	}
}
