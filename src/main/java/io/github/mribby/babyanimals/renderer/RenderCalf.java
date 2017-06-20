package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import io.github.mribby.babyanimals.model.ModelCalf;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

public class RenderCalf extends RenderCow {
    public static final ResourceLocation CALF_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/cow/cow.png");

    public RenderCalf() {
        this(new ModelCalf(), 0.7F);
    }

    public RenderCalf(ModelBase modelBase, float shadowSize) {
        super(modelBase, shadowSize);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityCow calfEntity) {
        return CALF_TEXTURES;
    }
}
