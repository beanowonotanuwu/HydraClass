package hydra.hunter.core.vaults.passiveAVaults;

import hydra.hunter.core.constants.skill.passiveASkills.FreezingCannonConstants;
import hydra.hunter.core.factories.PotionEffectTypes;
import hydra.hunter.core.factories.PotionFactory;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public interface FreezingCannonVault extends
        FreezingCannonConstants,
        PotionFactory,
        PotionEffectTypes {

    default void freezingCannonLaunch(final Player PLAYER) {
        PLAYER.launchProjectile(PROJECTILE);
    }

    default void freezingCannonHit(final LivingEntity TARGET) {

        inflictEffect(TARGET, SLOWNESS_TYPE, DURATION, LEVEL);
    }

    default void freezingCannonHitKnockback(final LivingEntity ENTITY) {

        ENTITY.setVelocity(
                ENTITY.getLocation().getDirection().multiply(EXTRA_KNOCKBACK)
        );
    }
}
