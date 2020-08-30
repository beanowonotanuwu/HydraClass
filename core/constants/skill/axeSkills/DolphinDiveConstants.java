package hydra.hunter.core.constants.skill.axeSkills;

import hydra.hunter.core.colors.util.SkillColors;
import org.bukkit.Particle;
import org.bukkit.Sound;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public interface DolphinDiveConstants extends
        SkillColors {

    // V2 CONSTANTS
    short DOLPHINS_GRACE_DURATION = 3;
    short DOLPHINS_GRACE_LEVEL = 1;

    short REGENERATION_DURATION = 4;
    short REGENERATION_LEVEL = 2;


    float ADDITIONAL_BOOST = 2.51F;

    String SKILL_NAME = "Dolphin Dive";

    // cooldowns stuff
    Map<UUID, Long> cooldowns = new HashMap<UUID, Long>();

    byte COOLDOWN_DURATION = 8;

    String COOLDOWN_MESSAGE_P1 = SKILL_NAME + " will be ready in ";
    String COOLDOWN_MESSAGE_P2 = " second(s)";

    boolean CANCEL_EVENT_ON_COOLDOWN = true;


    // sounds
    Sound DOLPHIN_DIVE_V1_SOUND = Sound.ENTITY_DOLPHIN_SWIM;

    byte DOLPHIN_DIVE_V1_VOLUME = 10;

    byte DOLPHIN_DIVE_V1_PITCH = 7;


    // particles
    Particle DOLPHIN_DIVE_V1_PARTICLE = Particle.WATER_BUBBLE;

    byte DOLPHIN_DIVE_V1_COUNT = 5;
}
