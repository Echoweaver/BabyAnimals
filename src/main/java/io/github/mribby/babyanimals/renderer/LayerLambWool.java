package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import io.github.mribby.babyanimals.model.ModelLamb1;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerSheepWool;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;

public class LayerLambWool extends LayerSheepWool {
    public static final ResourceLocation LAMB_FUR_TEXTURES = new ResourceLocation(BabyAnimalsMod.ID, "textures/entity/sheep/sheep_fur.png");
    private final RenderLamb lambRenderer;
    private final ModelLamb1 lambModel = new ModelLamb1();

    public LayerLambWool(RenderLamb lambRenderer) {
        super(lambRenderer);
        this.lambRenderer = lambRenderer;
    }

    @Override
    public void doRenderLayer(EntitySheep lambEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (!lambEntity.getSheared() && !lambEntity.isInvisible()) {
            lambRenderer.bindTexture(LAMB_FUR_TEXTURES);

            if (lambEntity.hasCustomName() && "jeb_".equals(lambEntity.getCustomNameTag())) {
                int i1 = 25;
                int i = lambEntity.ticksExisted / 25 + lambEntity.getEntityId();
                int j = EnumDyeColor.values().length;
                int k = i % j;
                int l = (i + 1) % j;
                float f = ((float) (lambEntity.ticksExisted % 25) + partialTicks) / 25.0F;
                float[] afloat1 = EntitySheep.getDyeRgb(EnumDyeColor.byMetadata(k));
                float[] afloat2 = EntitySheep.getDyeRgb(EnumDyeColor.byMetadata(l));
                GlStateManager.color(afloat1[0] * (1.0F - f) + afloat2[0] * f, afloat1[1] * (1.0F - f) + afloat2[1] * f, afloat1[2] * (1.0F - f) + afloat2[2] * f);
            } else {
                float[] afloat = EntitySheep.getDyeRgb(lambEntity.getFleeceColor());
                GlStateManager.color(afloat[0], afloat[1], afloat[2]);
            }

            lambModel.setModelAttributes(lambRenderer.getMainModel());
            lambModel.setLivingAnimations(lambEntity, limbSwing, limbSwingAmount, ageInTicks);
            lambModel.render(lambEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }
}
