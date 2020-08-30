package hydra.hunter.events.listeners.test;

import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ChangeBlockOnCursorPT2 implements Listener {

    @EventHandler
    public void onActivation(final PlayerInteractEvent EVENT) {

        final Player PLAYER = EVENT.getPlayer();
        final Action ACTION = EVENT.getAction();

        if (ACTION.equals(Action.RIGHT_CLICK_AIR)) {

            PLAYER.launchProjectile(Snowball.class);
        }
    }
}
