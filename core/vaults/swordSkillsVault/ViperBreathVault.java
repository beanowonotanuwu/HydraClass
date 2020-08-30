package hydra.hunter.core.vaults.swordSkillsVault;

import hydra.hunter.core.constants.skill.swordSkills.ViperBreathConstants;
import org.bukkit.Location;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

public interface ViperBreathVault extends
        ViperBreathConstants {

    default void viperBreathShoot(final Player PLAYER) {

        // calculations
        PLAYER.launchProjectile(Fireball.class);

        // particles


        // sounds
        final Location PLAYER_LOCATION = PLAYER.getLocation();

        // NOTE FOR LATER PLAY SOUND A FEW MORE TIMES
        PLAYER.playSound(PLAYER_LOCATION, ON_SHOOTING_SOUND, VOLUME, PITCH);

    }
}
