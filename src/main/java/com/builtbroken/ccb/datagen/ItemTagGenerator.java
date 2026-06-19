package com.builtbroken.ccb.datagen;

import java.util.concurrent.CompletableFuture;

import com.builtbroken.ccb.CharcoalBlock;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagCopyingItemTagProvider;

public class ItemTagGenerator extends BlockTagCopyingItemTagProvider {
    public ItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags, CharcoalBlock.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(CharcoalBlock.ITEM_TAG).add(CharcoalBlock.CHARCOAL_BLOCK_ITEM.getKey());
    }
}
