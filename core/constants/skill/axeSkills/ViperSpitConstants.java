package hydra.hunter.core.constants.skill.axeSkills;

import hydra.hunter.core.colors.util.SkillColors;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Snowball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public interface ViperSpitConstants extends
        SkillColors {
    Class PROJECTILE_TYPE = Snowball.class;

    byte RADIUS = 7;

    Material CHANGING_TO_MATERIAL = Material.WATER;

    byte DURATION = 3;
    byte LEVEL = 3;



    // cooldown shit

    Map<UUID, Long> cooldowns = new HashMap<UUID, Long>();

    String SKILL_NAME = "Viper Spit";

    byte COOLDOWN_DURATION = 12;

    String COOLDOWN_MESSAGE_P1 = SKILL_NAME + " will be ready in ";
    String COOLDOWN_MESSAGE_P2 = " second(s)";

    ArrayList<Material> BLOCKS_TURNED_TO_WATER = new ArrayList<>();
    ArrayList<Location> BLOCKS_TURNED_TO_WATER_LOCATIONS = new ArrayList<>();
}
