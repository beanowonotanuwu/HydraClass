package hydra.hunter.events.listeners.passiveASkills;

import hydra.hunter.Hunter;
import hydra.hunter.core.implementations.passiveASkills.GlassCannonImplementations;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.UUID;

public class GlassCannonV2 implements
        GlassCannonImplementations {

    Hunter plugin;

    public GlassCannonV2(Hunter plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onGlassCannonActivationV2(final PlayerMoveEvent EVENT) {

        // calculations
        final Player PLAYER = EVENT.getPlayer();
        final UUID PLAYER_UUID = PLAYER.getUniqueId();

        // check if player has glass cannon
        if (hasGlassCannon(PLAYER_UUID)) {

            // check if player is flying
            if (hydrasUsingGlassCannonAndFlying.contains(PLAYER_UUID)) {

                // check if players x or z changed
                final Location FROM = EVENT.getFrom();
                final Location TO = EVENT.getTo();

                final double START_X = FROM.getX();
                final double START_Z = FROM.getZ();

                final double END_X = TO.getX();
                final double END_Z = TO.getZ();

                if (START_X == END_X || START_Z == END_Z) {
                    return;
                }

                // cancel event
                EVENT.setCancelled(true);


            }
        }
    }
}
