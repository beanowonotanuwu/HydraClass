package hydra.hunter.core.vaults.swordSkillsVault;

import hydra.hunter.core.constants.skill.swordSkills.JellyfishStingConstants;
import hydra.hunter.core.factories.PotionFactory;
import hydra.hunter.core.vaults.miscVault.UtilVault;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public interface JellyfishStingVault extends
        JellyfishStingConstants,
        PotionFactory, UtilVault {

    default void playSoundJellyfishStingWater(final Player PLAYER) {

        final Location PLAYER_LOCATION = PLAYER.getLocation();
        PLAYER.playSound(PLAYER_LOCATION, IN_WATER_SOUND, IN_WATER_VOLUME, IN_WATER_PITCH);
    }

    default void playSoundJellyfishStingLand(final Player PLAYER) {

        final Location PLAYER_LOCATION = PLAYER.getLocation();
        PLAYER.playSound(PLAYER_LOCATION, ON_LAND_SOUND, ON_LAND_VOLUME, ON_LAND_PITCH);
    }


    default void jellyfishStingAttackWater(final LivingEntity TARGET) {

        // add effects to entity
        inflictPoison(TARGET, POISON_DURATION, POISON_LEVEL);

        // modify health
        modifyHealth(TARGET, INITIAL_DAMAGE_IN_WATER);


        // play sound
        if (TARGET instanceof Player) {
            final Player PLAYER = (Player) TARGET;

            playSoundJellyfishStingWater(PLAYER);
        }
    }

    default void jellyfishStingAttackLand(final LivingEntity TARGET) {

        // add effects to entity
        inflictWither(TARGET, WITHER_DURATION, WITHER_LEVEL);

        // modify health
        modifyHealth(TARGET, INITIAL_DAMAGE_ON_LAND);


        // play sound
        if (TARGET instanceof Player) {
            final Player PLAYER = (Player) TARGET;

            playSoundJellyfishStingLand(PLAYER);
        }
    }
}
