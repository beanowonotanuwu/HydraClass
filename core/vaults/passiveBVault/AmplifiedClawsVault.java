package hydra.hunter.core.vaults.passiveBVault;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public interface AmplifiedClawsVault {

    default void amplifiedClawAttack(final Player PLAYER, final LivingEntity ATTACKED_ENTITY) {

        final double HEALTH = PLAYER.getHealth();
        final double NEW_HEALTH = HEALTH / 2;

        final double ATTACKED_ENTITY_HEALTH = ATTACKED_ENTITY.getHealth();
        final double NEW_ATTACKED_ENTITY_HEALTH = ATTACKED_ENTITY_HEALTH - NEW_HEALTH;

        ATTACKED_ENTITY.setHealth(NEW_ATTACKED_ENTITY_HEALTH);
    }
}
