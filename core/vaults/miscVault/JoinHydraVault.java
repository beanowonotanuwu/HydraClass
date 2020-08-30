package hydra.hunter.core.vaults.miscVault;

import hydra.hunter.core.trackers.HydraClassMemberTracker;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface JoinHydraVault {
    default boolean isHydra(final Player PLAYER) {

        // calculations
        final UUID PLAYER_UUID = PLAYER.getUniqueId();

        // core if statement
        if (HydraClassMemberTracker.hydrasClassMembers.contains(PLAYER_UUID)) {

            // return true
            return true;
        }

        // if all else return false
        return false;
    }
}
