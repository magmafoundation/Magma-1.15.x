package org.magmafoundation.magma;

import com.google.common.cache.CacheLoader;
import com.google.common.collect.Iterables;
import com.mojang.authlib.Agent;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.ProfileLookupCallback;
import com.mojang.authlib.properties.Property;
import net.minecraft.entity.player.PlayerEntity;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_15_R1.CraftServer;

import java.util.UUID;

/**
 * Magma
 *
 * @author Hexeption admin@hexeption.co.uk
 */
public class MagmaHeadLoader extends CacheLoader<String, GameProfile> {

    @Override
    public GameProfile load(String key) {
        GameProfile[] profiles = {null};
        ProfileLookupCallback gameProfileLookup = new ProfileLookupCallback() {
            @Override
            public void onProfileLookupSucceeded(GameProfile gp) {
                profiles[0] = gp;
            }

            @Override
            public void onProfileLookupFailed(GameProfile gp, Exception excptn) {
                profiles[0] = gp;
            }
        };
        ((CraftServer) Bukkit.getServer()).getServer().getGameProfileRepository().findProfilesByNames(new String[]{key}, Agent.MINECRAFT, gameProfileLookup);
        GameProfile profile = profiles[0];
        if (profile == null) {
            UUID uuid = PlayerEntity.getUUID(new GameProfile(null, key));
            profile = new GameProfile(uuid, key);
            gameProfileLookup.onProfileLookupSucceeded(profile);
        } else {
            Property property = Iterables.getFirst((profile.getProperties()).get("textures"), null);

        }
        return null;
    }
}
