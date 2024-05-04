package com.builtbroken.ccb.datagen;

import java.util.Set;

import com.builtbroken.ccb.CharcoalBlock;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

public class BlockLootTableGenerator extends BlockLootSubProvider {
    protected BlockLootTableGenerator() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        dropSelf(CharcoalBlock.CHARCOAL_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return (Iterable<Block>) CharcoalBlock.BLOCKS.getEntries().stream().map(DeferredHolder::get).toList();
    }
}
