package com.outlook.siribby.babyanimals.renderer;

import com.outlook.siribby.babyanimals.BabyAnimals;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderNewWolf extends RenderWolf {
    public static final ResourceLocation PUPPY_TEXTURES = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/wolf/wolf.png");
    public static final ResourceLocation TAMED_PUPPY_TEXTURES = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/wolf/wolf_tame.png");
    public static final ResourceLocation ANGRY_PUPPY_TEXTURES = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/wolf/wolf_angry.png");
    public static final ResourceLocation PUPPY_COLLAR_TEXTURES = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/wolf/wolf_collar.png");

    public RenderNewWolf(ModelBase modelBase1, ModelBase modelBase2, float par3) {
        super(modelBase1, modelBase2, par3);
    }

    @Override
    protected int shouldRenderPass(EntityWolf entityWolf, int par2, float par3) {
        if (entityWolf.isChild()) {
            if (par2 == 0 && entityWolf.getWolfShaking()) {
                float var5 = entityWolf.getBrightness(par3) * entityWolf.getShadingWhileShaking(par3);
                bindTexture(PUPPY_TEXTURES);
                GL11.glColor3f(var5, var5, var5);
                return 1;
            } else if (par2 == 1 && entityWolf.isTamed()) {
                bindTexture(PUPPY_COLLAR_TEXTURES);
                int var4 = entityWolf.getCollarColor();
                GL11.glColor3f(EntitySheep.fleeceColorTable[var4][0], EntitySheep.fleeceColorTable[var4][1], EntitySheep.fleeceColorTable[var4][2]);
                return 1;
            }

            return -1;
        }

        return super.shouldRenderPass(entityWolf, par2, par3);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWolf entityWolf) {
        if (entityWolf.isChild()) {
            return entityWolf.isTamed() ? TAMED_PUPPY_TEXTURES : entityWolf.isAngry() ? ANGRY_PUPPY_TEXTURES : PUPPY_TEXTURES;
        }

        return super.getEntityTexture(entityWolf);
    }
}
