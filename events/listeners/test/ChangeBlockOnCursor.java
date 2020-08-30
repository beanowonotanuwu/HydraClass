package hydra.hunter.events.listeners.test;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ChangeBlockOnCursor implements Listener {

    @EventHandler
    public void onActivation(final ProjectileHitEvent EVENT) {

        final Block BLOCK = EVENT.getHitBlock();
        final Material MATERIAL = BLOCK.getType();

        // set type
        BLOCK.setType(Material.WATER);

    }
}
