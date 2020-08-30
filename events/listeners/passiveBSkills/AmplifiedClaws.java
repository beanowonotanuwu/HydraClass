package hydra.hunter.events.listeners.passiveBSkills;

import hydra.hunter.core.implementations.passiveBSkills.AmplifiedClawImplementations;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.UUID;

public class AmplifiedClaws implements
        AmplifiedClawImplementations {

    @EventHandler
    public void onAmplifiedClawsActivation(final EntityDamageByEntityEvent EVENT) {

        // calculations
        final Entity HIT_ENTITY = EVENT.getEntity();
        final Entity DAMAGER = EVENT.getDamager();

        // check if damager is living
        if (DAMAGER instanceof LivingEntity) {

            // check if hit entity is living
            if (HIT_ENTITY instanceof LivingEntity) {

                // check if damager is a player
                if (DAMAGER instanceof Player) {

                    // cast damager --> player and hit entity --> livingentity
                    final Player PLAYER = (Player) DAMAGER;
                    final UUID PLAYER_UUID = PLAYER.getUniqueId();
                    final LivingEntity LIVING_HIT_ENTITY = (LivingEntity) HIT_ENTITY;

                    // check if player is has skill
                    if (hasAmplifiedClaws(PLAYER_UUID)) {

                        // get the player health
                        amplifiedClawAttack(PLAYER, LIVING_HIT_ENTITY);
                    }
                }
            }
        }
    }
}
