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

@EventBusSubscriber(modid = CharcoalBlock.MODID)
public class DataGenRegistrar {
    private DataGenRegistrar() {}

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent.Client event) {
        event.createBlockAndItemTags(BlockTagGenerator::new, ItemTagGenerator::new);
        event.createReloadableRegistryObjects(
            new RegistrySetBuilder()
                .add(RecipeProvider.asBootstrap(RecipeGenerator::new))
                .add(Registries.LOOT_TABLE, new LootTableProvider(Set.of(), List.of(new SubProviderEntry(BlockLootTableGenerator::new, LootContextParamSets.BLOCK)))),
            Set.of(CharcoalBlock.MODID)
        );
    }
}
