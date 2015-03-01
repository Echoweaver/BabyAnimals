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
    public void doRenderLayer(EntitySheep entitySheep, float par2, float par3, float par4, float par5, float par6, float par7, float par8) {
        if (entitySheep.isChild()) {
            if (!entitySheep.getSheared() && !entitySheep.isInvisible()) {
                renderSheep.bindTexture(LAMB_FUR_TEXTURES);

                if (entitySheep.hasCustomName() && "jeb_".equals(entitySheep.getCustomNameTag())) {
                    boolean flag = true;
                    int i = entitySheep.ticksExisted / 25 + entitySheep.getEntityId();
                    int j = EnumDyeColor.values().length;
                    int k = i % j;
                    int l = (i + 1) % j;
                    float f7 = ((float) (entitySheep.ticksExisted % 25) + par4) / 25.0F;
                    float[] afloat1 = EntitySheep.func_175513_a(EnumDyeColor.byMetadata(k));
                    float[] afloat2 = EntitySheep.func_175513_a(EnumDyeColor.byMetadata(l));
                    GlStateManager.color(afloat1[0] * (1.0F - f7) + afloat2[0] * f7, afloat1[1] * (1.0F - f7) + afloat2[1] * f7, afloat1[2] * (1.0F - f7) + afloat2[2] * f7);
                } else {
                    float[] afloat = EntitySheep.func_175513_a(entitySheep.getFleeceColor());
                    GlStateManager.color(afloat[0], afloat[1], afloat[2]);
                }

                modelSheep.setModelAttributes(renderSheep.getMainModel());
                modelSheep.setLivingAnimations(entitySheep, par2, par3, par4);
                modelSheep.render(entitySheep, par2, par3, par5, par6, par7, par8);
            }
        } else {
            super.doRenderLayer(entitySheep, par2, par3, par4, par5, par6, par7, par8);
        }
    }
}
