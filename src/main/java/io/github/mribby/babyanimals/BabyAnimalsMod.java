package io.github.mribby.babyanimals;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

@Mod(modid = BabyAnimalsMod.MODID, name = BabyAnimalsMod.NAME, version = BabyAnimalsMod.VERSION, acceptedMinecraftVersions = BabyAnimalsMod.MINECRAFT_VERSIONS, dependencies = BabyAnimalsMod.DEPENDENCIES)
public class BabyAnimalsMod {
    public static final String MODID = "babyanimals";
    public static final String NAME = "Baby Animals Model Swapper";
    public static final String VERSION = "@VERSION@";
    public static final String MINECRAFT_VERSIONS = "*";
    public static final String UPDATE_JSON_URL = "https://gist.githubusercontent.com/MrIbby/b25a49bdf1ffe888dd6956f025d1af28/raw";
    public static final String DEPENDENCIES = "after:etfuturum";

    public static File configFile;

    @SidedProxy(clientSide = "io.github.mribby.babyanimals.ProxyClient", serverSide = "io.github.mribby.babyanimals.Proxy")
    public static Proxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        configFile = event.getSuggestedConfigurationFile();
        VersionChecker.startVersionCheck();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }
}
