package hydra.hunter.core.factories;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public interface PotionFactory extends
        PotionEffectTypes {

    default short correctLevel(short level) {
        return (short) ((short) level - 1);
    }
    default short correctDuration(short duration) {
        return (short) ((short) duration * 20);
    }


    default void inflictEffect(final LivingEntity TARGET, final PotionEffectType EFFECT_TYPE, short duration, short level) {

        // corrections
        final short LEVEL = correctLevel(level);
        final short DURATION = correctDuration(duration);

        // create effect
        final PotionEffect EFFECT = new PotionEffect(EFFECT_TYPE, DURATION, LEVEL);

        // inflict effect
        TARGET.addPotionEffect(EFFECT);
    }


    default void inflictWither(final LivingEntity TARGET, short duration, short level) {

        inflictEffect(TARGET, WITHER_TYPE, duration, level);

    }

    default void inflictPoison(final LivingEntity TARGET, short duration, short level) {

        inflictEffect(TARGET, POISON_TYPE, duration, level);
    }

    default void inflictDolphinsGrace(final LivingEntity TARGET, short duration, short level) {

        inflictEffect(TARGET, DOLPHINS_GRACE_TYPE, duration, level);
    }

    default void inflictRegeneration(final LivingEntity TARGET, short duration, short level) {

        inflictEffect(TARGET, REGENERATION_TYPE, duration, level);
    }
}
