package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerWolfCollar;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;

public class LayerPuppyCollar extends LayerWolfCollar {
    public static final ResourceLocation PUPPY_COLLAR_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/wolf/puppy_collar.png");
    public final RenderPuppy puppyRenderer;

    public LayerPuppyCollar(RenderPuppy puppyRenderer) {
        super(puppyRenderer);
        this.puppyRenderer = puppyRenderer;
    }

    @Override
    public void doRenderLayer(EntityWolf puppyEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (puppyEntity.isTamed() && !puppyEntity.isInvisible()) {
            puppyRenderer.bindTexture(PUPPY_COLLAR_TEXTURES);
            float[] rgb = EntitySheep.getDyeRgb(puppyEntity.getCollarColor());
            GlStateManager.color(rgb[0], rgb[1], rgb[2]);
            puppyRenderer.getMainModel().render(puppyEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }
}
