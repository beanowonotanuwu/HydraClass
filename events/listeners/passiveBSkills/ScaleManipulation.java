package hydra.hunter.events.listeners.passiveBSkills;

import hydra.hunter.core.implementations.passiveBSkills.ScaleManipulationImplementations;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.UUID;

public class ScaleManipulation implements
        ScaleManipulationImplementations {

    @EventHandler
    public void onScaleManipulationActivation(final EntityDamageEvent EVENT) {

        // calcs
        final Entity ENTITY = EVENT.getEntity();

        // check if entity is a player
        if (isPlayer(ENTITY)) {

            // cast entity --> player
            final Player PLAYER = (Player) ENTITY;
            final UUID PLAYER_UUID = PLAYER.getUniqueId();

            // check if player has scale manipulation
            if (hasScaleManipulation(PLAYER_UUID)) {

                // check for cause
                final EntityDamageEvent.DamageCause CAUSE = EVENT.getCause();
                final double DAMAGE = EVENT.getDamage();
                switch (CAUSE) {
                    case PROJECTILE:
                        final double PROJECTILE = reduceProjectileDamage(DAMAGE);
                        EVENT.setDamage(PROJECTILE);
                    case ENTITY_ATTACK:
                        final double MELEE = reduceMeleeDamage(DAMAGE);
                        EVENT.setDamage(MELEE);
                }
            }
        }
    }
}
