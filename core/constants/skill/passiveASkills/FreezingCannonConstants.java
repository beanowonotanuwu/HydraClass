package hydra.hunter.core.constants.skill.passiveASkills;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Egg;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public interface FreezingCannonConstants {

    double EXTRA_KNOCKBACK = -2.7;

    Class PROJECTILE = Egg.class;

    short DURATION = 8;
    short LEVEL = 3;

    Sound FREEZING_CANNON_LAUNCH_SOUND = Sound.ENTITY_POLAR_BEAR_AMBIENT_BABY;

    byte FREEZING_CANNON_LAUNCH_PITCH = 8;

    byte FREEZING_CANNON_LAUNCH_VOLUME = 10;

    Particle ON_IMPACT_PARTICLE_FREEZING_CANNON = Particle.SNOWBALL;

    byte PARTICLE_COUNT_FREEZING_CANNON = 5;


    // COOLDOWN shet

    String SKILL_NAME = "Freezing Cannon";

    byte COOLDOWN_DURATION = 12;

    String COOLDOWN_MESSAGE_P1 = SKILL_NAME + " will be ready in ";
    String COOLDOWN_MESSAGE_P2 = " second(s)";


    Map<UUID, Long> cooldowns = new HashMap<>();
}
