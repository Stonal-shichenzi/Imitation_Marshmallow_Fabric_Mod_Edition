package cn.stonal.imitation_marshmallow;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.player.Player;

public class CookedMarshmallow extends Item
{
    public CookedMarshmallow(Properties properties)
    {
        super(properties);
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        super.hurtEnemy(stack, target, attacker);
        final Level LEVEL = target.level();
        BlockPos position = target.blockPosition();
        Holder<Biome> biome_holder = LEVEL.getBiome(position);
        boolean is_snowing = LEVEL.isRaining() && biome_holder.is(ModTags.CAN_SNOW);
        ImitationMarshmallow.LOGGER.info(
            "Is raining? {}; Is in #can_snow? {}",
            LEVEL.isRaining() ? "true" : "false",
            biome_holder.is(ModTags.CAN_SNOW) ? "true" : "false"
        );
        boolean able_shrink = true, is_creative = false;
        if(LEVEL instanceof ServerLevel server_level)
            able_shrink = server_level.getGameRules().get(ModGameRules.CREATIVE_MOD_MARSHMALLOW_SHRINK);
        if(attacker instanceof Player player)
            is_creative = player.isCreative();
        boolean allow_to_shrink = able_shrink || !is_creative;
        boolean posibility_1_in_5 = Reference.random_integer(0, 4, true) == 0;
        if(posibility_1_in_5)
        {
            ImitationMarshmallow.LOGGER.debug("Random check succeeded: probability 0.2");
            ImitationMarshmallow.LOGGER.debug(
                "Able to sbrink:\n|- creative {}\n|- gamerule {}",
                Reference.to_integer(is_creative),                  // creative 日志输出
                Reference.to_integer(able_shrink)                   // gamerule 日志输出
            );
            ImitationMarshmallow.LOGGER.info("Is snowing? {}", is_snowing ? "true" : "false");
            ImitationMarshmallow.LOGGER.info("Is allow_to_shrink && is_snowing? {}", (allow_to_shrink && is_snowing) ? "true" : "false");
            if(is_snowing)
            {
                target.setTicksFrozen(2000);
                ImitationMarshmallow.LOGGER.info("TicksFrozen -> {}", target.getTicksFrozen());
            }
            MobEffectInstance levitation_effect = new MobEffectInstance(MobEffects.LEVITATION, 200, 0);
            MobEffectInstance slowness_effect = new MobEffectInstance(MobEffects.SLOWNESS, 200, 0);
            target.addEffect(levitation_effect);
            target.addEffect(slowness_effect);
            if(allow_to_shrink)
            {
                stack.shrink(1);
                ItemStack stick_stack = new ItemStack(Items.STICK, 2);
                if(attacker instanceof Player player)
                {
                    player.getInventory().add(stick_stack);
                    player.getFoodData().eat(6, 0f);
                }
                else if(LEVEL instanceof ServerLevel server_level)
                    target.spawnAtLocation(server_level, stick_stack);
            }
        }
        else
        {
            ImitationMarshmallow.LOGGER.info("Random check failed: not in the probability of 0.2; attacked actually");
        }
    }
}
