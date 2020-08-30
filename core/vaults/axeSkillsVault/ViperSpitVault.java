package hydra.hunter.core.vaults.axeSkillsVault;

import hydra.hunter.core.constants.skill.axeSkills.ViperSpitConstants;
import hydra.hunter.core.constants.util.UtilConstants;
import hydra.hunter.core.factories.PotionFactory;
import hydra.hunter.core.vaults.miscVault.UtilVault;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public interface ViperSpitVault extends
        ViperSpitConstants,
        UtilConstants,
        UtilVault, PotionFactory {

    default ArrayList<Block> nearbyBlocks(final Block BLOCK) {

        // create arraylist
        ArrayList<Block> nearbyBlocks = new ArrayList<>();

        // calculations
        final int X = BLOCK.getX();
        final int Y = BLOCK.getY();
        final int Z = BLOCK.getZ();

        // change blocks in a certain radius
        final World WORLD = BLOCK.getWorld();

        for (int ct = 0; ct <= RADIUS; ct++) {
            final int CONSTANT_X = X;
            final int CONSTANT_Y = Y;
            final int CONSTANT_Z = Z;

            final int NEGATIVE_X = X - ct;
            final int NEGATIVE_Z = Z - ct;

            final int POSITIVE_X = X + ct;
            final int POSITIVE_Z = Z + ct;

            // negative x, negative z
            final Block BLOCK_NX_NZ = WORLD.getBlockAt(
                    NEGATIVE_X, CONSTANT_Y, NEGATIVE_Z
            );

            nearbyBlocks.add(BLOCK_NX_NZ);

            // negative x, positive z
            final Block BLOCK_NX_PZ = WORLD.getBlockAt(
                    NEGATIVE_X, CONSTANT_Y, POSITIVE_Z
            );

            nearbyBlocks.add(BLOCK_NX_PZ);

            // positive x, positive z
            final Block BLOCK_PX_PZ = WORLD.getBlockAt(
                    POSITIVE_X, CONSTANT_Y, POSITIVE_Z
            );

            nearbyBlocks.add(BLOCK_PX_PZ);

            // positive x, negative z
            final Block BLOCK_PX_NZ = WORLD.getBlockAt(
                    POSITIVE_X, CONSTANT_Y, NEGATIVE_Z
            );

            nearbyBlocks.add(BLOCK_PX_NZ);

            // negative x constant z
            final Block BLOCK_NX_CZ = WORLD.getBlockAt(
                    NEGATIVE_X, CONSTANT_Y, CONSTANT_Z
            );
            nearbyBlocks.add(BLOCK_NX_CZ);

            // positive x constant z
            final Block BLOCK_PX_CZ = WORLD.getBlockAt(
                    POSITIVE_X, CONSTANT_Y, CONSTANT_Z
            );
            nearbyBlocks.add(BLOCK_PX_CZ);

            // constant x positive z
            final Block BLOCK_CX_PZ = WORLD.getBlockAt(
                    CONSTANT_X, CONSTANT_Y, POSITIVE_Z
            );
            nearbyBlocks.add(BLOCK_CX_PZ);

            // constant x negative z
            final Block BLOCK_CX_NZ = WORLD.getBlockAt(
                    CONSTANT_X, CONSTANT_Y, NEGATIVE_Z
            );
            nearbyBlocks.add(BLOCK_CX_NZ);
        }

        return nearbyBlocks;
    }

    default void setBlocks(final Block HIT_BLOCK) {

        ArrayList<Block> DESIGNATED_BLOCKS = nearbyBlocks(HIT_BLOCK);

        // iterate over designated blocks
        for (Block i : DESIGNATED_BLOCKS) {

            // block material and location
            final Material BLOCK_TYPE = i.getType();
            final Location BLOCK_LOCATION = i.getLocation();

            // add to lists
            BLOCKS_TURNED_TO_WATER.add(BLOCK_TYPE);
            BLOCKS_TURNED_TO_WATER_LOCATIONS.add(BLOCK_LOCATION);

            // set the type
            i.setType(CHANGING_TO_MATERIAL);
        }
        final Material TYPE = HIT_BLOCK.getType();
        final Location BLOCK_LOCATION = HIT_BLOCK.getLocation();
        BLOCKS_TURNED_TO_WATER.add(TYPE);
        BLOCKS_TURNED_TO_WATER_LOCATIONS.add(BLOCK_LOCATION);
    }


    default void bringBlocksBack(final Block HIT_BLOCK) {

        // iterate over blocks
        for (int ct = 0; ct <= BLOCKS_TURNED_TO_WATER.size() - 1; ct++) {
            final Material TYPE = BLOCKS_TURNED_TO_WATER.get(ct);
            final Location LOCATION = BLOCKS_TURNED_TO_WATER_LOCATIONS.get(ct);
            final Block BLOCK = LOCATION.getBlock();

            BLOCK.setType(TYPE);

        }
    }


    default void viperSpitProjectileLaunch(final Player LAUNCH_FROM) {
        LAUNCH_FROM.launchProjectile(PROJECTILE_TYPE);
    }

    default void viperSpitProjectileImpact(final Block HIT_BLOCK) {
        setBlocks(HIT_BLOCK);
    }

    default void viperSpitProjectileImpactLivingEntity(final LivingEntity ENTITY) {

        // inflict poison
        inflictPoison(ENTITY, DURATION, LEVEL);
    }

    default void walkingOnSpecifiedBlock(final LivingEntity TARGET) {

        // inflict poison
        inflictPoison(TARGET, DURATION, LEVEL);
    }
}
