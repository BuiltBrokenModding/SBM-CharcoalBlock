package com.builtbroken.ccb.datagen;

import java.util.concurrent.CompletableFuture;

import com.builtbroken.ccb.CharcoalBlock;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockTagGenerator extends BlockTagsProvider {
    public BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CharcoalBlock.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(CharcoalBlock.CHARCOAL_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).add(CharcoalBlock.CHARCOAL_BLOCK.get());
        tag(CharcoalBlock.BLOCK_TAG).add(CharcoalBlock.CHARCOAL_BLOCK.get());
    }
}
