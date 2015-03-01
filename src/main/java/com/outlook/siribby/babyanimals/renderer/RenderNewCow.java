package com.outlook.siribby.babyanimals.renderer;

import com.outlook.siribby.babyanimals.BabyAnimals;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

public class RenderNewCow extends RenderCow {
    public static final ResourceLocation CALF_TEXTURES = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/cow/cow.png");

    public RenderNewCow(RenderManager renderManager, ModelBase modelBase, float par2) {
        super(renderManager, modelBase, par2);
    }

    @Override
    protected ResourceLocation func_180572_a(EntityCow entityCow) {
        if (entityCow.isChild()) {
            return CALF_TEXTURES;
        }

        return super.func_180572_a(entityCow);
    }
}
