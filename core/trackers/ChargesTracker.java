package hydra.hunter.core.trackers;

import java.util.*;

public interface ChargesTracker {

    // keeps track of (online) players (currently) regenerating their charges
    List<UUID> hydrasRegeneratingNaturalSwimmerCharges = new ArrayList<>();

    // keeps track of decrement
    Map<UUID, Integer> naturalSwimmerCharges = new HashMap<>();

    // keeps track of charges
    Map<UUID, Integer> hydrasNaturalSwimmerCharges = new HashMap<>();

}
