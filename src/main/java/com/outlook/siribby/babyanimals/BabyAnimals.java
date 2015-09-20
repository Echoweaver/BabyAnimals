package com.outlook.siribby.babyanimals;

import com.outlook.siribby.babyanimals.model.*;
import com.outlook.siribby.babyanimals.renderer.*;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.entity.passive.*;

@Mod(modid = BabyAnimals.MOD_ID, name = "Baby Animals Model Swapper", version = "@VERSION@")
public class BabyAnimals {
    public static final String MOD_ID = "babyanimals";
//    public static final HashMap<Class<? extends EntityLivingBase>, RendererLivingEntity> entityRenderMap = Maps.newHashMap();
//    private float renderTickTime;
//    private boolean isRendering;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityPig.class, new RenderNewPig(new ModelNewPig(), new ModelNewPig(0.5F), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySheep.class, new RenderNewSheep(new ModelNewSheep2(), new ModelNewSheep1(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityCow.class, new RenderNewCow(new ModelNewCow(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMooshroom.class, new RenderNewMooshroom(new ModelNewCow(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityWolf.class, new RenderNewWolf(new ModelNewWolf(), new ModelNewWolf(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityChicken.class, new RenderNewChicken(new ModelNewChicken(), 0.3F));

//        FMLCommonHandler.instance().bus().register(this);
//        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        BabyAnimalsCompat.addModCompatibility();
    }

//    @SubscribeEvent
//    public void onTick(TickEvent.RenderTickEvent event) {
//        if (event.phase == TickEvent.Phase.START) {
//            renderTickTime = event.renderTickTime;
//        }
//    }
//
//    @SubscribeEvent
//    public void renderEntity(RenderLivingEvent.Pre event) {
//        if (!isRendering) {
//            EntityLivingBase entity = event.entity;
//
//            if (entity.isChild()) {
//                RendererLivingEntity renderer = entityRenderMap.get(entity.getClass());
//
//                if (renderer != null) {
//                    isRendering = true;
//                    event.renderer.doRender(entity, event.x, event.y, event.z, 0.0F, renderTickTime);
//                    isRendering = false;
//                    event.setCanceled(true);
//                }
//            }
//        }
//    }
}
