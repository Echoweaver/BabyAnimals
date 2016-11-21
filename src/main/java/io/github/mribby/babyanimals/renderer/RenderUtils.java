package io.github.mribby.babyanimals.renderer;

import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;

import java.util.List;
import java.util.ListIterator;

public class RenderUtils {
    /**
     * Replaces a layer renderer in a list of layer renderers
     *
     * @param layerRenderers The list of layer renderers
     * @param clazz The class of the layer renderer to replace
     * @param replacement The replacement layer renderer
     * @param <T> The entity type
     */
    public static <T extends EntityLivingBase> void replaceLayerRenderer(List<LayerRenderer<T>> layerRenderers, Class<? extends LayerRenderer<T>> clazz, LayerRenderer<T> replacement) {
        ListIterator<LayerRenderer<T>> layerIterator = layerRenderers.listIterator();
        while (layerIterator.hasNext()) {
            if (layerIterator.next().getClass() == clazz) {
                layerIterator.set(replacement);
                break;
            }
        }
    }
}
