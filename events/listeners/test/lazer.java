package hydra.hunter.events.listeners.test;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class lazer implements
        Listener {



    @EventHandler
    public void onActivationLazer(final PlayerInteractEvent EVENT) {

        final Player PLAYER = EVENT.getPlayer();
        final Action ACTION = EVENT.getAction();

        List<Block> blocks = null;
        if (ACTION.equals(Action.RIGHT_CLICK_AIR)) {

            Class projectile = Snowball.class;

            final Location PLAYER_LOCATION = PLAYER.getLocation();


            Vector velocity = PLAYER_LOCATION.getDirection();
            velocity.multiply(50);

            PLAYER.launchProjectile(projectile, velocity);
        } else if (ACTION.equals(Action.RIGHT_CLICK_BLOCK)) {

            final Block CLICKED_BLOCK = EVENT.getClickedBlock();
            final Location PLAYER_LOCATION = CLICKED_BLOCK.getLocation();
            blocks = new ArrayList<>();

            List<Integer> xList = new ArrayList<>();
            List<Integer> yList = new ArrayList<>();
            List<Integer> zList = new ArrayList<>();

            int radius = 3;
            int blocksDown = 30;

            for (int x = PLAYER_LOCATION.getBlockX() - radius; x <= PLAYER_LOCATION.getBlockX(); x++) {
                for (int y = PLAYER_LOCATION.getBlockY() - radius; y <= blocksDown; y--) {
                    for (int z = PLAYER_LOCATION.getBlockZ() - radius; z <= PLAYER_LOCATION.getBlockZ(); z++) {
                        blocks.add(PLAYER_LOCATION.getWorld().getBlockAt(x, y, z));
                    }
                }
            }

            for (int x = PLAYER_LOCATION.getBlockX() - radius; x <= PLAYER_LOCATION.getBlockX(); x++) {
                xList.add(x);
            }

            for (int y = PLAYER_LOCATION.getBlockY() - blocksDown; y <= PLAYER_LOCATION.getBlockY(); y++) {
                yList.add(y);
            }

            for (int z = PLAYER_LOCATION.getBlockZ() - radius; z <= PLAYER_LOCATION.getBlockZ(); z++) {
                zList.add(z);
            }

            for (int x : xList) {
                for (int y : yList) {
                    for (int z : zList) {
                        blocks.add(PLAYER_LOCATION.getWorld().getBlockAt(x, y, z));
                    }
                }
            }

            for (Block i : blocks) {
                i.setType(Material.WATER);
            }
        }


    }
}
