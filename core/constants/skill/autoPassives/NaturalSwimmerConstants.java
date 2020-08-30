package hydra.hunter.core.constants.skill.autoPassives;

import hydra.hunter.core.constants.util.UtilConstants;
import net.md_5.bungee.api.ChatColor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public interface NaturalSwimmerConstants extends
        UtilConstants {

    long INSTANT = 0L;


    String SKILL_NAME = "Natural Swimmer";

    float ADDITIONAL_BOOST = .97F;

    // charges stuff
    int BASE_CHARGES = 3;

    int NOT_ENOUGH_CHARGES = 0;

    int BASE_CHARGE_DECREMENT = 0;

    int INCREMENT = 1;
    int DECREMENT = 1;

    String NOT_ENOUGH_CHARGES_MESSAGE = "You have no charges";

    long TIME_FOR_CHARGE_REGENERATION = 60L;

    String MESSAGE_PART_1 = ChatColor.DARK_PURPLE + "Natural Swimmer Charges: ";

    // cooldowns stuff
    Map<UUID, Long> cooldowns = new HashMap<UUID, Long>();



    byte COOLDOWN_DURATION = 3;

    String COOLDOWN_MESSAGE_P1 = SKILL_NAME + " will be ready in ";
    String COOLDOWN_MESSAGE_P2 = " second(s)";
}
