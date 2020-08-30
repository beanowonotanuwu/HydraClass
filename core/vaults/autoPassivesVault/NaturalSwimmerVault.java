package hydra.hunter.core.vaults.autoPassivesVault;

import hydra.hunter.core.constants.skill.autoPassives.NaturalSwimmerConstants;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public interface NaturalSwimmerVault extends NaturalSwimmerConstants {

    default void swimmingBoost(final Player PLAYER) {

        // calculations
        final Location PLAYER_LOCATION = PLAYER.getLocation();
        Vector playerDirection = PLAYER_LOCATION.getDirection();

        // multiply the direction
        final Vector PLAYER_DIRECTION = playerDirection.multiply(ADDITIONAL_BOOST);

        // set the velocity
        PLAYER.setVelocity(PLAYER_DIRECTION);
    }
}
