package hydra.hunter.commands.select.axeSkills;

import hydra.hunter.core.implementations.commands.SelectViperSpitImplementations;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class SelectViperSpit implements
        SelectViperSpitImplementations {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            // check if player is a hydra
            final Player PLAYER = (Player) sender;
            final UUID PLAYER_UUID = PLAYER.getUniqueId();
            if (isHydra(PLAYER_UUID)) {

                // check if player already has a sword skill
                if (hasAxeSkillIgnoreViperSpit(PLAYER_UUID)) {
                    PLAYER.sendMessage(HYDRA_ALREADY_HAS_AXE_SKILL);

                    // and return
                    return true;
                }

                // check if player already has the skill
                if (hasViperSpit(PLAYER_UUID)) {
                    PLAYER.sendMessage(HYDRA_SUCCESSFULLY_UNEQUIPPING_SKILL);

                    // remove player from arraylists
                    hydrasWithViperSpit.remove(PLAYER_UUID);

                    // and return
                    return true;
                }

                // send confirmation message
                PLAYER.sendMessage(HYDRA_SUCCESSFULLY_EQUIPPING_SKILL);

                // add player to arraylists
                hydrasWithViperSpit.add(PLAYER_UUID);

            } else {
                PLAYER.sendMessage(NON_HYDRA_EQUIPING_SKILL);
            }
        } else {
            System.out.println(SERVER_USING_PLAYER_ONLY_COMMAND);
        }
        return true;
    }
}
