package hydra.hunter.core.constants.skill.passiveASkills;

import hydra.hunter.core.factories.PotionEffectTypes;
import org.bukkit.Particle;
import org.bukkit.entity.Egg;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public interface InkingCannonConstants {

    Class PROJECTILE = Egg.class;

    double PROJECTILE_VELOCITY = -1.3;

    double IMPACT_KNOCKBACK = -2.4581;

    Particle INKING_CANNON_IMPACT_PARTICLE = Particle.SQUID_INK;

    byte INKING_CANNON_IMPACT_PARTICLE_COUNT = 10;


    PotionEffectType BLINDNESS = PotionEffectTypes.BLINDNESS_TYPE;

    short BLINDNESS_DURATION = 5;

    short BLINDNESS_LEVEL = 1;

    // COOLDOWN shet

    String SKILL_NAME = "Inking Cannon";

    byte COOLDOWN_DURATION = 11;

    String COOLDOWN_MESSAGE_P1 = SKILL_NAME + " will be ready in ";
    String COOLDOWN_MESSAGE_P2 = " second(s)";


    Map<UUID, Long> cooldowns = new HashMap<>();
}
