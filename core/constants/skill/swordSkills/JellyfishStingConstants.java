package hydra.hunter.core.constants.skill.swordSkills;

import hydra.hunter.core.colors.util.SkillColors;
import org.bukkit.Sound;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public interface JellyfishStingConstants extends
        SkillColors {

    String SKILL_NAME = "Jellyfish Sting";

    // cooldowns stuff
    Map<UUID, Long> cooldowns = new HashMap<UUID, Long>();

    byte COOLDOWN_DURATION = 7;

    String COOLDOWN_MESSAGE_P1 = SKILL_NAME + " will be ready in ";
    String COOLDOWN_MESSAGE_P2 = " second(s)";

    boolean CANCEL_EVENT_ON_COOLDOWN = true;

    // effects
    short LAND_TO_WATER_MODIFIER = 1;

    // DURATION IS IN SECONDS
    short WITHER_DURATION = 2;
    short POISON_DURATION = WITHER_DURATION + LAND_TO_WATER_MODIFIER;


    // LEVEL WILL BE CORRECTED
    short WITHER_LEVEL = 1;
    short POISON_LEVEL = WITHER_LEVEL + LAND_TO_WATER_MODIFIER;



    // INITIAL DAMAGE
    double INITIAL_DAMAGE_ON_LAND = 1.5;
    double INITIAL_DAMAGE_IN_WATER = INITIAL_DAMAGE_ON_LAND + LAND_TO_WATER_MODIFIER;



    // sounds
    Sound IN_WATER_SOUND = Sound.ENTITY_BEE_STING;
    Sound ON_LAND_SOUND = Sound.ENTITY_PUFFER_FISH_STING;

    byte ON_LAND_VOLUME = 4;
    byte IN_WATER_VOLUME = ON_LAND_VOLUME + LAND_TO_WATER_MODIFIER;

    byte ON_LAND_PITCH = 4;
    byte IN_WATER_PITCH = ON_LAND_PITCH + LAND_TO_WATER_MODIFIER;
}
