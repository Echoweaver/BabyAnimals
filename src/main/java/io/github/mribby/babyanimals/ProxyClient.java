package io.github.mribby.babyanimals;

import io.github.mribby.babyanimals.renderer.*;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.*;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

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
        forceBabyModels = config.get(Configuration.CATEGORY_CLIENT, "forceBabyModels", false).getBoolean();
        RenderManager renderManager = FMLClientHandler.instance().getClient().getRenderManager();
        registerRenderer(EntityPig.class, "enablePig", new RenderPiglet(renderManager));
        registerRenderer(EntitySheep.class, "enableSheep", new RenderLamb(renderManager));
        registerRenderer(EntityCow.class, "enableCow", new RenderCalf(renderManager));
        registerRenderer(EntityMooshroom.class, "enableMooshroom", new RenderMooshroomCalf(renderManager));
        registerRenderer(EntityWolf.class, "enableWolf", new RenderPuppy(renderManager));
        registerRenderer(EntityChicken.class, "enableChicken", new RenderChick(renderManager));
        registerRenderer(EntityRabbit.class, "enableRabbit", new RenderBunny(renderManager));
        registerRenderer(EntityOcelot.class, "enableOcelot", new RenderKitten(renderManager));
        config.save();

        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private <T extends EntityLivingBase> void registerRenderer(Class<T> clazz, String configKey, RendererLivingEntity<T> renderer) {
        if (config.get(Configuration.CATEGORY_CLIENT, configKey, true).getBoolean()) {
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
    public void onRenderLivingPre(RenderLivingEvent.Pre event) {
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
