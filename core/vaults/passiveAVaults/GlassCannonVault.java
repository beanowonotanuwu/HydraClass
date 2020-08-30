package hydra.hunter.core.vaults.passiveAVaults;

import hydra.hunter.core.constants.skill.passiveASkills.GlassCannonConstants;
import hydra.hunter.core.factories.PotionFactory;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.UUID;


public interface GlassCannonVault extends
        GlassCannonConstants,
        PotionFactory {

    default void glassCannonFire(final Player PLAYER) {
        PLAYER.launchProjectile(PROJECTILE);
    }

    default void teleportPlayer(final Player PLAYER) {

        final Location PLAYER_LOCATION = PLAYER.getLocation();
        final World WRLD = PLAYER_LOCATION.getWorld();
        final UUID PLAYER_UUID = PLAYER.getUniqueId();

        final float YAW = PLAYER_LOCATION.getYaw();
        final float PITCH = PLAYER_LOCATION.getPitch();

        final double X = PLAYER_LOCATION.getX();
        final double Y = PLAYER_LOCATION.getY() + BLOCKS_UP;
        final double Z = PLAYER_LOCATION.getZ();

        final Location NEW_LOCATION = new Location(WRLD, X, Y, Z, YAW, PITCH);

        PLAYER.teleport(NEW_LOCATION);

        hydrasUsingGlassCannonAndFlying.add(PLAYER_UUID);
        PLAYER.setGravity(false);
    }

    default void glassCannonImpact(final LivingEntity TARGET) {

        final double TARGET_BEFORE_HEALTH = TARGET.getHealth();
        final double TARGET_NEW_HEALTH =
                TARGET_BEFORE_HEALTH
                        + IMPACT_DAMAGE;

        TARGET.setHealth(TARGET_NEW_HEALTH);
    }

    default void inflictGlassCannonNegativeEffect(final Player PLAYER) {
        inflictWither(PLAYER, WITHER_DURATION, WITHER_LEVEL);
    }
}
