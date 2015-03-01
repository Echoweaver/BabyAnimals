package com.outlook.siribby.babyanimals.core;

import com.outlook.siribby.babyanimals.BabyAnimals;
import net.minecraftforge.fml.common.asm.transformers.AccessTransformer;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import java.io.IOException;
import java.util.Map;

@IFMLLoadingPlugin.TransformerExclusions("com.outlook.siribby.babyanimals.core.")
public class BabyAnimalsCore extends AccessTransformer implements IFMLLoadingPlugin {
    public BabyAnimalsCore() throws IOException {
        super(BabyAnimals.MOD_ID + "_at.cfg");
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
    }

    @Override
    public String getAccessTransformerClass() {
        return getClass().getName();
    }
}
