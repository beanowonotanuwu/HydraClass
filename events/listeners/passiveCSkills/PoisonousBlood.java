package hydra.hunter.events.listeners.passiveCSkills;

import hydra.hunter.core.implementations.passiveCSkills.PoisonousBloodImplementations;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.UUID;

public class PoisonousBlood implements
        PoisonousBloodImplementations {

    @EventHandler
    public void onPoisonousBloodActivation(final PlayerDeathEvent EVENT) {

        // calcs
        final Player PLAYER = EVENT.getEntity();
        final Player KILLER = PLAYER.getKiller();

        final UUID PLAYER_UUID = PLAYER.getUniqueId();

        // check if player has skill
        if (hasPoisonousBlood(PLAYER_UUID)) {

            // inflict effect on killer
            onDeath(KILLER);
        }
    }
}
