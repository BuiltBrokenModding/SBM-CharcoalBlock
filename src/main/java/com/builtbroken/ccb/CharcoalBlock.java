package com.builtbroken.ccb;


import javax.annotation.Nullable;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(modid = CharcoalBlock.MODID, bus = Bus.MOD)
@Mod(CharcoalBlock.MODID)
public class CharcoalBlock
{
    public static final String MODID = "sbmcharcoalblock";
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Block> CHARCOAL_BLOCK = BLOCKS.register("charcoal_block", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
            .strength(5.0F, 10.0F)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> CHARCOAL_BLOCK_ITEM = ITEMS.register("charcoal_block", () -> new BlockItem(CHARCOAL_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS))
    {
        @Override
        public int getBurnTime(ItemStack itemBlock, @Nullable RecipeType<?> recipeType)
        {
            return 16000;
        }
    });

    public CharcoalBlock()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
    }
}
