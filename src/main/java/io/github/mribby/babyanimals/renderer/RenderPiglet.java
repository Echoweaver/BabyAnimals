package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import io.github.mribby.babyanimals.model.ModelPiglet;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.ResourceLocation;

public class RenderPiglet extends RenderPig {
    public static final ResourceLocation PIGLET_TEXTURES = new ResourceLocation(BabyAnimalsMod.ID, "textures/entity/pig.png");

    public RenderPiglet(RenderManager renderManager) {
        super(renderManager);
        mainModel = new ModelPiglet();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityPig pigletEntity) {
        return PIGLET_TEXTURES;
    }
}
