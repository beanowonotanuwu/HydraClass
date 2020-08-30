package hydra.hunter.core.constants.util.projectile;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public interface SwordSkillsProjectileHandlerConstants {

    double VIPER_BREATH_IMPACT_DAMAGE = 3.5;

    PotionEffectType VIPER_BREATH_IMPACT_EFFECT_TYPE = PotionEffectType.POISON;

    byte VIPER_BREATH_IMPACT_DURATION = 60;
    byte VIPER_BREATH_IMPACT_AMPLIFIER = 1;

    PotionEffect VIPER_BREATH_IMPACT_EFFECT = new PotionEffect(
            VIPER_BREATH_IMPACT_EFFECT_TYPE, VIPER_BREATH_IMPACT_DURATION, VIPER_BREATH_IMPACT_AMPLIFIER
    );
}
