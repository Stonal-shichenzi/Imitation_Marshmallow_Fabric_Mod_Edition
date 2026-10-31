package cn.stonal.imitation_marshmallow;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import java.util.function.Function;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.core.component.DataComponents;

public class ModItems
{
    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings)
    {
        // 创建物品实例
        Item item = itemFactory.apply(settings.setId(itemKey));
        // 注册物品
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }
    public static void initialize()
    {
        DefaultItemComponentEvents.MODIFY.register(context -> {
            context.modify(MARSHMALLOW, builder -> {
                builder.<Integer>set(DataComponents.MAX_DAMAGE, null);
                builder.<Integer>set(DataComponents.MAX_STACK_SIZE, 16);
            });
            context.modify(COOKED_MARSHMALLOW, builder -> {
                builder.<Integer>set(DataComponents.MAX_DAMAGE, null);
                builder.<Integer>set(DataComponents.MAX_STACK_SIZE, 16);
            });
        });
    }
    private static ToolMaterial material_marshmallow = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 59, 2, 0, 15, ModTags.MARSHMALLOW_MATERIALS);
    private static ItemAttributeModifiers attribute_marshmallow = ItemAttributeModifiers.builder()
        .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(ImitationMarshmallow.id("base_attack_damage"), 0.5, Operation.ADD_VALUE), EquipmentSlotGroup.ANY)
        .add(Attributes.ATTACK_SPEED, new AttributeModifier(ImitationMarshmallow.id("base_attack_speed"), 1.54f, Operation.ADD_VALUE), EquipmentSlotGroup.ANY)
        .add(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(ImitationMarshmallow.id("knockback"), 3, Operation.ADD_VALUE), EquipmentSlotGroup.ANY)
        .build();
    private static ItemAttributeModifiers attribute_marshmallow_cooked = ItemAttributeModifiers.builder()
        .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(ImitationMarshmallow.id("base_attack_damage"), 2, Operation.ADD_VALUE), EquipmentSlotGroup.ANY)
        .add(Attributes.ATTACK_SPEED, new AttributeModifier(ImitationMarshmallow.id("base_attack_speed"), 1.54f, Operation.ADD_VALUE), EquipmentSlotGroup.ANY)
        .add(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(ImitationMarshmallow.id("knockback"), 1, Operation.ADD_VALUE), EquipmentSlotGroup.ANY)
        .build();
    private static Item.Properties property_marshmallow = new Item.Properties().stacksTo(16)
        .spear(material_marshmallow, 0.65f /* 单位 秒 */, 0.7f, 0.75f, 5.0f, 14.0f, 10.0f, 5.1f, 15.0f, 4.6f).attributes(attribute_marshmallow);
    private static Item.Properties property_marshmallow_cooked = new Item.Properties().stacksTo(16)
        .spear(material_marshmallow, 0.65f /* 单位 秒 */, 0.7f, 0.75f, 5.0f, 14.0f, 10.0f, 5.1f, 15.0f, 4.6f).attributes(attribute_marshmallow_cooked);
    public static final Item MARSHMALLOW = register(ModItemIds.MARSHMALLOW, Marshmallow::new, property_marshmallow);
    public static final Item COOKED_MARSHMALLOW = register(ModItemIds.COOKED_MARSHMALLOW, CookedMarshmallow::new, property_marshmallow_cooked);
}
