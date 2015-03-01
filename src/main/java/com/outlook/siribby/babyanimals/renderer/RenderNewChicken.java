package com.outlook.siribby.babyanimals.renderer;

import com.outlook.siribby.babyanimals.BabyAnimals;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.ResourceLocation;

public class RenderNewChicken extends RenderChicken {
    public static final ResourceLocation CHICK_TEXTURES = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/chicken.png");

    public RenderNewChicken(ModelBase modelBase, float par2) {
        super(modelBase, par2);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityChicken entityChicken) {
        if (entityChicken.isChild()) {
            return CHICK_TEXTURES;
        }

        return super.getEntityTexture(entityChicken);
    }
}
