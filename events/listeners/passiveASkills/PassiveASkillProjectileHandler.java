package hydra.hunter.events.listeners.passiveASkills;

import hydra.hunter.Hunter;
import hydra.hunter.core.implementations.passiveASkills.DrowningCannonImplementations;
import hydra.hunter.core.implementations.passiveASkills.FreezingCannonImplementations;
import hydra.hunter.core.implementations.passiveASkills.GlassCannonImplementations;
import hydra.hunter.core.implementations.passiveASkills.InkingCannonImplementations;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.projectiles.ProjectileSource;

import java.util.UUID;

public class PassiveASkillProjectileHandler implements
        DrowningCannonImplementations,
        FreezingCannonImplementations,
        InkingCannonImplementations,
        GlassCannonImplementations {

    Hunter plugin;


    public PassiveASkillProjectileHandler(Hunter plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void projectileHandler(final ProjectileHitEvent EVENT) {

        // calculations
        final Projectile ENTITY = EVENT.getEntity();
        final ProjectileSource SHOOTER = ENTITY.getShooter();

        // check for shooter
        if (SHOOTER instanceof Player) {

            // cast SHOOTER --> PLAYER
            final Player PLAYER = (Player) SHOOTER;
            final UUID PLAYER_UUID = PLAYER.getUniqueId();

            // check if player has permission
            if (hasDrowningCannon(PLAYER_UUID)) {

                // check for projectile
                if (ENTITY instanceof Egg) {

                    // check if living entity was hit
                    final Entity HIT_ENTITY = EVENT.getHitEntity();
                    if (HIT_ENTITY instanceof LivingEntity) {

                        // get entity location
                        final Location ENTITY_LOCATION = HIT_ENTITY.getLocation();
                        final Block STANDING_ON = ENTITY_LOCATION.getBlock();

                        // burrow blocks
                        burrowBlocks(STANDING_ON);


                    } else {
                        final Block HIT_BLOCK = EVENT.getHitBlock();
                        burrowBlocks(HIT_BLOCK);

                    }

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> bringBlocksBack(), 200L);

                    // sounds
                    final Location PLAYER_LOCATION = PLAYER.getLocation();
                    PLAYER.playSound(PLAYER_LOCATION, ON_IMPACT, volume, pitch);
                }

            } else if (hasFreezingCannon(PLAYER_UUID)) {

                // check for projectile
                if (ENTITY instanceof Egg) {

                    // check if living entity was hit
                    final Entity HIT_ENTITY = EVENT.getHitEntity();
                    if (HIT_ENTITY instanceof LivingEntity) {

                        // cast entity to livingentity
                        final LivingEntity LIVING_HIT_ENTITY = (LivingEntity) HIT_ENTITY;

                        // inflict effects
                        freezingCannonHit(LIVING_HIT_ENTITY);

                        // inflict extra kb
                        freezingCannonHitKnockback(LIVING_HIT_ENTITY);

                        // check if entity is a player
                        if (LIVING_HIT_ENTITY instanceof Player) {

                            // cast entity --> player
                            final Player HIT_PLAYER = (Player) LIVING_HIT_ENTITY;
                            final Location PLAYER_LOCATION = PLAYER.getLocation();


                            HIT_PLAYER.spawnParticle(
                                    ON_IMPACT_PARTICLE_FREEZING_CANNON, PLAYER_LOCATION, PARTICLE_COUNT_FREEZING_CANNON
                            );
                        }
                    }
                }

            } else if (hasInkingCannon(PLAYER_UUID)) {

                // check for projectile
                if (ENTITY instanceof Egg) {

                    // check if living entity was hit
                    final Entity HIT_ENTITY = EVENT.getHitEntity();
                    if (HIT_ENTITY instanceof LivingEntity) {

                        // cast entity to livingentity
                        final LivingEntity LIVING_HIT_ENTITY = (LivingEntity) HIT_ENTITY;

                        // inflict effects
                        inkingCannonHit(LIVING_HIT_ENTITY);
                    }
                }
            } else if (hasGlassCannon(PLAYER_UUID)) {

                // check for projectile
                if (ENTITY instanceof DragonFireball) {

                    // check if living entity was hit
                    final Entity HIT_ENTITY = EVENT.getHitEntity();
                    if (HIT_ENTITY instanceof LivingEntity) {

                        // cast entity to livingentity
                        final LivingEntity LIVING_HIT_ENTITY = (LivingEntity) HIT_ENTITY;

                        // inflict effects
                        glassCannonImpact(LIVING_HIT_ENTITY);
                    }
                }
            }
        }
    }
}
