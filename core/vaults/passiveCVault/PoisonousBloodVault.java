package hydra.hunter.core.vaults.passiveCVault;

import hydra.hunter.core.constants.skill.passiveCSkills.PoisonousBloodConstants;
import hydra.hunter.core.factories.PotionEffectTypes;
import hydra.hunter.core.factories.PotionFactory;
import org.bukkit.entity.Player;

public interface PoisonousBloodVault extends
        PotionFactory,
        PotionEffectTypes,
        PoisonousBloodConstants {

    default void onDeath(final Player KILLER) {

        inflictEffect(KILLER, ON_DEATH_EFFECT, ON_DEATH_EFFECT_DURATION, ON_DEATH_EFFECT_LEVEL);
    }
}
