package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import io.github.mribby.babyanimals.model.ModelPiglet;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.ResourceLocation;

public class RenderPiglet extends RenderPig {
    public static final ResourceLocation PIGLET_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/pig.png");

    public RenderPiglet() {
        this(new ModelPiglet(), new ModelPiglet(0.5F), 0.7F);
    }

    public RenderPiglet(ModelBase modelBase, ModelBase renderPassModel, float shadowSize) {
        super(modelBase, renderPassModel, shadowSize);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityPig pigletEntity) {
        return PIGLET_TEXTURES;
    }
}
