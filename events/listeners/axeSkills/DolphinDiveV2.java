package hydra.hunter.events.listeners.axeSkills;

import hydra.hunter.core.implementations.axeSkills.DolphinDiveImplementations;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.util.UUID;

public class DolphinDiveV2 implements
        DolphinDiveImplementations {

    @EventHandler
    public void onDolphinDiveV2Activation(final PlayerInteractAtEntityEvent EVENT) {

        // calculations
        final Player PLAYER = EVENT.getPlayer();
        final UUID PLAYER_UUID = PLAYER.getUniqueId();
        final Entity RIGHT_CLICKED_ENTITY = EVENT.getRightClicked();

        // check if player has dolphin dive
        if (hasDolphinDive(PLAYER_UUID)) {

            // check for item in hand
            if (isAxe(PLAYER)) {

                // check if right clicked entity is a player
                if (isPlayer(RIGHT_CLICKED_ENTITY)) {

                    // cast entity
                    final Player RECEIVER = (Player) RIGHT_CLICKED_ENTITY;

                    // check if right clicked player is in water or if you are in water
                    final Location ENTITY_LOCATION = RIGHT_CLICKED_ENTITY.getLocation();
                    final Location PLAYER_LOCATION = PLAYER.getLocation();

                    final Block STANDING_ENTITY = ENTITY_LOCATION.getBlock();
                    final Block STANDING_PLAYER = PLAYER_LOCATION.getBlock();

                    final Material STANDING_TYPE_ENTITY = STANDING_ENTITY.getType();
                    final Material STANDING_TYPE_PLAYER = STANDING_PLAYER.getType();

                    if (
                            (
                            STANDING_TYPE_ENTITY.equals(WATER))
                            ||
                            (
                                    STANDING_TYPE_PLAYER.equals(WATER))
                    ) {

                        // check if player is sneaking
                        if (isSneaking(PLAYER)) {

                            // COOLDOWN AREA
                            // check if player in hashmap
                            if (cooldowns.containsKey(PLAYER_UUID)) {

                                // check for cooldown
                                if (cooldowns.get(PLAYER_UUID) > System.currentTimeMillis()) {

                                    // they still have time left in the cooldown
                                    long timeLeft = (cooldowns.get(PLAYER_UUID) - System.currentTimeMillis()) / 1000;
                                    PLAYER.sendMessage(
                                            SKILL_ON_COOLDOWN_COLOR
                                                    + COOLDOWN_MESSAGE_P1
                                                    + timeLeft
                                                    + COOLDOWN_MESSAGE_P2
                                    );
                                    return;

                                }
                            }
                            cooldowns.put(PLAYER_UUID, System.currentTimeMillis() + (COOLDOWN_DURATION * 1000));

                            // apply effects
                            dolphinDiveV2Activation(RECEIVER);
                        }
                    }
                }
            }
        }
    }
}
