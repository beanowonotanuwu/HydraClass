package hydra.hunter.core.constants.skill.passiveASkills;

import org.bukkit.entity.DragonFireball;

import java.util.*;

public interface GlassCannonConstants {

    long FLYING_DURATION = 140L;

    long DELAY_BETWEEN_FIRING = 20L;

    long INITIAL_DELAY = 10L;


    short WITHER_DURATION = (short) FLYING_DURATION / 10;

    short WITHER_LEVEL = 5;


    double IMPACT_DAMAGE = 4;

    double BLOCKS_UP = 10;

    List<UUID> hydrasUsingGlassCannonAndFlying = new ArrayList<>();

    Class PROJECTILE = DragonFireball.class;
    // COOLDOWN shet

    String SKILL_NAME = "Glass Cannon";

    byte COOLDOWN_DURATION = 26;
    byte FIREBALL_COOLDOWN_DURATION = 1;

    String COOLDOWN_MESSAGE_P1 = SKILL_NAME + " will be ready in ";
    String COOLDOWN_MESSAGE_P2 = " second(s)";


    Map<UUID, Long> cooldowns = new HashMap<>();
    Map<UUID, Long> fireballCooldowns = new HashMap<>();
}
