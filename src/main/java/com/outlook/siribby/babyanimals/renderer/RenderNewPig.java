package com.outlook.siribby.babyanimals.renderer;

import com.outlook.siribby.babyanimals.BabyAnimals;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.ResourceLocation;

public class RenderNewPig extends RenderPig {
    public static final ResourceLocation PIGLET_TEXTURES = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/pig.png");

    public RenderNewPig(ModelBase modelBase1, ModelBase modelBase2, float par3) {
        super(modelBase1, modelBase2, par3);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityPig entityPig) {
        if (entityPig.isChild()) {
            return PIGLET_TEXTURES;
        }

        return super.getEntityTexture(entityPig);
    }
}
