package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import io.github.mribby.babyanimals.model.ModelChick;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.ResourceLocation;

public class RenderChick extends RenderChicken {
    public static final ResourceLocation CHICK_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/chicken.png");

    public RenderChick(RenderManager renderManager) {
        this(renderManager, new ModelChick(), 0.3F);
    }

    public RenderChick(RenderManager renderManager, ModelBase modelBase, float shadowSize) {
        super(renderManager, modelBase, shadowSize);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityChicken chickEntity) {
        return CHICK_TEXTURES;
    }
}
