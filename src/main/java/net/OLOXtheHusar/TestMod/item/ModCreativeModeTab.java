package net.OLOXtheHusar.TestMod.item;

import net.OLOXtheHusar.TestMod.TestMod;
import net.OLOXtheHusar.TestMod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> OLOXS_ITEMS_TAB = CREATIVE_MODE_TABS.register("oloxs_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.OPAL.get()))
                    .title(Component.translatable("creativetab.testmod.oloxs_items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.OPAL.get());
                        output.accept(ModItems.SAPPHIRE.get());

                        output.accept(ModItems.RAW_OPAL.get());
                        output.accept(ModItems.RAW_SAPPHIRE.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> OLOXS_BLOCKS_TAB = CREATIVE_MODE_TABS.register("olox_blocks_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(OLOXS_ITEMS_TAB.getId())
                    .icon(() -> new ItemStack(ModBlocks.OPAL_BLOCK.get()))
                    .title(Component.translatable("creativetab.testmod.oloxs_blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.OPAL_BLOCK.get());
                        output.accept(ModBlocks.RAW_OPAL_BLOCK.get());
                        output.accept(ModBlocks.OPAL_ORE_BLOCK.get());
                        output.accept(ModBlocks.OPAL_DEEPSLATE_ORE_BLOCK.get());

                        output.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
                        output.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        output.accept(ModBlocks.SAPPHIRE_DEEPSLATE_ORE_BLOCK.get());
                    }).build());



    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
