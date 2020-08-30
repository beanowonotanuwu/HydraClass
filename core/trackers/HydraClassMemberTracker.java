package hydra.hunter.core.trackers;

import java.util.ArrayList;
import java.util.UUID;

public interface HydraClassMemberTracker {

    ArrayList<UUID> hydrasClassMembers = new ArrayList<>();

    default boolean isHydra(final UUID PLAYER_UUID) {

        if (hydrasClassMembers.contains(PLAYER_UUID)) {
            return true;
        }
        return false;
    }
}
