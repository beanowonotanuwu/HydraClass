package hydra.hunter.events.listeners.swordSkills;

import hydra.hunter.core.constants.skill.swordSkills.ViperBreathConstants;
import hydra.hunter.core.implementations.swordSkills.ViperBreathImplementations;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.UUID;

public class ViperBreath implements
        ViperBreathImplementations {


    @EventHandler
    public void onViperBreathActivation(final PlayerInteractEvent EVENT) throws InterruptedException {

        // check to see if player has ability
        final Player PLAYER = EVENT.getPlayer();
        final UUID PLAYER_UUID = PLAYER.getUniqueId();
        if (hasViperBreath(PLAYER_UUID)) {

            // check if player has a sword in hand
            if (isSword(PLAYER)) {


                // check if action is a right click
                final Action PLAYER_ACTION = EVENT.getAction();
                if (
                        PLAYER_ACTION.equals(VIPER_BREATH_ACTIVATION_1)
                                ||
                                PLAYER_ACTION.equals(VIPER_BREATH_ACTIVATION_2)) {

                    // check if player is underwater
                    final Location PLAYER_LOCATION = PLAYER.getLocation();
                    final Block PLAYER_STANDING_ON = PLAYER_LOCATION.getBlock();
                    final Material BLOCK_TYPE = PLAYER_STANDING_ON.getType();

                    if (BLOCK_TYPE.equals(ViperBreathConstants.WATER)) {

                        // damage the player
                        PLAYER.damage(DAMAGE_USING_UNDERWATER);
                        return;

                        // check if player is in lava
                    }

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

                    // activate skill
                    viperBreathShoot(PLAYER);
                }
            }
        }
    }
}
