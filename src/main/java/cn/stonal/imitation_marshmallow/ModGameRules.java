package cn.stonal.imitation_marshmallow;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.resources.Identifier;

public class ModGameRules {
    public static final GameRule<Boolean> CREATIVE_MOD_MARSHMALLOW_SHRINK = GameRuleBuilder
        .forBoolean(true)
        .category(GameRuleCategory.PLAYER)
        .buildAndRegister(Identifier.fromNamespaceAndPath(
            ImitationMarshmallow.MOD_ID, "creative_mod_marshmallow_shrink"
        )
    );
    /*
        public static final GameRule<Integer> ATTACKED_MOBS_FROZEN_TICKS = GameRuleBuilder
            .forInteger(1000)
            .category(GameRuleCategory.MOBS)
            .buildAndRegister(Identifier.fromNamespaceAndPath(
                ImitationMarshmallow.MOD_ID, "attacked_mobs_frozen_ticks"
            )
        );
    */
    public static void initialize() {};
}
