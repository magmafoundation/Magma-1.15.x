package org.magmafoundation.magma.captures;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import org.bukkit.TreeType;
import org.bukkit.block.BlockState;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.List;

/**
 * Magma
 *
 * @author Hexeption admin@hexeption.co.uk
 */
public interface MagmaExtraCaptures {

    void captureEntityChangeBlock(Entity entity);

    Entity getEntityChangeBlock();

    void captureBlockBreakPlayer(BlockBreakEvent event);

    BlockBreakEvent getBlockBreakPlayer();

    BlockState getBlockBreakPlayerState();

    List<ItemEntity> getBlockDrops();

    BlockBreakEvent resetBlockBreakPlayer();

    void captureQuitMessage(String quitMessage);

    String getQuitMessage();

    void capturePlaceEventDirection(Direction direction);

    Direction getPlaceEventDirection();

    void captureTreeType(TreeType treeType);

    TreeType getTreeType();

    void captureWorkbenchContainer(Container container);

    Container getWorkbenchContainer();

    void captureDamageEventEntity(Entity entity);

    Entity getDamageEventEntity();

    void captureDamageEventBlock(BlockPos blockState);

    BlockPos getDamageEventBlock();
}
