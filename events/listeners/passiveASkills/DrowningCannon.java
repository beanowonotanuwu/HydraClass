package hydra.hunter.events.listeners.passiveASkills;

import hydra.hunter.Hunter;
import hydra.hunter.core.implementations.passiveASkills.DrowningCannonImplementations;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class DrowningCannon implements
        DrowningCannonImplementations {

    Hunter plugin;

    public DrowningCannon(Hunter plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDrowningCannonActivation(final PlayerDropItemEvent EVENT) {

        // calculations
        final Player PLAYER = EVENT.getPlayer();
        final UUID PLAYER_UUID = PLAYER.getUniqueId();
        final Location PLAYER_LOCATION = PLAYER.getLocation();

        // check for skill
        if (hasDrowningCannon(PLAYER_UUID)) {

            // check for item dropped
            final Item ITEM = EVENT.getItemDrop();
            final ItemStack DROPPED_ITEM = ITEM.getItemStack();
            final Material DROPPED_ITEM_TYPE = DROPPED_ITEM.getType();
            if (
                    (IS_SWORD.contains(DROPPED_ITEM_TYPE)) || (IS_AXE.contains(DROPPED_ITEM_TYPE))
            ) {

                // cancel event
                EVENT.setCancelled(true);

                // check for lava
                if (inLava(PLAYER)) {

                    whileInLava(PLAYER);


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

                drowningCannonFire(PLAYER);

                // play sound
                PLAYER.playSound(PLAYER_LOCATION, ON_THROW, volume, pitch);
            }
        }
    }
}
