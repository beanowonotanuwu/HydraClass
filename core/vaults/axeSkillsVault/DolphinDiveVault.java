package hydra.hunter.core.vaults.axeSkillsVault;

import hydra.hunter.core.constants.skill.axeSkills.DolphinDiveConstants;
import hydra.hunter.core.factories.PotionFactory;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public interface DolphinDiveVault extends
        DolphinDiveConstants,
        PotionFactory {

    default void playSoundDolphinDiveV1(final Player PLAYER) {

        final Location PLAYER_LOCATION = PLAYER.getLocation();

        PLAYER.playSound(
                PLAYER_LOCATION,
                DOLPHIN_DIVE_V1_SOUND, DOLPHIN_DIVE_V1_VOLUME, DOLPHIN_DIVE_V1_PITCH
        );
    }

    default void spawnParticleDolphinDiveV1(final Player PLAYER) {

        final Location PLAYER_LOCATION = PLAYER.getLocation();

        PLAYER.spawnParticle(DOLPHIN_DIVE_V1_PARTICLE, PLAYER_LOCATION, DOLPHIN_DIVE_V1_COUNT);
    }

    default void dolphinDiveV1Activation(final Player PLAYER) {

        final Location PLAYER_LOCATION = PLAYER.getLocation();
        Vector playerDirection = PLAYER_LOCATION.getDirection();

        // multiply
        playerDirection.multiply(ADDITIONAL_BOOST);

        // set the velocity
        PLAYER.setVelocity(playerDirection);

        // play sound
        playSoundDolphinDiveV1(PLAYER);

        // spawn particle
        spawnParticleDolphinDiveV1(PLAYER);
    }

    default void dolphinDiveV2Activation(final Player PLAYER) {
        inflictDolphinsGrace(PLAYER, DOLPHINS_GRACE_DURATION, DOLPHINS_GRACE_LEVEL);
        inflictRegeneration(PLAYER, REGENERATION_DURATION, REGENERATION_LEVEL);
    }
}
