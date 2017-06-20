package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import io.github.mribby.babyanimals.model.ModelCalf;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderMooshroom;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.util.ResourceLocation;

public class RenderMooshroomCalf extends RenderMooshroom {
    public static final ResourceLocation CALF_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/cow/mooshroom.png");

    public RenderMooshroomCalf() {
        this(new ModelCalf(), 0.7F);
    }

    public RenderMooshroomCalf(ModelBase modelBase, float shadowSize) {
        super(modelBase, shadowSize);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMooshroom calfEntity) {
        return CALF_TEXTURES;
    }
}
