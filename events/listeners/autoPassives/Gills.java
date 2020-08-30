package hydra.hunter.events.listeners.autoPassives;

import hydra.hunter.core.implementations.autoPassives.GillsImplementations;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.UUID;

public class Gills implements
        GillsImplementations {

    @EventHandler
    public void onEnterWatering(final PlayerMoveEvent EVENT) {

        // calculations
        final Player PLAYER = EVENT.getPlayer();
        final UUID PLAYER_UUID = PLAYER.getUniqueId();

        final Location PLAYER_LOCATION = PLAYER.getLocation();
        final Block BLOCK_PLAYER_IS_STANDING_ON = PLAYER_LOCATION.getBlock();
        final Material BLOCK_TYPE = BLOCK_PLAYER_IS_STANDING_ON.getType();

        // check if the player is a shifter
        if (isHydra(PLAYER_UUID)) {

            // check if the player is standing in water
            if (BLOCK_TYPE.equals(WATER_MATERIAL_TYPE)) {

                // if so grant the effect
                grantWaterBreathing(PLAYER);
            }
        }
    }
}
