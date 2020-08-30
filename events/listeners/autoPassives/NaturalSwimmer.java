package hydra.hunter.events.listeners.autoPassives;

import hydra.hunter.Hunter;
import hydra.hunter.core.implementations.autoPassives.NaturalSwimmerImplementations;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import java.util.UUID;

public class NaturalSwimmer implements
        NaturalSwimmerImplementations {

    Hunter plugin;

    public NaturalSwimmer(Hunter plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onHydraSneakingInWater(final PlayerToggleSneakEvent EVENT) {

        // calculations
        final Player PLAYER = EVENT.getPlayer();
        final UUID PLAYER_UUID = PLAYER.getUniqueId();

        // check if player is a hydra
        if (isHydra(PLAYER_UUID)) {


            // check if player is in water
            final Location PLAYER_LOCATION = PLAYER.getLocation();
            final Block BLOCK_PLAYER_IS_STANDING_ON = PLAYER_LOCATION.getBlock();
            final Material BLOCK_TYPE = BLOCK_PLAYER_IS_STANDING_ON.getType();

            if (BLOCK_TYPE.equals(WATER)) {

                // check if player is sneaking
                boolean PLAYER_IS_SNEAKING = EVENT.isSneaking();
                if (PLAYER_IS_SNEAKING) {

                    // CHARGES AREA
                    // check if player in charges hashmap
                    if (hydrasNaturalSwimmerCharges.containsKey(PLAYER_UUID)) {

                        // check for charges
                        if (hydrasNaturalSwimmerCharges.get(PLAYER_UUID) <= NOT_ENOUGH_CHARGES) {

                            PLAYER.sendMessage(MESSAGE_PART_1 + NOT_ENOUGH_CHARGES_MESSAGE);

                            return;
                        } else {

                            // show charges and remove from it
                            PLAYER.sendMessage(MESSAGE_PART_1 + (hydrasNaturalSwimmerCharges.get(PLAYER_UUID) - 1));
                            naturalSwimmerCharges.put(PLAYER_UUID, naturalSwimmerCharges.get(PLAYER_UUID) - DECREMENT);
                            hydrasNaturalSwimmerCharges.put(PLAYER_UUID, BASE_CHARGES + naturalSwimmerCharges.get(PLAYER_UUID));
                        }
                    } else {
                        naturalSwimmerCharges.put(PLAYER_UUID, BASE_CHARGE_DECREMENT);
                        hydrasNaturalSwimmerCharges.put(PLAYER_UUID, BASE_CHARGES);
                    }

                    // add swimming boost
                    swimmingBoost(PLAYER);

                    /*
                    // start duration
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        @Override
                        public void run() {

                            // start duration
                            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                @Override
                                public void run() {
                                    PLAYER.sendMessage("First");
                                }
                            }, 20);

                            // start duration
                            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                @Override
                                public void run() {
                                    PLAYER.sendMessage("Second");
                                }
                            }, 40);

                            // start duration
                            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                @Override
                                public void run() {
                                    PLAYER.sendMessage("Third");
                                }
                            }, 60);
                        }
                    }, 0);

                     */
                }
            }
        }
    }
}
