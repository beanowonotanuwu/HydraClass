package hydra.hunter.core.vaults.passiveAVaults;

import hydra.hunter.core.constants.skill.passiveASkills.DrowningCannonConstants;
import hydra.hunter.core.vaults.miscVault.UtilVault;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public interface DrowningCannonVault extends
        DrowningCannonConstants,
        UtilVault {

    default void bringBlocksBack() {

        // iterate over blocks
        for (int ct = 0; ct <= previousBlocks.size() - 1; ct++) {
            final Material TYPE = previousBlocks.get(ct);
            final Location LOCATION = previousLocations.get(ct);
            final Block BLOCK = LOCATION.getBlock();

            BLOCK.setType(TYPE);

        }

        // clear lists

        previousBlocks.clear();
        previousLocations.clear();
    }

    default void burrowBlocks(final Block DESIGNATED_BLOCK) {

        final Location BLOCK_LOCATION = DESIGNATED_BLOCK.getLocation();

        for (int x = BLOCK_LOCATION.getBlockX() - radius; x <= BLOCK_LOCATION.getBlockX(); x++) {
            xList.add(x);
        }

        for (int y = BLOCK_LOCATION.getBlockY() - blocksDown; y <= BLOCK_LOCATION.getBlockY(); y++) {
            yList.add(y);
        }

        for (int z = BLOCK_LOCATION.getBlockZ() - radius; z <= BLOCK_LOCATION.getBlockZ(); z++) {
            zList.add(z);
        }

        for (int x : xList) {
            for (int y : yList) {
                for (int z : zList) {
                    blocks.add(BLOCK_LOCATION.getWorld().getBlockAt(x, y, z));
                }
            }
        }

        for (Block i : blocks) {

            previousBlocks.add(i.getType());
            previousLocations.add(i.getLocation());

            i.setType(Material.WATER);
        }

        // clear lists
        xList.clear();
        yList.clear();
        zList.clear();
    }



    default void drowningCannonFire(final Player PLAYER) {
        PLAYER.launchProjectile(PROJECTILE);
    }
}
