package hydra.hunter.core.vaults.autoPassivesVault;

import hydra.hunter.core.constants.skill.autoPassives.GillsConstants;
import org.bukkit.entity.Player;

public interface GillsVault extends
        GillsConstants {

    default void grantWaterBreathing(final Player PLAYER) {

        // effect
        PLAYER.addPotionEffect(WATER_BREATHING);
    }

}
