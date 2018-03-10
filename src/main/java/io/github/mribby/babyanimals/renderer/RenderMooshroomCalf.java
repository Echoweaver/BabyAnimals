package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import io.github.mribby.babyanimals.model.ModelCalf;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderMooshroom;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.util.ResourceLocation;

public class RenderMooshroomCalf extends RenderMooshroom {
    public static final ResourceLocation MOOSHROOM_CALF_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/cow/mooshroom_calf.png");

    public RenderMooshroomCalf(RenderManager renderManager) {
        super(renderManager);
        mainModel = new ModelCalf();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMooshroom calfEntity) {
        return MOOSHROOM_CALF_TEXTURES;
    }
}
