package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import io.github.mribby.babyanimals.model.ModelBunny;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderRabbit;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public class RenderBunny extends RenderRabbit {
    public static final ResourceLocation BROWN = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/rabbit/brown.png");
    public static final ResourceLocation WHITE = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/rabbit/white.png");
    public static final ResourceLocation BLACK = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/rabbit/black.png");
    public static final ResourceLocation GOLD = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/rabbit/gold.png");
    public static final ResourceLocation SALT = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/rabbit/salt.png");
    public static final ResourceLocation WHITE_SPLOTCHED = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/rabbit/white_splotched.png");
    public static final ResourceLocation TOAST = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/rabbit/toast.png");
    public static final ResourceLocation CAERBANNOG = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/rabbit/caerbannog.png");

    public RenderBunny(RenderManager renderManager) {
        this(renderManager, new ModelBunny(), 0.3F);
    }

    public RenderBunny(RenderManager renderManager, ModelBase modelBase, float shadowSize) {
        super(renderManager, modelBase, shadowSize);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityRabbit bunnyEntity) {
        String name = EnumChatFormatting.getTextWithoutFormattingCodes(bunnyEntity.getName());
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
