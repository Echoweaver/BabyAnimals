package com.outlook.siribby.babyanimals;

import com.outlook.siribby.babyanimals.renderer.RenderNewRabbit;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;

public class BabyAnimalsCompat {
    public static void addModCompatibility() {
        if (Loader.isModLoaded("etfuturum")) {
            RenderingRegistry.registerEntityRenderingHandler(ganymedes01.etfuturum.entities.EntityRabbit.class, new RenderNewRabbit());
        }
    }
}
