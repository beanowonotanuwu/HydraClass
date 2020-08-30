package hydra.hunter.commands.select.passiveASkills;

import hydra.hunter.core.implementations.commands.SelectInkingCannonImplementations;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class SelectInkingCannon implements
        SelectInkingCannonImplementations {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label,  String[] args) {
        if (sender instanceof Player) {

            // check if player is a hydra
            final Player PLAYER = (Player) sender;
            final UUID PLAYER_UUID = PLAYER.getUniqueId();
            if (isHydra(PLAYER_UUID)) {

                // check if player already has a passive a
                if (hasPassiveASkillIgnoreInkingCannon(PLAYER_UUID)) {
                    PLAYER.sendMessage(HYDRA_ALREADY_HAS_PASSIVE_A_SKILL);

                    // and return
                    return true;
                }

                // check if player already has the skill
                if (hasInkingCannon(PLAYER_UUID)) {
                    PLAYER.sendMessage(HYDRA_SUCCESSFULLY_UNEQUIPPING_SKILL);

                    // remove player from arraylists
                    hydrasWithInkingCannon.remove(PLAYER_UUID);

                    // and return
                    return true;
                }

                // send confirmation message
                PLAYER.sendMessage(HYDRA_SUCCESSFULLY_EQUIPPING_SKILL);

                // add player to arraylists
                hydrasWithInkingCannon.add(PLAYER_UUID);
            }
            else {
                System.out.println(SERVER_USING_PLAYER_ONLY_COMMAND);
            }
        }
        return true;
    }
}
