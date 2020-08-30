package hydra.hunter.commands.join;

import hydra.hunter.core.implementations.commands.JoinHydraImplementations;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class JoinHydra
        implements JoinHydraImplementations {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // check if sender is a player
        if (sender instanceof Player) {

            // calculations
            final Player PLAYER = (Player) sender;
            final UUID PLAYER_UUID = PLAYER.getUniqueId();

            // check if player is already a hydra
            if (isHydra(PLAYER)) {

                // send unsuccessfully joined
                PLAYER.sendMessage(PLAYER_ALREADY_A_HYDRA_MESSAGE);

            } else {

                hydrasClassMembers.add(PLAYER_UUID);

                // send successfully joined message
                PLAYER.sendMessage(PLAYER_CONFIRMATION_JOIN_HYDRA_MESSAGE);
            }

        } else {

            // if sender isn't a player sout an error message
            System.out.println(SERVER_USING_PLAYER_ONLY_COMMAND);
        }
        return true;
    }
}
