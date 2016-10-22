package com.outlook.siribby.babyanimals;

import com.outlook.siribby.babyanimals.model.*;
import com.outlook.siribby.babyanimals.renderer.*;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.*;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.HashMap;

@Mod(modid = BabyAnimals.MOD_ID, name = "Baby Animals Model Swapper", version = "@VERSION@", acceptedMinecraftVersions = "*")
public class BabyAnimals {
    public static final String MOD_ID = "babyanimals";
    public static final HashMap<Class<? extends EntityLivingBase>, RendererLivingEntity> ENTITY_RENDER_MAP = new HashMap<Class<? extends EntityLivingBase>, RendererLivingEntity>();
    private float renderTickTime;
    private boolean isRendering;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        RenderManager renderManager = FMLClientHandler.instance().getClient().getRenderManager();
        ENTITY_RENDER_MAP.put(EntityPig.class, new RenderNewPig(renderManager, new ModelNewPig(), 0.7F));
        ENTITY_RENDER_MAP.put(EntitySheep.class, new RenderNewSheep(renderManager, new ModelNewSheep2(), 0.7F));
        ENTITY_RENDER_MAP.put(EntityCow.class, new RenderNewCow(renderManager, new ModelNewCow(), 0.7F));
        ENTITY_RENDER_MAP.put(EntityMooshroom.class, new RenderNewMooshroom(renderManager, new ModelNewCow(), 0.7F));
        ENTITY_RENDER_MAP.put(EntityWolf.class, new RenderNewWolf(renderManager, new ModelNewWolf(), 0.5F));
        ENTITY_RENDER_MAP.put(EntityChicken.class, new RenderNewChicken(renderManager, new ModelNewChicken(), 0.3F));
        ENTITY_RENDER_MAP.put(EntityRabbit.class, new RenderNewRabbit(renderManager, new ModelNewRabbit(), 0.3F));

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onTick(TickEvent.RenderTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            renderTickTime = event.renderTickTime;
        }
    }

    @SubscribeEvent
    public void onRenderLivingPre(RenderLivingEvent.Pre event) {
        if (!isRendering) {
            EntityLivingBase entity = event.entity;

            if (entity.isChild()) {
                RendererLivingEntity renderer = ENTITY_RENDER_MAP.get(entity.getClass());

                if (renderer != null) {
                    isRendering = true;
                    renderer.doRender(entity, event.x, event.y, event.z, 0.0F, renderTickTime);
                    isRendering = false;
                    event.setCanceled(true);
                }
            }
        }
    }
}
