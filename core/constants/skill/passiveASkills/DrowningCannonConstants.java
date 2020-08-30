package hydra.hunter.core.constants.skill.passiveASkills;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Egg;

import java.util.*;

public interface DrowningCannonConstants {

    // sounds
    short volume = 10;


    short pitch = 3;


    Sound ON_THROW = Sound.BLOCK_GRAVEL_BREAK;
    Sound ON_IMPACT = Sound.ENTITY_LIGHTNING_BOLT_IMPACT;


    Class PROJECTILE = Egg.class;

    List<Block> blocks = new ArrayList<>();

    List<Material> previousBlocks = new ArrayList<>();
    List<Location> previousLocations = new ArrayList<>();

    List<Integer> xList = new ArrayList<>();
    List<Integer> yList = new ArrayList<>();
    List<Integer> zList = new ArrayList<>();

    int radius = 3;
    int blocksDown = 30;


    // cooldown sssshit

    Map<UUID, Long> cooldowns = new HashMap<>();


    String SKILL_NAME = "Drowning Cannon";

    byte COOLDOWN_DURATION = 18;

    String COOLDOWN_MESSAGE_P1 = SKILL_NAME + " will be ready in ";
    String COOLDOWN_MESSAGE_P2 = " second(s)";
}
