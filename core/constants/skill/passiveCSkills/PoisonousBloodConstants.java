package hydra.hunter.core.constants.skill.passiveCSkills;

import hydra.hunter.core.factories.PotionEffectTypes;
import org.bukkit.potion.PotionEffectType;

public interface PoisonousBloodConstants extends
        PotionEffectTypes {

    short ON_DEATH_EFFECT_DURATION = 7;
    short ON_DEATH_EFFECT_LEVEL = 1;
    PotionEffectType ON_DEATH_EFFECT = PotionEffectTypes.POISON_TYPE;
}
