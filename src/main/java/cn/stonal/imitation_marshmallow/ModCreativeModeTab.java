package cn.stonal.imitation_marshmallow;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.BuiltInRegistries;

public class ModCreativeModeTab {
    public static final ResourceKey<CreativeModeTab> COMBAT_TAB_KEY = ResourceKey.create(
        BuiltInRegistries.CREATIVE_MODE_TAB.key(),
        Identifier.fromNamespaceAndPath("minecraft", "combat")
    );
    public static void initialize()
    {
        CreativeModeTabEvents.modifyOutputEvent(COMBAT_TAB_KEY).register((output) -> {
            output.insertAfter(new ItemStack(Items.NETHERITE_SPEAR), new ItemStack(ModItems.MARSHMALLOW));
            output.insertAfter(new ItemStack(ModItems.MARSHMALLOW), new ItemStack(ModItems.COOKED_MARSHMALLOW));
        });
    }
}
