package com.builtbroken.ccb;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = CharcoalBlock.MODID, bus = Bus.MOD)
@Mod(CharcoalBlock.MODID)
public class CharcoalBlock
{
    public static final String MODID = "sbmcharcoalblock";
    private static final ResourceLocation CHARCOAL_BLOCK_REGISTRYNAME = new ResourceLocation(CharcoalBlock.MODID, "charcoal_block");

    @SubscribeEvent
    public static void onItemRegistryReady(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(CHARCOAL_ITEMBLOCK);
    }

    @SubscribeEvent
    public static void onBlockRegistryReady(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(CHARCOAL_BLOCK);
    }

    public static final Block CHARCOAL_BLOCK = new Block(Block.Properties.create(Material.ROCK, MaterialColor.BLACK)
            .hardnessAndResistance(5.0F, 10.0F)
            .sound(SoundType.STONE))
            .setRegistryName(CHARCOAL_BLOCK_REGISTRYNAME);

    public static final Item CHARCOAL_ITEMBLOCK = new ItemBlock(CHARCOAL_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
    {
        @Override
        public int getBurnTime(ItemStack itemBlock)
        {
            return 16000;
        }

    }.setRegistryName(CHARCOAL_BLOCK_REGISTRYNAME);
}
