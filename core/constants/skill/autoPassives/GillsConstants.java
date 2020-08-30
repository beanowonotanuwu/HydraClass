package hydra.hunter.core.constants.skill.autoPassives;

import org.bukkit.Material;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public interface GillsConstants {

    PotionEffectType WATER_BREATHING_TYPE = PotionEffectType.WATER_BREATHING;

    byte WATER_BREATHING_DURATION = 100;
    byte WATER_BREATHING_AMPLIFIER = 3;

    PotionEffect WATER_BREATHING = new PotionEffect(WATER_BREATHING_TYPE, WATER_BREATHING_DURATION, WATER_BREATHING_AMPLIFIER);

    Material WATER_MATERIAL_TYPE = Material.WATER;
}
