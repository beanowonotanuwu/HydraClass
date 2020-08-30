package hydra.hunter.events.listeners.passiveASkills;

import hydra.hunter.core.implementations.passiveASkills.GlassCannonImplementations;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.UUID;

public class GlassCannonV3 implements
        GlassCannonImplementations {

    @EventHandler
    public void onGlassCannonActivationV3(final PlayerInteractEvent EVENT) {

        // calculations
        final Player PLAYER = EVENT.getPlayer();
        final UUID PLAYER_UUID = PLAYER.getUniqueId();

        // check if player is in list
        if (hydrasUsingGlassCannonAndFlying.contains(PLAYER_UUID)) {

            // check for action
            final Action ACTION = EVENT.getAction();
            if (isLeftClick(ACTION)) {

                // if in hashmap
                if (fireballCooldowns.containsKey(PLAYER_UUID)) {

                    // check for cooldown
                    if (fireballCooldowns.get(PLAYER_UUID) > System.currentTimeMillis()) {


                        return;

                    } else {

                    }
                }
                fireballCooldowns.put(PLAYER_UUID, System.currentTimeMillis() + (FIREBALL_COOLDOWN_DURATION * 1000));
                glassCannonFire(PLAYER);
            }
        }
    }
}
