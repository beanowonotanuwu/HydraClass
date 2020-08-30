package hydra.hunter.core.implementations.commands;

import hydra.hunter.core.constants.commands.CommandConstants;
import hydra.hunter.core.constants.commands.HydraCommandConstants;
import hydra.hunter.core.trackers.HydraClassMemberTracker;
import hydra.hunter.core.trackers.SkillTracker;
import org.bukkit.command.CommandExecutor;

public interface SelectDrowningCannonImplementations extends
        CommandExecutor,
        HydraClassMemberTracker,
        SkillTracker,
        CommandConstants,
        HydraCommandConstants {
}
