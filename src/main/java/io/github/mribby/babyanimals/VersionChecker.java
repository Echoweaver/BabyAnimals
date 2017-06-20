package io.github.mribby.babyanimals;

import com.google.common.io.ByteStreams;
import com.google.gson.Gson;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
import net.minecraft.nbt.NBTTagCompound;

import java.io.InputStream;
import java.net.URL;
import java.util.Map;

public class VersionChecker {
    public static void startVersionCheck() {
        new Thread(BabyAnimalsMod.NAME + " Version Check") {
            @Override
            public void run() {
                try {
                    URL url = new URL(BabyAnimalsMod.UPDATE_JSON_URL);
                    InputStream con = url.openStream();
                    String data = new String(ByteStreams.toByteArray(con));
                    con.close();

                    Map<String, Object> json = new Gson().fromJson(data, Map.class);
                    String homepage = (String) json.get("homepage");
                    Map<String, String> promos = (Map<String, String>) json.get("promos");

                    String rec = promos.get(Loader.MC_VERSION + "-recommended");
                    String lat = promos.get(Loader.MC_VERSION + "-latest");
                    ArtifactVersion current = new DefaultArtifactVersion(BabyAnimalsMod.VERSION);
                    String target = null;

                    if (rec != null) {
                        ArtifactVersion recommended = new DefaultArtifactVersion(rec);
                        int diff = recommended.compareTo(current);

                        if (diff < 0) {
                            if (lat != null) {
                                if (current.compareTo(new DefaultArtifactVersion(lat)) < 0) {
                                    target = lat;
                                }
                            }
                        } else if (diff > 0) {
                            target = rec;
                        }
                    } else if (lat != null) {
                        if (current.compareTo(new DefaultArtifactVersion(lat)) < 0) {
                            target = lat;
                        }
                    }

                    if (target != null) {
                        sendUpdateIMCMessage(target, homepage);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private static void sendUpdateIMCMessage(String newVersion, String updateUrl) {
        if (Loader.isModLoaded("VersionChecker")) {
            NBTTagCompound tag = new NBTTagCompound();
            tag.setString("modDisplayName", BabyAnimalsMod.NAME);
            tag.setString("oldVersion", BabyAnimalsMod.VERSION);
            tag.setString("newVersion", newVersion);
            tag.setString("updateUrl", updateUrl);
            tag.setBoolean("isDirectLink", false);
            FMLInterModComms.sendRuntimeMessage(BabyAnimalsMod.MODID, "VersionChecker", "addUpdate", tag);
        }
    }
}
