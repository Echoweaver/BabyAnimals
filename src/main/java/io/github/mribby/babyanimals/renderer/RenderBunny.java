package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import io.github.mribby.babyanimals.model.ModelBunny;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderRabbit;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class RenderBunny extends RenderRabbit {
    public static final ResourceLocation BROWN = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/rabbit/bunny_brown.png");
    public static final ResourceLocation WHITE = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/rabbit/bunny_white.png");
    public static final ResourceLocation BLACK = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/rabbit/bunny_black.png");
    public static final ResourceLocation GOLD = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/rabbit/bunny_gold.png");
    public static final ResourceLocation SALT = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/rabbit/bunny_salt.png");
    public static final ResourceLocation WHITE_SPLOTCHED = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/rabbit/bunny_white_splotched.png");
    public static final ResourceLocation TOAST = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/rabbit/bunny_toast.png");
    public static final ResourceLocation CAERBANNOG = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/rabbit/bunny_caerbannog.png");

    public RenderBunny(RenderManager renderManager) {
        super(renderManager);
        mainModel = new ModelBunny();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityRabbit bunnyEntity) {
        String name = TextFormatting.getTextWithoutFormattingCodes(bunnyEntity.getName());
        if (name != null && name.equals("Toast")) {
            return TOAST;
        } else {
            switch (bunnyEntity.getRabbitType()) {
                case 0:
                default:
                    return BROWN;
                case 1:
                    return WHITE;
                case 2:
                    return BLACK;
                case 3:
                    return WHITE_SPLOTCHED;
                case 4:
                    return GOLD;
                case 5:
                    return SALT;
                case 99:
                    return CAERBANNOG;
            }
        }
    }
}
