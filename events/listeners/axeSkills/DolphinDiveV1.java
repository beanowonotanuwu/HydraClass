package hydra.hunter.events.listeners.axeSkills;

import hydra.hunter.core.implementations.axeSkills.DolphinDiveImplementations;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.UUID;

public class DolphinDiveV1 implements
        DolphinDiveImplementations {

    @EventHandler
    public void onDolphinDiveActivation(final PlayerInteractEvent EVENT) {


        /*
        Dolphin Dive v1
        Upon right clicking, player is launched far in the direction they
        are facing. This skill only works while you are in water.


        Dolphin Dive v2
        Upon shift right clicking a teammate that is in in water or while
        you are in water, they receive Dolphin's Grace for 3 seconds and
        regeneration II for 4 seconds
         */

        // calculations
        final Player PLAYER = EVENT.getPlayer();
        final UUID PLAYER_UUID = PLAYER.getUniqueId();

        // check if player has dolphin dive
        if (hasDolphinDive(PLAYER_UUID)) {

            // check if player has an axe in hand
            if (isAxe(PLAYER)) {

                // check for dolphin dive 1
                final Action ACTION = EVENT.getAction();
                if (isRightClick(ACTION)) {

                    // check if player in water
                    if (inWater(PLAYER)) {

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


                        dolphinDiveV1Activation(PLAYER);

                        // particles and sound


                    } else if (inLava(PLAYER)) {

                        EVENT.setCancelled(true);
                        whileInLava(PLAYER);
                    }
                }
            }
        }
    }
}
