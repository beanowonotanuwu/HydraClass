package hydra.hunter.commands.select.swordSkills;

import hydra.hunter.core.implementations.commands.SelectViperBreathImplementations;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class SelectViperBreath implements SelectViperBreathImplementations {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            // calculations
            final Player PLAYER = (Player) sender;
            final UUID PLAYER_UUID = PLAYER.getUniqueId();

            // check if player is a hydra
            if (isHydra(PLAYER_UUID)) {

                // check if player already has a sword skill
                if (hasSwordSkillIgnoreViperBreath(PLAYER_UUID)) {
                    PLAYER.sendMessage(HYDRA_ALREADY_HAS_SWORD_SKILL);

                    // and return
                    return true;
                }

                // check if player already has the skill
                if (hasViperBreath(PLAYER_UUID)) {
                    PLAYER.sendMessage(HYDRA_SUCCESSFULLY_UNEQUIPPING_SKILL);

                    // remove player from arraylists
                    hydrasWithViperBreath.remove(PLAYER_UUID);

                    // and return
                    return true;
                }

                // send confirmation message
                PLAYER.sendMessage(HYDRA_SUCCESSFULLY_EQUIPPING_SKILL);

                // add player to arraylists
                hydrasWithViperBreath.add(PLAYER_UUID);

            } else {
                PLAYER.sendMessage(NON_HYDRA_EQUIPING_SKILL);
            }
        } else {
            System.out.println(SERVER_USING_PLAYER_ONLY_COMMAND);
        }
        return true;
    }
}
