package io.github.mribby.babyanimals;

import io.github.mribby.babyanimals.renderer.*;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.*;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;

public class ProxyClient extends Proxy {
    public static final HashMap<Class<? extends EntityLivingBase>, RenderLivingBase> ENTITY_RENDERER_MAP = new HashMap<Class<? extends EntityLivingBase>, RenderLivingBase>();

    private Configuration config;

    private boolean isRendering;
    private boolean forceBabyModels;

    @Override
    public void init() {
        config = new Configuration(BabyAnimalsMod.configFile);
        RenderManager renderManager = FMLClientHandler.instance().getClient().getRenderManager();
        forceBabyModels = config.get(Configuration.CATEGORY_CLIENT, "forceBabyModels", false).getBoolean();
        registerRenderer(EntityPig.class, "enablePig", new RenderPiglet(renderManager));
        registerRenderer(EntitySheep.class, "enableSheep", new RenderLamb(renderManager));
        registerRenderer(EntityCow.class, "enableCow", new RenderCalf(renderManager));
        registerRenderer(EntityMooshroom.class, "enableMooshroom", new RenderMooshroomCalf(renderManager));
        registerRenderer(EntityWolf.class, "enableWolf", new RenderPuppy(renderManager));
        registerRenderer(EntityChicken.class, "enableChicken", new RenderChick(renderManager));
        registerRenderer(EntityRabbit.class, "enableRabbit", new RenderBunny(renderManager));
        registerRenderer(EntityOcelot.class, "enableOcelot", new RenderKitten(renderManager));
        config.save();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private <T extends EntityLivingBase> void registerRenderer(Class<T> clazz, String configKey, RenderLivingBase<T> renderer) {
        if (config.get(Configuration.CATEGORY_CLIENT, configKey, true).getBoolean()) {
            ENTITY_RENDERER_MAP.put(clazz, renderer);
        }
    }

    @SubscribeEvent
    public void onRenderLivingPre(RenderLivingEvent.Pre event) {
        if (!isRendering) {
            EntityLivingBase entity = event.getEntity();
            if (entity.isChild() || forceBabyModels) {
                RenderLivingBase renderer = ENTITY_RENDERER_MAP.get(entity.getClass());
                if (renderer != null) {
                    isRendering = true;
                    renderer.doRender(entity, event.getX(), event.getY(), event.getZ(), 0.0F, FMLClientHandler.instance().getClient().getRenderPartialTicks());
                    isRendering = false;
                    event.setCanceled(true);
                }
            }
        }
    }
}
