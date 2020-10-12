package org.bukkit.craftbukkit.v1_15_R1.util;

import java.util.*;

import net.minecraft.util.math.BlockPos;
import net.minecraft.fluid.IFluidState;
import net.minecraft.world.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.v1_15_R1.block.CraftBlockState;

public class BlockStateListPopulator extends DummyGeneratorAccess {
    private final World world;
    private final LinkedHashMap<BlockPos, CraftBlockState> list;

    public BlockStateListPopulator(World world) {
        this(world, new LinkedHashMap<>());
    }

    public BlockStateListPopulator(World world, LinkedHashMap<BlockPos, CraftBlockState> list) {
        this.world = world;
        this.list = list;
    }

    @Override
    public net.minecraft.block.BlockState getBlockState(BlockPos bp) {
        CraftBlockState state = list.get(bp);
        return (state != null) ? state.getHandle() : world.getBlockState(bp);
    }

    @Override
    public IFluidState getFluidState(BlockPos bp) {
        CraftBlockState state = list.get(bp);
        return (state != null) ? state.getHandle().getFluidState() : world.getFluidState(bp);
    }

    @Override
    public boolean setBlockState(BlockPos position, net.minecraft.block.BlockState data, int flag) {
        CraftBlockState state = CraftBlockState.getBlockState(world, position, flag);
        state.setData(data);
        list.put(position, state);
        return true;
    }

    public void updateList() {
        for (BlockState state : list.values()) {
            state.update(true);
        }
    }

    public Set<BlockPos> getBlocks() {
        return list.keySet();
    }

    public List<BlockState> getBlockStates(){
        ArrayList<BlockState> states = new ArrayList<>();
        for(BlockPos bp : list.keySet()){
            states.add(list.get(bp));
        }
        return states;
    }

    public List<CraftBlockState> getList() {
        return new ArrayList<>(list.values());
    }

    public World getWorld() {
        return world;
    }
}
