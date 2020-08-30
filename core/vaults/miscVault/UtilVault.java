package hydra.hunter.core.vaults.miscVault;

import hydra.hunter.core.constants.util.UtilConstants;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public interface UtilVault extends
        UtilConstants, SkillCheckVault {

    default void modifyHealth(final LivingEntity TARGET, final double MODIFIER) {

        // get the health
        final double HEALTH = TARGET.getHealth();

        // calculate new health
        final double NEW_HEALTH = HEALTH - MODIFIER;

        // check if health <= 0
        if (NEW_HEALTH <= DEAD) {

           TARGET.setHealth(DEAD);
           return;
        }

        // set the health
        TARGET.setHealth(NEW_HEALTH);
    }


    default void dMSG(final String MSG) {
        System.out.println(MSG);
    }


    default void whileInLava(final Player PLAYER) {

        final Location PLAYER_LOCATION = PLAYER.getLocation();

        PLAYER.sendMessage(LAVA_ERROR_MESSAGE);
        PLAYER.spawnParticle(LAVA_ERROR_USAGE, PLAYER_LOCATION, LAVA_ERROR_COUNT);
    }


    default List<Block> getRadius(final Location LOCATION, final int RADIUS) {
        List<Block> blocks = new ArrayList<>();

        int y = LOCATION.getBlockY();

        for (int x = LOCATION.getBlockX() - RADIUS; x <= LOCATION.getBlockX(); x++) {
            for (int z = LOCATION.getBlockZ() - RADIUS; z <= LOCATION.getBlockZ(); z++) {
                blocks.add(LOCATION.getWorld().getBlockAt(x, y, z));
            }
        }

        return blocks;
    }



    default void changeBlockTypes(final List<Block> BLOCKS, final Material NEW_TYPE) {

        for (Block i : BLOCKS) {
            i.setType(NEW_TYPE);
        }
    }
}
