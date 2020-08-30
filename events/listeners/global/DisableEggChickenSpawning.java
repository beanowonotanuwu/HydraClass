package hydra.hunter.events.listeners.global;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;

public class DisableEggChickenSpawning implements
        Listener {

    @EventHandler
    public void onChickenSpawnThroughEgg(final PlayerEggThrowEvent EVENT) {

        EVENT.setHatching(false);
    }
}
