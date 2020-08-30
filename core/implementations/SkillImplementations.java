package hydra.hunter.core.implementations;

import hydra.hunter.core.colors.util.SkillColors;
import hydra.hunter.core.constants.util.SkillConstants;
import hydra.hunter.core.constants.util.UtilConstants;
import hydra.hunter.core.trackers.HydraClassMemberTracker;
import hydra.hunter.core.trackers.SkillTracker;
import hydra.hunter.core.vaults.miscVault.UtilVault;
import org.bukkit.event.Listener;

public interface SkillImplementations extends
        Listener,
        HydraClassMemberTracker,
        SkillTracker,
        UtilVault,
        UtilConstants,
        SkillConstants,
        SkillColors {
}
