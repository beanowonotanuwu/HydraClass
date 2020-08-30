package hydra.hunter.events.listeners.axeSkills;

import hydra.hunter.core.constants.skill.axeSkills.ViperSpitConstants;
import hydra.hunter.core.trackers.SkillTracker;
import hydra.hunter.core.vaults.axeSkillsVault.ViperSpitVault;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.projectiles.ProjectileSource;

import java.util.UUID;

public class AxeSkillsProjectileHandler implements
        ViperSpitConstants,
        ViperSpitVault,
        Listener,
        SkillTracker {

    @EventHandler
    public void onProjectileHit(final ProjectileHitEvent EVENT) {

        // calculations
        final Projectile ENTITY = EVENT.getEntity();
        final ProjectileSource SHOOTER = ENTITY.getShooter();

        // check for shooter
        if (SHOOTER instanceof Player) {

            // cast SHOOTER --> PLAYER
            final Player PLAYER = (Player) SHOOTER;
            final UUID PLAYER_UUID = PLAYER.getUniqueId();

            // check if player has viper spit permission
            if (hasViperSpit(PLAYER_UUID)) {

                // check for projectile
                if (ENTITY instanceof Snowball) {

                    // check if living entity was hit
                    final Entity HIT_ENTITY = EVENT.getHitEntity();
                    if (HIT_ENTITY instanceof LivingEntity) {

                        final LivingEntity ENTITY_LIVING = (LivingEntity) HIT_ENTITY;

                        final Location ENTITY_LOCATION = ENTITY.getLocation();
                        final Block STANDING_BLOCK = ENTITY_LOCATION.getBlock();
                        viperSpitProjectileImpactLivingEntity(ENTITY_LIVING);

                    } else {

                        // get block
                        final Block HIT_BLOCK = EVENT.getHitBlock();
                        viperSpitProjectileImpact(HIT_BLOCK);


                    }
                }
            }
        }
    }
}
