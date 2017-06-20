package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import io.github.mribby.babyanimals.model.ModelLamb1;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerSheepWool;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;

public class LayerLambWool extends LayerSheepWool {
    public static final ResourceLocation LAMB_FUR_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/sheep/sheep_fur.png");
    public final RenderLamb lambRenderer;
    public final ModelLamb1 lambModel = new ModelLamb1();

    public LayerLambWool(RenderLamb lambRenderer) {
        super(lambRenderer);
        this.lambRenderer = lambRenderer;
    }

    @Override
    public void doRenderLayer(EntitySheep lambEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (!lambEntity.getSheared() && !lambEntity.isInvisible()) {
            lambRenderer.bindTexture(LAMB_FUR_TEXTURES);

            if (lambEntity.hasCustomName() && "jeb_".equals(lambEntity.getCustomNameTag())) {
                int ticksPerCycle = 25;
                int i = lambEntity.ticksExisted / ticksPerCycle + lambEntity.getEntityId();
                int dyeCount = EnumDyeColor.values().length;
                int dyeMeta1 = i % dyeCount;
                int dyeMeta2 = (i + 1) % dyeCount;
                float cycleRatio2 = (lambEntity.ticksExisted % ticksPerCycle + partialTicks) / ticksPerCycle;
                float cycleRatio1 = 1.0F - cycleRatio2;
                float[] rgb1 = EntitySheep.getDyeRgb(EnumDyeColor.byMetadata(dyeMeta1));
                float[] rgb2 = EntitySheep.getDyeRgb(EnumDyeColor.byMetadata(dyeMeta2));
                GlStateManager.color(rgb1[0] * cycleRatio1 + rgb2[0] * cycleRatio2, rgb1[1] * cycleRatio1 + rgb2[1] * cycleRatio2, rgb1[2] * cycleRatio1 + rgb2[2] * cycleRatio2);
            } else {
                float[] rgb = EntitySheep.getDyeRgb(lambEntity.getFleeceColor());
                GlStateManager.color(rgb[0], rgb[1], rgb[2]);
            }

            lambModel.setModelAttributes(lambRenderer.getMainModel());
            lambModel.setLivingAnimations(lambEntity, limbSwing, limbSwingAmount, ageInTicks);
            lambModel.render(lambEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }
}
