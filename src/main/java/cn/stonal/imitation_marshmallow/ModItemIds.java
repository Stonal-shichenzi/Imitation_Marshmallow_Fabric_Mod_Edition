package cn.stonal.imitation_marshmallow;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.core.registries.Registries;

public class ModItemIds
{
    public static ResourceKey<Item> create(String name)
    {
        return ResourceKey.create(Registries.ITEM, ImitationMarshmallow.id(name));
    }
    public static final ResourceKey<Item> MARSHMALLOW = create("marshmallow");
    public static final ResourceKey<Item> COOKED_MARSHMALLOW = create("cooked_marshmallow");
}
