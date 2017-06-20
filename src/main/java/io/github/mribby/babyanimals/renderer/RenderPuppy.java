package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import io.github.mribby.babyanimals.model.ModelPuppy;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;

import static org.lwjgl.opengl.GL11.glColor3f;

public class RenderPuppy extends RenderWolf {
    public static final ResourceLocation PUPPY_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/wolf/wolf.png");
    public static final ResourceLocation TAMED_PUPPY_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/wolf/wolf_tame.png");
    public static final ResourceLocation ANGRY_PUPPY_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/wolf/wolf_angry.png");
    public static final ResourceLocation PUPPY_COLLAR_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/wolf/wolf_collar.png");

    public RenderPuppy() {
        this(new ModelPuppy(), new ModelPuppy(), 0.5F);
    }

    public RenderPuppy(ModelBase modelBase, ModelBase renderPassModel, float shadowSize) {
        super(modelBase, renderPassModel, shadowSize);
    }

    @Override
    protected int shouldRenderPass(EntityWolf puppyEntity, int renderPass, float partialTicks) {
        if (renderPass == 0 && puppyEntity.getWolfShaking()) {
            bindTexture(PUPPY_TEXTURES);
            float f = puppyEntity.getBrightness(partialTicks) * puppyEntity.getShadingWhileShaking(partialTicks);
            glColor3f(f, f, f);
            return 1;
        } else if (renderPass == 1 && puppyEntity.isTamed()) {
            bindTexture(PUPPY_COLLAR_TEXTURES);
            float[] rgb = EntitySheep.fleeceColorTable[puppyEntity.getCollarColor()];
            glColor3f(rgb[0], rgb[1], rgb[2]);
            return 1;
        }

        return -1;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWolf puppyEntity) {
        return puppyEntity.isTamed() ? TAMED_PUPPY_TEXTURES : puppyEntity.isAngry() ? ANGRY_PUPPY_TEXTURES : PUPPY_TEXTURES;
    }
}
