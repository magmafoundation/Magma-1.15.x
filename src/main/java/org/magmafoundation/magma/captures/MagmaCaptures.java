package org.magmafoundation.magma.captures;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import org.bukkit.TreeType;
import org.bukkit.block.BlockState;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Magma
 *
 * @author Hexeption admin@hexeption.co.uk
 */
public class MagmaCaptures implements MagmaExtraCaptures{

    private static Entity entityChangeBlock;

    @Override
    public void captureEntityChangeBlock(Entity entity) {
        if (entityChangeBlock == null) {
            entityChangeBlock = entity;
        } else {
            recapture("entity change block");
        }
    }

    @Override
    public Entity getEntityChangeBlock() {
        try {
            return entityChangeBlock;
        } finally {
            entityChangeBlock = null;
        }
    }

    private static BlockBreakEvent blockBreakEvent;
    private static List<ItemEntity> blockDrops;
    private static BlockState blockBreakPlayerState;

    @Override
    public void captureBlockBreakPlayer(BlockBreakEvent event) {
        if (blockBreakEvent == null) {
            blockBreakEvent = event;
            blockDrops = new ArrayList<>();
            blockBreakPlayerState = event.getBlock().getState();
        } else {
            recapture("block break");
        }
    }

    @Override
    public BlockBreakEvent getBlockBreakPlayer() {
        return blockBreakEvent;
    }

    @Override
    public BlockState getBlockBreakPlayerState() {
        return blockBreakPlayerState;
    }

    @Override
    public List<ItemEntity> getBlockDrops() {
        return blockDrops;
    }

    @Override
    public BlockBreakEvent resetBlockBreakPlayer() {
        try {
            return blockBreakEvent;
        } finally {
            blockBreakEvent = null;
            blockDrops = null;
            blockBreakPlayerState = null;
        }
    }

    private static String quitMessage;

    @Override
    public void captureQuitMessage(String quitMessage) {
        if (MagmaCaptures.quitMessage == null) {
            MagmaCaptures.quitMessage = quitMessage;
        } else {
            recapture("quit message");
        }
    }

    @Override
    public String getQuitMessage() {
        try {
            return quitMessage;
        } finally {
            quitMessage = null;
        }
    }

    private static Direction placeEventDirection;

    @Override
    public void capturePlaceEventDirection(Direction direction) {
        MagmaCaptures.placeEventDirection = direction;
    }

    @Override
    public Direction getPlaceEventDirection() {
        try {
            return placeEventDirection;
        } finally {
            placeEventDirection = null;
        }
    }

    private static Hand placeEventHand;

    public static void capturePlaceEventHand(Hand hand) {
        if (MagmaCaptures.placeEventHand == null) {
            MagmaCaptures.placeEventHand = hand;
        } else {
            recapture("place hand");
        }
    }

    public static Hand getPlaceEventHand(Hand hand) {
        try {
            return placeEventHand == null ? hand : placeEventHand;
        } finally {
            placeEventHand = null;
        }
    }

    private static TreeType treeType;

    @Override
    public void captureTreeType(TreeType treeType) {

    }

    @Override
    public TreeType getTreeType() {
        try {
            return treeType = null;
        } finally {
            treeType = null;
        }
    }

    private static transient Container arclight$capturedContainer;

    @Override
    public void captureWorkbenchContainer(Container container) {
        if (arclight$capturedContainer == null) {
            arclight$capturedContainer = container;
        } else {
            recapture("workbench container");
        }
    }

    @Override
    public Container getWorkbenchContainer() {
        try {
            return arclight$capturedContainer;
        } finally {
            arclight$capturedContainer = null;
        }
    }

    private static transient Entity damageEventEntity;

    @Override
    public void captureDamageEventEntity(Entity entity) {
        damageEventEntity = entity;
    }

    @Override
    public Entity getDamageEventEntity() {
        try {
            return damageEventEntity;
        } finally {
            damageEventEntity = null;
        }
    }

    private static transient BlockPos damageEventBlock;

    @Override
    public void captureDamageEventBlock(BlockPos blockState) {
        damageEventBlock = blockState;
    }

    @Override
    public BlockPos getDamageEventBlock() {
        try {
            return damageEventBlock;
        } finally {
            damageEventBlock = null;
        }
    }

    public static void recapture(String type) {
        throw new IllegalStateException("Recapturing " + type);
    }

}
