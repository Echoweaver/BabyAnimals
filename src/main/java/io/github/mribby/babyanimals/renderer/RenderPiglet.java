package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import io.github.mribby.babyanimals.model.ModelPiglet;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.ResourceLocation;

public class RenderPiglet extends RenderPig {
    public static final ResourceLocation PIGLET_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/pig.png");

    public RenderPiglet(RenderManager renderManager) {
        this(renderManager, new ModelPiglet(), 0.7F);
    }

    public RenderPiglet(RenderManager renderManager, ModelBase modelBase, float shadowSize) {
        super(renderManager, modelBase, shadowSize);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityPig pigletEntity) {
        return PIGLET_TEXTURES;
    }
}
