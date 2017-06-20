package io.github.mribby.babyanimals;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import ganymedes01.etfuturum.entities.EntityRabbit;
import io.github.mribby.babyanimals.renderer.*;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.*;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import java.util.HashMap;

public class ProxyClient extends Proxy {
    public static final HashMap<Class<? extends EntityLivingBase>, RendererLivingEntity> ENTITY_RENDERER_MAP = new HashMap<Class<? extends EntityLivingBase>, RendererLivingEntity>();

    private Configuration config;

    private float renderTickTime;
    private boolean isRendering;
    private boolean forceBabyModels;

    @Override
    public void init() {
        config = new Configuration(BabyAnimalsMod.configFile);
        forceBabyModels = config.get("client", "forceBabyModels", false).getBoolean();
        registerRenderer(EntityPig.class, "enablePig", new RenderPiglet());
        registerRenderer(EntitySheep.class, "enableSheep", new RenderLamb());
        registerRenderer(EntityCow.class, "enableCow", new RenderCalf());
        registerRenderer(EntityMooshroom.class, "enableMooshroom", new RenderMooshroomCalf());
        registerRenderer(EntityWolf.class, "enableWolf", new RenderPuppy());
        registerRenderer(EntityChicken.class, "enableChicken", new RenderChick());
        registerRenderer(EntityOcelot.class, "enableOcelot", new RenderKitten());
        if (Loader.isModLoaded("etfuturum")) {
            registerRenderer(EntityRabbit.class, "enableRabbit", RenderBunny.create());
        }
        config.save();

        for (RendererLivingEntity renderer : ENTITY_RENDERER_MAP.values()) {
            renderer.setRenderManager(RenderManager.instance);
        }

        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void registerRenderer(Class<? extends EntityLivingBase> clazz, String configKey, RendererLivingEntity renderer) {
        if (config.get("client", configKey, true).getBoolean()) {
            ENTITY_RENDERER_MAP.put(clazz, renderer);
        }
    }

    @SubscribeEvent
    public void onTick(TickEvent.RenderTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            renderTickTime = event.renderTickTime;
        }
    }

    @SubscribeEvent
    public void renderEntity(RenderLivingEvent.Pre event) {
        if (!isRendering) {
            EntityLivingBase entity = event.entity;
            if (entity.isChild() || forceBabyModels) {
                RendererLivingEntity renderer = ENTITY_RENDERER_MAP.get(entity.getClass());
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
