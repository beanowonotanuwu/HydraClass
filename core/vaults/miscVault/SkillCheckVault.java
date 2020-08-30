package hydra.hunter.core.vaults.miscVault;

import hydra.hunter.core.colors.util.SkillCheckColors;
import hydra.hunter.core.constants.util.UtilConstants;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public interface SkillCheckVault extends
        SkillCheckColors,
        UtilConstants {

    String WATER_ERROR_MESSAGE =
            WATER_ERROR_MESSAGE_COLOR
                    +  "Cannot use this skill in water";
    String LAVA_ERROR_MESSAGE =
            LAVA_ERROR_MESSAGE_COLOR
                    +  "It's too hot to use this skill";

    default boolean inWater(final Player PLAYER) {

        final Location PLAYER_LOCATION = PLAYER.getLocation();
        final Block PLAYER_BLOCK_STANDING = PLAYER_LOCATION.getBlock();
        final Material BLOCK_TYPE = PLAYER_BLOCK_STANDING.getType();

        if (BLOCK_TYPE.equals(WATER)) {
            return true;
        }
        return false;
    }

    default boolean inLava(final Player PLAYER) {

        final Location PLAYER_LOCATION = PLAYER.getLocation();
        final Block PLAYER_BLOCK_STANDING = PLAYER_LOCATION.getBlock();
        final Material BLOCK_TYPE = PLAYER_BLOCK_STANDING.getType();

        if (BLOCK_TYPE.equals(LAVA)) {
            return true;
        }
        return false;
    }
}
