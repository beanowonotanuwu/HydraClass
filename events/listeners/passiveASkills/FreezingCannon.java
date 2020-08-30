package hydra.hunter.events.listeners.passiveASkills;

import hydra.hunter.core.implementations.passiveASkills.FreezingCannonImplementations;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class FreezingCannon implements
        FreezingCannonImplementations {

    @EventHandler
    public void onFreezingCannonActivation(final PlayerDropItemEvent EVENT) {

        // calculations
        final Player PLAYER = EVENT.getPlayer();
        final UUID PLAYER_UUID = PLAYER.getUniqueId();
        final Location PLAYER_LOCATION = PLAYER.getLocation();

        // check for skill
        if (hasFreezingCannon(PLAYER_UUID)) {

            // check for item dropped
            final Item ITEM = EVENT.getItemDrop();
            final ItemStack DROPPED_ITEM = ITEM.getItemStack();
            final Material DROPPED_ITEM_TYPE = DROPPED_ITEM.getType();
            if (
                    (IS_SWORD.contains(DROPPED_ITEM_TYPE)) || (IS_AXE.contains(DROPPED_ITEM_TYPE))
            ) {

                // cancel event
                EVENT.setCancelled(true);

                if (inLava(PLAYER)) {

                    whileInLava(PLAYER);

                    // play a sound and some particles


                    return;
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

                    } else {

                    }
                }
                cooldowns.put(PLAYER_UUID, System.currentTimeMillis() + (COOLDOWN_DURATION * 1000));

                freezingCannonLaunch(PLAYER);

                // play sound
                PLAYER.playSound(
                        PLAYER_LOCATION,
                        FREEZING_CANNON_LAUNCH_SOUND,
                        FREEZING_CANNON_LAUNCH_VOLUME,
                        FREEZING_CANNON_LAUNCH_PITCH
                );
            }
        }
    }
}
