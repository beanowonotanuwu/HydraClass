package hydra.hunter.core.vaults.passiveBVault;

import hydra.hunter.core.constants.skill.passiveBSkills.ScaleManipulationConstants;

public interface ScaleManipulationVault extends
        ScaleManipulationConstants {

    default double reduceProjectileDamage(final double DAMAGE) {

        final double NEW_DAMAGE = DAMAGE - REDUCE_PROJECTILE_DAMAGE;

        if (NEW_DAMAGE <= 0) {
            return 0;
        }
        return NEW_DAMAGE;
    }

    default double reduceMeleeDamage(final double DAMAGE) {

        final double NEW_DAMAGE = DAMAGE - REDUCE_MELEE_DAMAGE;

        if (NEW_DAMAGE <= 0) {
            return 0;
        }
        return NEW_DAMAGE;
    }
}
