package com.builtbroken.ccb;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@EventBusSubscriber
@Mod(modid = CharcoalBlock.MODID, name = "SBM Charcoal Block", version = "1.0.0", acceptedMinecraftVersions = "1.12")
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

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegistryReady(ModelRegistryEvent event)
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(CHARCOAL_BLOCK), 0, new ModelResourceLocation(CHARCOAL_BLOCK_REGISTRYNAME, "inventory"));
    }

    public static final Block CHARCOAL_BLOCK = new Block(Material.ROCK, MapColor.BLACK)
    {
        @Override
        public SoundType getSoundType(IBlockState state, World world, BlockPos pos, @Nullable Entity entity)
        {
            return SoundType.STONE;
        }

    }.setRegistryName(CHARCOAL_BLOCK_REGISTRYNAME)
            .setTranslationKey(CHARCOAL_BLOCK_REGISTRYNAME.toString())
            .setHardness(5.0F)
            .setResistance(10.0F)
            .setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

    public static final Item CHARCOAL_ITEMBLOCK = new ItemBlock(CHARCOAL_BLOCK)
    {
        @Override
        public int getItemBurnTime(ItemStack itemBlock)
        {
            return 16000;
        }

    }.setRegistryName(CHARCOAL_BLOCK_REGISTRYNAME)
            .setTranslationKey(CHARCOAL_BLOCK_REGISTRYNAME.toString());
}
