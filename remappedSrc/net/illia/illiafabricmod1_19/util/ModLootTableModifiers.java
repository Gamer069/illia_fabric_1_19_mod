package net.illia.illiafabricmod1_19.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.illia.illiafabricmod1_19.item.ModItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
	public static final Identifier VILLAGE_PLAINS_HOUSE_ID
		= new Identifier("minecraft", "chests/village/village_plains_house");
	public static final Identifier VILLAGE_DESERT_HOUSE_ID
		= new Identifier("minecraft", "chests/village/village_desert_house");
	public static final Identifier VILLAGE_SNOWY_HOUSE_ID
		= new Identifier("minecraft", "chests/village/village_snowy_house");

	public static void modifyLootTables() {
		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (VILLAGE_PLAINS_HOUSE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
					.rolls(ConstantLootNumberProvider.create(1))
					.conditionally(RandomChanceLootCondition.builder(0.31f))
					.with(ItemEntry.builder(ModItems.RUBY))
					.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
				tableBuilder.pool(poolBuilder.build());
			}
			if (VILLAGE_DESERT_HOUSE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
					.rolls(ConstantLootNumberProvider.create(1))
					.conditionally(RandomChanceLootCondition.builder(0.31f))
					.with(ItemEntry.builder(ModItems.RUBY))
					.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
				tableBuilder.pool(poolBuilder.build());
			}
			if (VILLAGE_SNOWY_HOUSE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
					.rolls(ConstantLootNumberProvider.create(1))
					.conditionally(RandomChanceLootCondition.builder(0.31f))
					.with(ItemEntry.builder(ModItems.RUBY))
					.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
				tableBuilder.pool(poolBuilder.build());
			}
		});
	}
}
