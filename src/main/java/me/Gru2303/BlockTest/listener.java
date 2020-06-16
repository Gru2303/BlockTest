package me.Gru2303.BlockTest;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;

public class listener implements Listener {

    public Map<String, BlockFace> users = new HashMap<>();

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteractEvent(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        BlockFace bf = e.getBlockFace();

        newMapValue(p.getName(), bf);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        BlockManager bm = new BlockManager(e.getBlock());
        Material hand = p.getItemInHand().getType();

        switch (hand) {
            case DIAMOND_PICKAXE:
                bm.destroyBlock(users.get(p.getName()), 2);
                break;
            case IRON_PICKAXE:
                bm.destroyBlock(users.get(p.getName()), 1);
                break;
        }
    }

    private void newMapValue(String name, BlockFace i) {
        if (users.containsKey(name)) {
            users.replace(name, i);
        } else {
            users.put(name, i);
        }
    }
}
