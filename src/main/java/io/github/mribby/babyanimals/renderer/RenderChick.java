package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import io.github.mribby.babyanimals.model.ModelChick;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.ResourceLocation;

public class RenderChick extends RenderChicken {
    public static final ResourceLocation CHICK_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/chick.png");

    public RenderChick(RenderManager renderManager) {
        super(renderManager);
        mainModel = new ModelChick();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityChicken chickEntity) {
        return CHICK_TEXTURES;
    }
}
