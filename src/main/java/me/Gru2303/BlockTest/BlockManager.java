package me.Gru2303.BlockTest;

import me.Gru2303.BlockTest.BlockHole.BlockHoleManager;
import me.Gru2303.BlockTest.BlockHole.BlockHoleType;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class BlockManager {

    Block b;

    public BlockManager(Block b) {
        this.b = b;
    }

    public void destroyBlock(BlockFace type, int radius) {
        List<Block> blocks = null;
        BlockHoleManager bhm = new BlockHoleManager(b.getLocation());

        switch (type) {
            case NORTH:
            case SOUTH:
                blocks = bhm.getBlockHole(radius, BlockHoleType.VERTICAL);
                break;
            case WEST:
            case EAST:
                blocks = bhm.getBlockHole(radius, BlockHoleType.VERTICAL_Z);
                break;
            default:
                blocks = bhm.getBlockHole(radius);

        }

        breakBlocks(blocks);
    }

    private void breakBlocks(List<Block> blocks) {
        for (Block b : blocks) {
            Material d = b.getType();

            if (!d.equals(Material.AIR)) {
                ItemStack drop = new ItemStack(d, 1);

                b.getLocation().getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, d);
                b.setType(Material.AIR);
                b.getLocation().getWorld().dropItemNaturally(b.getLocation(), drop);
            }
        }
    }
}
