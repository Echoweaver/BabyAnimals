package com.outlook.siribby.babyanimals.renderer;

import com.outlook.siribby.babyanimals.BabyAnimals;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

public class RenderNewCow extends RenderCow {
    public static final ResourceLocation CALF_TEXTURES = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/cow/cow.png");

    public RenderNewCow(ModelBase modelBase, float par2) {
        super(modelBase, par2);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityCow entityCow) {
        if (entityCow.isChild()) {
            return CALF_TEXTURES;
        }

        return super.getEntityTexture(entityCow);
    }
}
