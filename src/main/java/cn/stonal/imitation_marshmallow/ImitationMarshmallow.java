package cn.stonal.imitation_marshmallow;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.resources.Identifier;

public class ImitationMarshmallow implements ModInitializer
{
    public static final String MOD_ID = "imitation_marshmallow";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize()
    {
        LOGGER.info("Mod {} loaded", MOD_ID);
        ModItems.initialize();
        ModCreativeModeTab.initialize();
        ModGameRules.initialize();
    }
    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}