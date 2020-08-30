package hydra.hunter.core.constants.commands;

import hydra.hunter.core.colors.commands.join.JoinHydraColors;

public interface JoinHydraConstants extends
        CommandConstants,
        JoinHydraColors {

    String PLAYER_CONFIRMATION_JOIN_HYDRA_MESSAGE =
            PLAYER_CONFIRMATION_JOIN_HYDRA_MESSAGE_COLOR
                    + "Successfully became a Hydra";

    String PLAYER_ALREADY_A_HYDRA_MESSAGE =
            PLAYER_ALREADY_A_HYDRA_MESSAGE_COLOR
                    + "It appears you are already a Hydra";
}
