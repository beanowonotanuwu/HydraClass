package hydra.hunter.core.constants.commands;

import hydra.hunter.core.colors.commands.util.HydraCommandColors;

public interface HydraCommandConstants extends
        HydraCommandColors {
    String NON_HYDRA_EQUIPING_SKILL =
            NON_HYDRA_EQUIPING_SKILL_COLOR
                    + "You must be a Hydra to preform this action";
    String HYDRA_SUCCESSFULLY_EQUIPPING_SKILL =
            HYDRA_SUCCESSFULLY_EQUIPING_SKILL_COLOR
                    + "Successfully equipped skill";
    String HYDRA_SUCCESSFULLY_UNEQUIPPING_SKILL =
            HYDRA_ALREADY_HAS_SKILL_COLOR
                    + "Successfully unequipped skill";
    String HYDRA_ALREADY_HAS_SWORD_SKILL =
            HYDRA_ALREADY_HAS_SWORD_SKILL_COLOR
                    + "You already have a sword skill";
    String HYDRA_ALREADY_HAS_AXE_SKILL =
            HYDRA_ALREADY_HAS_AXE_SKILL_COLOR
                    + "You already have an axe skill";
    String HYDRA_ALREADY_HAS_PASSIVE_A_SKILL =
            HYDRA_ALREADY_HAS_AXE_SKILL_COLOR
                    + "You already have an passive a skill";
    String HYDRA_ALREADY_HAS_PASSIVE_B_SKILL =
            HYDRA_ALREADY_HAS_AXE_SKILL_COLOR
                    + "You already have an passive b skill";
    String HYDRA_ALREADY_HAS_PASSIVE_C_SKILL =
            HYDRA_ALREADY_HAS_AXE_SKILL_COLOR
                    + "You already have an passive c skill";
}
