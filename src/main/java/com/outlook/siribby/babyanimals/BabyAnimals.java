package com.outlook.siribby.babyanimals;

import com.outlook.siribby.babyanimals.model.*;
import com.outlook.siribby.babyanimals.renderer.*;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.*;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = BabyAnimals.MOD_ID, name = "Baby Animals Model Swapper", version = "@VERSION@")
public class BabyAnimals {
    public static final String MOD_ID = "babyanimals";
//    public static final HashMap<Class<? extends EntityLivingBase>, RendererLivingEntity> entityRenderMap = Maps.newHashMap();
//    private float renderTickTime;
//    private boolean isRendering;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        RenderManager renderManager = FMLClientHandler.instance().getClient().getRenderManager();
        RenderingRegistry.registerEntityRenderingHandler(EntityPig.class, new RenderNewPig(renderManager, new ModelNewPig(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySheep.class, new RenderNewSheep(renderManager, new ModelNewSheep2(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityCow.class, new RenderNewCow(renderManager, new ModelNewCow(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMooshroom.class, new RenderNewMooshroom(renderManager, new ModelNewCow(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityWolf.class, new RenderNewWolf(renderManager, new ModelNewWolf(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityChicken.class, new RenderNewChicken(renderManager, new ModelNewChicken(), 0.3F));

//        FMLCommonHandler.instance().bus().register(this);
//        MinecraftForge.EVENT_BUS.register(this);
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
