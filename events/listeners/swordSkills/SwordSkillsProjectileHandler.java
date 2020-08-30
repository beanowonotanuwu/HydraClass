package hydra.hunter.events.listeners.swordSkills;

import hydra.hunter.core.implementations.swordSkills.SwordSkillsProjectileHandlerImplementations;
import hydra.hunter.core.constants.util.projectile.SwordSkillProjectileConstants;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.projectiles.ProjectileSource;

public class SwordSkillsProjectileHandler implements
        SwordSkillsProjectileHandlerImplementations,
        SwordSkillProjectileConstants {

    @EventHandler
    public void onProjectileImpact(final EntityDamageByEntityEvent EVENT) {

        // calculations
        Entity damager = EVENT.getDamager();

        // check if damager is a fireball
        if (damager instanceof Fireball) {

            // check if shooter is a player
            final Fireball DAMAGER = (Fireball) damager;
            final ProjectileSource SHOOTER = DAMAGER.getShooter();
            if (SHOOTER instanceof Player) {

                // set the damage
                EVENT.setDamage(VIPER_BREATH_IMPACT_DAMAGE);

                // spawn some particles
                Entity entity = EVENT.getEntity();

                // check if entity is living
                if (entity instanceof LivingEntity) {

                    // cast entity
                    final LivingEntity ENTITY = (LivingEntity) entity;

                    // add potion effect
                    ENTITY.addPotionEffect(VIPER_BREATH_IMPACT_EFFECT);
                }
            }
        }
    }
}
