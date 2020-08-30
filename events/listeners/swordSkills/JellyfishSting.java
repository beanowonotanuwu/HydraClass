package hydra.hunter.events.listeners.swordSkills;

import hydra.hunter.core.implementations.swordSkills.JellyfishStingImplementations;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.util.UUID;

public class JellyfishSting implements
        JellyfishStingImplementations {


    @EventHandler
    public void onSting(final PlayerInteractAtEntityEvent EVENT) {

        // calculations
        final Player PLAYER = EVENT.getPlayer();
        final UUID PLAYER_UUID = PLAYER.getUniqueId();
        final Entity RIGHT_CLICKED_ENTITY = EVENT.getRightClicked();

        // check if player has JellyfishSting
        if (hasJellyfishSting(PLAYER_UUID)) {

            // check for item in hand
            if (isSword(PLAYER)) {

                // check if the entity is living
                if (rightClickedLivingEntity(RIGHT_CLICKED_ENTITY)) {

                    // cast the entity
                    final LivingEntity ENTITY = (LivingEntity) RIGHT_CLICKED_ENTITY;


                    // checks for block
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

                                // cancel
                                EVENT.setCancelled(CANCEL_EVENT_ON_COOLDOWN);

                                // return
                                return;
                            }
                        }

                        cooldowns.put(PLAYER_UUID, System.currentTimeMillis() + (COOLDOWN_DURATION * 1000));


                        // add effects and/or damage
                        jellyfishStingAttackWater(ENTITY);

                        // play a sound and some particles
                        playSoundJellyfishStingWater(PLAYER);

                    } else if (inLava(PLAYER)) {

                        EVENT.setCancelled(true);
                        whileInLava(PLAYER);

                        // play a sound and some particles


                        return;
                    } else {



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

                                // cancel
                                EVENT.setCancelled(CANCEL_EVENT_ON_COOLDOWN);

                                // return
                                return;
                            }
                        }

                        cooldowns.put(PLAYER_UUID, System.currentTimeMillis() + (COOLDOWN_DURATION * 1000));

                        jellyfishStingAttackLand(ENTITY);

                        // play a sound and some particles
                        playSoundJellyfishStingLand(PLAYER);
                    }
                }
            }
        }
    }
}
