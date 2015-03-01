package com.outlook.siribby.babyanimals.renderer;

import com.outlook.siribby.babyanimals.BabyAnimals;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.client.renderer.entity.layers.LayerWolfCollar;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;

import java.util.ListIterator;

public class RenderNewWolf extends RenderWolf {
    public static final ResourceLocation PUPPY_TEXTURES = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/wolf/wolf.png");
    public static final ResourceLocation TAMED_PUPPY_TEXTURES = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/wolf/wolf_tame.png");
    public static final ResourceLocation ANGRY_PUPPY_TEXTURES = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/wolf/wolf_angry.png");

    public RenderNewWolf(RenderManager renderManager, ModelBase modelBase, float par3) {
        super(renderManager, modelBase, par3);

        ListIterator layerIterator = layerRenderers.listIterator();
        while (layerIterator.hasNext()) {
            if (layerIterator.next().getClass() == LayerWolfCollar.class) {
                layerIterator.set(new LayerNewWolfCollar(this));
                break;
            }
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWolf entityWolf) {
        if (entityWolf.isChild()) {
            return entityWolf.isTamed() ? TAMED_PUPPY_TEXTURES : entityWolf.isAngry() ? ANGRY_PUPPY_TEXTURES : PUPPY_TEXTURES;
        }

        return super.getEntityTexture(entityWolf);
    }
}
