package com.builtbroken.ccb;


import javax.annotation.Nullable;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber(modid = CharcoalBlock.MODID, bus = Bus.MOD)
@Mod(CharcoalBlock.MODID)
public class CharcoalBlock
{
    public static final String MODID = "sbmcharcoalblock";
    private static final ResourceLocation CHARCOAL_BLOCK_REGISTRYNAME = new ResourceLocation(CharcoalBlock.MODID, "charcoal_block");

    @SubscribeEvent
    public static void onBlockRegistryReady(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(new Block(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
                .strength(5.0F, 10.0F)
                .sound(SoundType.STONE)
                .requiresCorrectToolForDrops())
                .setRegistryName(CHARCOAL_BLOCK_REGISTRYNAME));
    }

    @SubscribeEvent
    public static void onItemRegistryReady(RegistryEvent.Register<Item> event)
    {
        final Block block = ForgeRegistries.BLOCKS.getValue(CHARCOAL_BLOCK_REGISTRYNAME);
        event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS))
        {
            @Override
            public int getBurnTime(ItemStack itemBlock, @Nullable RecipeType<?> recipeType)
            {
                return 16000;
            }

        }.setRegistryName(CHARCOAL_BLOCK_REGISTRYNAME));
    }
}
