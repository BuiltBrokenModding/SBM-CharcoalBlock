package com.builtbroken.ccb.datagen;

import java.util.concurrent.CompletableFuture;

import com.builtbroken.ccb.CharcoalBlock;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

public class RecipeGenerator extends RecipeProvider {
    public RecipeGenerator(HolderLookup.Provider lookupProvider, RecipeOutput output) {
        super(lookupProvider, output);
    }

    @Override
    protected final void buildRecipes() {
        nineBlockStorageRecipes(RecipeCategory.MISC, Items.CHARCOAL, RecipeCategory.BUILDING_BLOCKS, CharcoalBlock.CHARCOAL_BLOCK_ITEM,
                CharcoalBlock.MODID + ":charcoal_to_charcoal_block",
                "",
                CharcoalBlock.MODID + ":charcoal_block_to_charcoal",
                "");
    }

    public static final class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider lookupProvider, RecipeOutput output) {
            return new RecipeGenerator(lookupProvider, output);
        }

        @Override
        public String getName() {
            return "Charcoal Block recipes";
        }
    }
}
