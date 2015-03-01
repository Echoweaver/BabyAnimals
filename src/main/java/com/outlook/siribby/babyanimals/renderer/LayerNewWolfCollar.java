package com.outlook.siribby.babyanimals.renderer;

import com.outlook.siribby.babyanimals.BabyAnimals;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.client.renderer.entity.layers.LayerWolfCollar;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;

public class LayerNewWolfCollar extends LayerWolfCollar {
    public static final ResourceLocation PUPPY_COLLAR_TEXTURES = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/wolf/wolf_collar.png");
    public final RenderWolf renderWolf;

    public LayerNewWolfCollar(RenderWolf renderWolf) {
        super(renderWolf);
        this.renderWolf = renderWolf;
    }

    @Override
    public void func_177145_a(EntityWolf entityWolf, float par2, float par3, float par4, float par5, float par6, float par7, float par8) {
        if (entityWolf.isChild()) {
            if (entityWolf.isTamed() && !entityWolf.isInvisible()) {
                renderWolf.bindTexture(PUPPY_COLLAR_TEXTURES);
                EnumDyeColor dyeColor = EnumDyeColor.byMetadata(entityWolf.getCollarColor().getMetadata());
                float[] colors = EntitySheep.func_175513_a(dyeColor);
                GlStateManager.color(colors[0], colors[1], colors[2]);
                renderWolf.getMainModel().render(entityWolf, par2, par3, par5, par6, par7, par8);
            }
        } else {
            super.func_177145_a(entityWolf, par2, par3, par4, par5, par6, par7, par8);
        }
    }
}
