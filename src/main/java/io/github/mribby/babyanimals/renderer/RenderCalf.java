package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import io.github.mribby.babyanimals.model.ModelCalf;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

public class RenderCalf extends RenderCow {
    public static final ResourceLocation CALF_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/cow/cow.png");

    public RenderCalf(RenderManager renderManager) {
        super(renderManager);
        mainModel = new ModelCalf();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityCow calfEntity) {
        return CALF_TEXTURES;
    }
}
