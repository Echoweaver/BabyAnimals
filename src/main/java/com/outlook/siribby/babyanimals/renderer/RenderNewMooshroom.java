package com.outlook.siribby.babyanimals.renderer;

import com.outlook.siribby.babyanimals.BabyAnimals;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderMooshroom;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.util.ResourceLocation;

public class RenderNewMooshroom extends RenderMooshroom {
    public static final ResourceLocation CALF_TEXTURES = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/cow/mooshroom.png");

    public RenderNewMooshroom(ModelBase modelBase, float par2) {
        super(modelBase, par2);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMooshroom entityMooshroom) {
        if (entityMooshroom.isChild()) {
            return CALF_TEXTURES;
        }

        return super.getEntityTexture(entityMooshroom);
    }
}
