package hydra.hunter.core.implementations.commands;

import hydra.hunter.core.constants.commands.JoinHydraConstants;
import hydra.hunter.core.trackers.HydraClassMemberTracker;
import hydra.hunter.core.vaults.miscVault.JoinHydraVault;
import org.bukkit.command.CommandExecutor;

public interface JoinHydraImplementations extends
        CommandExecutor,
        JoinHydraVault,
        JoinHydraConstants,
        HydraClassMemberTracker {
}
