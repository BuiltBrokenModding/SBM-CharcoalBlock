package com.builtbroken.ccb.datagen;

import java.util.List;
import java.util.Set;

import com.builtbroken.ccb.CharcoalBlock;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableProvider.SubProviderEntry;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.event.GatherDataRegistryEntriesEvent;

@EventBusSubscriber(modid = CharcoalBlock.MODID)
public class DataGenRegistrar {
    private DataGenRegistrar() {}

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent.Client event) {
        event.createBlockAndItemTags(BlockTagGenerator::new, ItemTagGenerator::new);
    }

    @SubscribeEvent
    public static void onGatherDataRegistryEntries(GatherDataRegistryEntriesEvent event) {
        event.add(RecipeProvider.asBootstrap(RecipeGenerator::new));
        event.add(Registries.LOOT_TABLE, new LootTableProvider(Set.of(), List.of(new SubProviderEntry(BlockLootTableGenerator::new, LootContextParamSets.BLOCK))));
    }
}
