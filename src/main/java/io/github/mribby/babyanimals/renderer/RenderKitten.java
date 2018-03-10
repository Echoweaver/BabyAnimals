package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import io.github.mribby.babyanimals.model.ModelKitten;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderOcelot;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.util.ResourceLocation;

public class RenderKitten extends RenderOcelot {
    public static final ResourceLocation BLACK_KITTEN_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/cat/kitten_black.png");
    public static final ResourceLocation KITTEN_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/cat/kitten_ocelot.png");
    public static final ResourceLocation RED_KITTEN_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/cat/kitten_red.png");
    public static final ResourceLocation SIAMESE_KITTEN_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/cat/kitten_siamese.png");

    public RenderKitten(RenderManager renderManager) {
        super(renderManager);
        mainModel = new ModelKitten();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityOcelot kittenEntity) {
        switch (kittenEntity.getTameSkin()) {
            case 0:
            default:
                return KITTEN_TEXTURES;
            case 1:
                return BLACK_KITTEN_TEXTURES;
            case 2:
                return RED_KITTEN_TEXTURES;
            case 3:
                return SIAMESE_KITTEN_TEXTURES;
        }
    }
}
