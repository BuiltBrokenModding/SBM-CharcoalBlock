package com.builtbroken.ccb.datagen;

import java.util.concurrent.CompletableFuture;

import com.builtbroken.ccb.CharcoalBlock;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

public class BlockTagGenerator extends BlockTagsProvider {
    public BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, CharcoalBlock.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(CharcoalBlock.CHARCOAL_BLOCK.getKey());
        tag(Tags.Blocks.STORAGE_BLOCKS).add(CharcoalBlock.CHARCOAL_BLOCK.getKey());
        tag(CharcoalBlock.BLOCK_TAG).add(CharcoalBlock.CHARCOAL_BLOCK.getKey());
    }
}
