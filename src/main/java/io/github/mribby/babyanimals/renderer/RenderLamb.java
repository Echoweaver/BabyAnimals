package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import io.github.mribby.babyanimals.model.ModelLamb2;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.client.renderer.entity.layers.LayerSheepWool;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;

public class RenderLamb extends RenderSheep {
    public static final ResourceLocation LAMB_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/sheep/sheep.png");

    public RenderLamb(RenderManager renderManager) {
        this(renderManager, new ModelLamb2(), 0.7F);
    }

    public RenderLamb(RenderManager renderManager, ModelBase modelBase, float shadowSize) {
        super(renderManager, modelBase, shadowSize);
        RenderUtils.replaceLayerRenderer(layerRenderers, LayerSheepWool.class, new LayerLambWool(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySheep lambEntity) {
        return LAMB_TEXTURES;
    }
}
