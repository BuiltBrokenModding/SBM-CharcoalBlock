package com.builtbroken.ccb.datagen;

import com.builtbroken.ccb.CharcoalBlock;

import net.minecraft.advancements.Advancement;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;

public class RecipeGenerator extends RecipeProvider {	public RecipeGenerator(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
    super(recipeOutput, advancementOutput);
    }

    @Override
    protected final void buildRecipes() {
        nineBlockStorageRecipes(RecipeCategory.MISC, Items.CHARCOAL, RecipeCategory.BUILDING_BLOCKS, CharcoalBlock.CHARCOAL_BLOCK_ITEM,
                CharcoalBlock.MODID + ":charcoal_to_charcoal_block",
                "",
                CharcoalBlock.MODID + ":charcoal_block_to_charcoal",
                "");
    }
}
