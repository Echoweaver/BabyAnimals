package com.outlook.siribby.babyanimals.renderer;

import com.outlook.siribby.babyanimals.BabyAnimals;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.ResourceLocation;

public class RenderNewPig extends RenderPig {
    public static final ResourceLocation PIGLET_TEXTURES = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/pig.png");

    public RenderNewPig(RenderManager renderManager, ModelBase modelBase, float par3) {
        super(renderManager, modelBase, par3);
    }

    @Override
    protected ResourceLocation func_180583_a(EntityPig entityPig) {
        if (entityPig.isChild()) {
            return PIGLET_TEXTURES;
        }

        return super.func_180583_a(entityPig);
    }
}
