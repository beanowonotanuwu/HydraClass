package hydra.hunter.events.listeners.axeSkills;

import hydra.hunter.core.implementations.axeSkills.ViperSpitImplementations;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.UUID;

public class ViperSpit implements
        ViperSpitImplementations {

    @EventHandler
    public void onViperSpitActivation(final PlayerInteractEvent EVENT) {

        // calculations
        final Player PLAYER = EVENT.getPlayer();
        final UUID PLAYER_UUID = PLAYER.getUniqueId();

        // check if player has skill
        if (hasViperSpit(PLAYER_UUID)) {

            // check for item in hand
            if (isAxe(PLAYER)) {

                // check for viper spit activation
                final Action ACTION = EVENT.getAction();
                if (isRightClick(ACTION)) {

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

                        } else {

                            // bring blocks back
                            final Location PLAYER_LOCATION = PLAYER.getLocation();
                            final Block STANDING = PLAYER_LOCATION.getBlock();
                            bringBlocksBack(STANDING);
                        }
                    }
                    cooldowns.put(PLAYER_UUID, System.currentTimeMillis() + (COOLDOWN_DURATION * 1000));

                    // shoot projectile
                    viperSpitProjectileLaunch(PLAYER);
                }
            }
        }
    }
}
