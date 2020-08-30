package hydra.hunter.core.vaults.passiveAVaults;

import hydra.hunter.core.constants.skill.passiveASkills.InkingCannonConstants;
import hydra.hunter.core.factories.PotionEffectTypes;
import hydra.hunter.core.factories.PotionFactory;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public interface InkingCannonVault extends
        InkingCannonConstants,
        PotionFactory,
        PotionEffectTypes {

    default void inkingCannonFire(final Player PLAYER) {

        final Location PLAYER_LOCATION = PLAYER.getLocation();
        Vector playerLocationDirection = PLAYER_LOCATION.getDirection();
        final Vector REVERSED_DIRECTION = playerLocationDirection.multiply(PROJECTILE_VELOCITY);

        PLAYER.launchProjectile(PROJECTILE, REVERSED_DIRECTION);
    }

    default void inkingCannonHit(final LivingEntity ENTITY) {

        final Location ENTITY_LOCATION = ENTITY.getLocation();
        final World WRLD = ENTITY_LOCATION.getWorld();
        WRLD.spawnParticle(INKING_CANNON_IMPACT_PARTICLE, ENTITY_LOCATION, INKING_CANNON_IMPACT_PARTICLE_COUNT);

        // inflict effects
        inflictEffect(ENTITY, BLINDNESS, BLINDNESS_DURATION, BLINDNESS_LEVEL);

        // knockback
        final Vector ENTITY_DIRECTION = ENTITY_LOCATION.getDirection();

        final Vector KNOCKBACK = ENTITY_DIRECTION.multiply(IMPACT_KNOCKBACK);

        ENTITY.setVelocity(KNOCKBACK);
    }
}
