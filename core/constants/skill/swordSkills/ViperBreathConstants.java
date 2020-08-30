package hydra.hunter.core.constants.skill.swordSkills;

import hydra.hunter.core.colors.util.SkillColors;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.block.Action;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public interface ViperBreathConstants extends
        SkillColors {

    Map<UUID, Long> cooldowns = new HashMap<UUID, Long>();

    String SKILL_NAME = "Viper Breath";

    double DAMAGE_USING_UNDERWATER = 2;

    byte COOLDOWN_DURATION = 6;

    Material WATER = Material.WATER;
    Material LAVA = Material.LAVA;

    Action VIPER_BREATH_ACTIVATION_1 = Action.RIGHT_CLICK_AIR;
    Action VIPER_BREATH_ACTIVATION_2 = Action.RIGHT_CLICK_BLOCK;

    String COOLDOWN_MESSAGE_P1 = SKILL_NAME + " will be ready in ";
    String COOLDOWN_MESSAGE_P2 = " second(s)";


    // particles



    // sounds
    Sound ON_SHOOTING_SOUND = Sound.ENTITY_CREEPER_PRIMED;

    byte VOLUME = 5;

    byte PITCH = 6;
}

