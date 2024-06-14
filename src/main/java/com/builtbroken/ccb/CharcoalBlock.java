package com.builtbroken.ccb;

import javax.annotation.Nullable;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(modid = CharcoalBlock.MODID, bus = Bus.MOD)
@Mod(CharcoalBlock.MODID)
public class CharcoalBlock
{
    public static final String MODID = "sbmcharcoalblock", NAME = "charcoal_block";
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredBlock<Block> CHARCOAL_BLOCK = BLOCKS.registerSimpleBlock(NAME, BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLACK)
            .strength(5.0F, 10.0F)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops());
    public static final DeferredItem<BlockItem> CHARCOAL_BLOCK_ITEM = ITEMS.register(NAME, () -> new BlockItem(CHARCOAL_BLOCK.get(), new Item.Properties())
    {
        @Override
        public int getBurnTime(ItemStack itemBlock, @Nullable RecipeType<?> recipeType)
        {
            return 16000;
        }
    });
    public static final TagKey<Block> BLOCK_TAG = BlockTags.create(ResourceLocation.fromNamespaceAndPath(MODID, NAME));
    public static final TagKey<Item> ITEM_TAG = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MODID, NAME));

    public CharcoalBlock(IEventBus modEventBus)
    {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
    }

    @SubscribeEvent
    public static void onCreativeModeTabBuildContents(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.getEntries().putAfter(new ItemStack(Blocks.COAL_BLOCK), new ItemStack(CHARCOAL_BLOCK_ITEM.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
    }
}
