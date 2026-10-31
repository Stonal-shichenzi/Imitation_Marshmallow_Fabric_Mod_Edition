package cn.stonal.imitation_marshmallow;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
// import net.minecraft.resources.Identifier;

public class ModTags
{
    // 标签创建函数
    private static TagKey<Item> create_item_tag(final String name)
    {
        return TagKey.create(Registries.ITEM, ImitationMarshmallow.id(name));
    }
    private static TagKey<Biome> create_biome_tag(final String name)
    {
        return TagKey.create(Registries.BIOME, ImitationMarshmallow.id(name));
    }
    // 物品标签
    public static final TagKey<Item> MARSHMALLOW_MATERIALS = create_item_tag("marshmallow_materials");
    // 生物群系标签
    public static final TagKey<Biome> CAN_SNOW = create_biome_tag("can_snow");
}
