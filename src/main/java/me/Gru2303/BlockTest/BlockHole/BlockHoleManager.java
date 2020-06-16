package me.Gru2303.BlockTest.BlockHole;

import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class BlockHoleManager {

    private Location center;

    public BlockHoleManager(Location center) {
        this.center = center;
    }

    public List<Block> getBlockHole(int radius) {
        return getBlockHole(radius, BlockHoleType.HORIZONTAL);
    }

    public List<Block> getBlockHole(int radius, BlockHoleType type) {
        List<Block> blocks = new ArrayList<>();
        int x = 0;
        int y = 0;
        int z = 0;

        for (List<Integer> coords : getCords(radius)) {
            int nemoCoord = coords.get(0);
            int nemoCoordTwo = coords.get(1);

            switch (type) {
                case VERTICAL:
                case VERTICAL_X:
                    y = nemoCoord;
                    x = nemoCoordTwo;
                    break;
                case VERTICAL_Z:
                    y = nemoCoord;
                    z = nemoCoordTwo;
                    break;
                default:
                    x = nemoCoord;
                    z = nemoCoordTwo;
            }

            Block block = center.getBlock().getRelative(x, y, z);

            blocks.add(block);
        }

        return blocks;
    }

    private List<List<Integer>> getCords(int radius) {
        List<List<Integer>> cords = new ArrayList<>();

        for (int nemoCoord = -radius; nemoCoord <= radius; nemoCoord++) {
            for (int nemoCoordTwo = -radius; nemoCoordTwo <= radius; nemoCoordTwo++) {
                List<Integer> cord = new ArrayList<>();

                cord.add(nemoCoord);
                cord.add(nemoCoordTwo);

                cords.add(cord);
            }
        }

        return cords;
    }
}
