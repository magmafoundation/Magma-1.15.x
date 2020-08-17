/*
 * Magma Server
 * Copyright (C) 2019-2020.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

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
