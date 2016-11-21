package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerWolfCollar;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;

public class LayerPuppyCollar extends LayerWolfCollar {
    public static final ResourceLocation PUPPY_COLLAR_TEXTURES = new ResourceLocation(BabyAnimalsMod.ID, "textures/entity/wolf/wolf_collar.png");
    private final RenderPuppy puppyRenderer;

    public LayerPuppyCollar(RenderPuppy puppyRenderer) {
        super(puppyRenderer);
        this.puppyRenderer = puppyRenderer;
    }

    @Override
    public void doRenderLayer(EntityWolf puppyEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (puppyEntity.isTamed() && !puppyEntity.isInvisible()) {
            puppyRenderer.bindTexture(PUPPY_COLLAR_TEXTURES);
            EnumDyeColor dyeColor = EnumDyeColor.byMetadata(puppyEntity.getCollarColor().getMetadata());
            float[] colors = EntitySheep.getDyeRgb(dyeColor);
            GlStateManager.color(colors[0], colors[1], colors[2]);
            puppyRenderer.getMainModel().render(puppyEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }
}
