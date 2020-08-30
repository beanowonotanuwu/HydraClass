package hydra.hunter.events.listeners.test;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class FastWalking implements
        Listener {

    @EventHandler
    public void fastWalk(final PlayerMoveEvent EVENT) {

        // calcs
        final Player PLAYER = EVENT.getPlayer();
        final Location PLAYER_LOCATION = PLAYER.getLocation();
        final Block STANDING_ON = PLAYER_LOCATION.getBlock();

        // get higher block
        final int X = STANDING_ON.getX();
        final int Y = STANDING_ON.getY();
        final int Z = STANDING_ON.getZ();

        final int NEW_Y = Y + 0;

        final World WRLD = PLAYER_LOCATION.getWorld();

        final Block NEW_BLOCK = WRLD.getBlockAt(X, NEW_Y, Z);

        // check for type
        if (NEW_BLOCK.getType().equals(Material.WATER)) {

            // set type
            NEW_BLOCK.setType(Material.AIR);
        }

        if (PLAYER.isSneaking()) {
            PLAYER.setWalkSpeed(20.0F);
        }
    }
}
