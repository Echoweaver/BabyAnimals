package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import io.github.mribby.babyanimals.model.ModelPuppy;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.client.renderer.entity.layers.LayerWolfCollar;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;

public class RenderPuppy extends RenderWolf {
    public static final ResourceLocation PUPPY_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/wolf/wolf.png");
    public static final ResourceLocation TAMED_PUPPY_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/wolf/wolf_tame.png");
    public static final ResourceLocation ANGRY_PUPPY_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/wolf/wolf_angry.png");

    public RenderPuppy(RenderManager renderManager) {
        this(renderManager, new ModelPuppy(), 0.5F);
    }

    public RenderPuppy(RenderManager renderManager, ModelBase modelBase, float shadowSize) {
        super(renderManager, modelBase, shadowSize);
        RenderUtils.replaceLayerRenderer(layerRenderers, LayerWolfCollar.class, new LayerPuppyCollar(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWolf puppyEntity) {
        return puppyEntity.isTamed() ? TAMED_PUPPY_TEXTURES : puppyEntity.isAngry() ? ANGRY_PUPPY_TEXTURES : PUPPY_TEXTURES;
    }
}