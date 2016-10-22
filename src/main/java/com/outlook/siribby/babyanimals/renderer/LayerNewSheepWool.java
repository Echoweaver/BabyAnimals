package com.outlook.siribby.babyanimals.renderer;

import com.outlook.siribby.babyanimals.BabyAnimals;
import com.outlook.siribby.babyanimals.model.ModelNewSheep1;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.client.renderer.entity.layers.LayerSheepWool;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;

public class LayerNewSheepWool extends LayerSheepWool {
    public static final ResourceLocation LAMB_FUR_TEXTURES = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/sheep/sheep_fur.png");
    private final ModelNewSheep1 modelSheep = new ModelNewSheep1();
    public final RenderSheep renderSheep;

    public LayerNewSheepWool(RenderSheep renderSheep) {
        super(renderSheep);
        this.renderSheep = renderSheep;
    }

    @Override
    public void doRenderLayer(EntitySheep entitySheep, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (entitySheep.isChild()) {
            if (!entitySheep.getSheared() && !entitySheep.isInvisible()) {
                renderSheep.bindTexture(LAMB_FUR_TEXTURES);

                if (entitySheep.hasCustomName() && "jeb_".equals(entitySheep.getCustomNameTag())) {
                    int i1 = 25;
                    int i = entitySheep.ticksExisted / 25 + entitySheep.getEntityId();
                    int j = EnumDyeColor.values().length;
                    int k = i % j;
                    int l = (i + 1) % j;
                    float f = ((float) (entitySheep.ticksExisted % 25) + partialTicks) / 25.0F;
                    float[] afloat1 = EntitySheep.getDyeRgb(EnumDyeColor.byMetadata(k));
                    float[] afloat2 = EntitySheep.getDyeRgb(EnumDyeColor.byMetadata(l));
                    GlStateManager.color(afloat1[0] * (1.0F - f) + afloat2[0] * f, afloat1[1] * (1.0F - f) + afloat2[1] * f, afloat1[2] * (1.0F - f) + afloat2[2] * f);
                } else {
                    float[] afloat = EntitySheep.getDyeRgb(entitySheep.getFleeceColor());
                    GlStateManager.color(afloat[0], afloat[1], afloat[2]);
                }

                modelSheep.setModelAttributes(renderSheep.getMainModel());
                modelSheep.setLivingAnimations(entitySheep, limbSwing, limbSwingAmount, ageInTicks);
                modelSheep.render(entitySheep, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            }
        } else {
            super.doRenderLayer(entitySheep, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }
}
