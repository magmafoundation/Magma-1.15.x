package org.magmafoundation.magma.util;

import net.minecraft.entity.player.PlayerEntity;

import net.minecraft.entity.Entity;
import net.minecraft.world.server.ServerWorld;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;

/**
 * Magma
 *
 * @author Hexeption admin@hexeption.co.uk
 */
public class MagmaNMSUtils {
    public static ServerWorld toNMS(org.bukkit.World world) {
        return ((CraftWorld) world).getHandle();
    }

    public static PlayerEntity toNMS(org.bukkit.entity.Player player) {
        return ((CraftPlayer) player).getHandle();
    }

    public static Entity toNMS(org.bukkit.entity.Entity entity) {
        return ((CraftEntity) entity).getHandle();
    }
}

