package hydra.hunter.core.trackers;

import java.util.ArrayList;
import java.util.UUID;

public interface SkillTracker {


    ArrayList<UUID> hydrasWithViperBreath = new ArrayList<>();
    ArrayList<UUID> hydrasWithJellyfishSting = new ArrayList<>();

    ArrayList<UUID> hydrasWithDolphinDive = new ArrayList<>();
    ArrayList<UUID> hydrasWithViperSpit = new ArrayList<>();

    ArrayList<UUID> hydrasWithDrowningCannon = new ArrayList<>();
    ArrayList<UUID> hydrasWithFreezingCannon = new ArrayList<>();
    ArrayList<UUID> hydrasWithInkingCannon =  new ArrayList<>();
    ArrayList<UUID> hydrasWithGlassCannon = new ArrayList<>();

    ArrayList<UUID> hydrasWithAmplifiedClaws = new ArrayList<>();
    ArrayList<UUID> hydrasWithScaleManipulation = new ArrayList<>();

    ArrayList<UUID> hydrasWithPoisonousBlood = new ArrayList<>();


    default boolean hasViperBreath(final UUID PLAYER_UUID) {

        if (hydrasWithViperBreath.contains(PLAYER_UUID)) {
            return true;
        }
        return false;
    }
    default boolean hasJellyfishSting(final UUID PLAYER_UUID) {

        if (hydrasWithJellyfishSting.contains(PLAYER_UUID)) {
            return true;
        }
        return false;
    }

    default boolean hasDolphinDive(final UUID PLAYER_UUID) {

        if (hydrasWithDolphinDive.contains(PLAYER_UUID)) {
            return true;
        }
        return false;
    }
    default boolean hasViperSpit(final UUID PLAYER_UUID) {
        if (hydrasWithViperSpit.contains(PLAYER_UUID)) {
            return true;
        }
        return false;
    }

    default boolean hasDrowningCannon(final UUID PLAYER_UUID) {
        if (hydrasWithDrowningCannon.contains(PLAYER_UUID)) {
            return true;
        }
        return false;
    }
    default boolean hasFreezingCannon(final UUID PLAYER_UUID) {

        if (hydrasWithFreezingCannon.contains(PLAYER_UUID)) {
            return true;
        }
        return false;
    }
    default boolean hasInkingCannon(final UUID PLAYER_UUID) {

        if (hydrasWithInkingCannon.contains(PLAYER_UUID)) {
            return true;
        }
        return false;
    }
    default boolean hasGlassCannon(final UUID PLAYER_UUID) {

        if (hydrasWithGlassCannon.contains(PLAYER_UUID)) {
            return true;
        }
        return false;
    }

    default boolean hasAmplifiedClaws(final UUID PLAYER_UUID) {

        if (hydrasWithAmplifiedClaws.contains(PLAYER_UUID)) {
            return true;
        }
        return false;
    }
    default boolean hasScaleManipulation(final UUID PLAYER_UUID) {

        if (hydrasWithScaleManipulation.contains(PLAYER_UUID)) {
            return true;
        }
        return false;
    }

    default boolean hasPoisonousBlood(final UUID PLAYER_UUID) {
        if (hydrasWithPoisonousBlood.contains(PLAYER_UUID)) {
            return true;
        }
        return false;
    }


    default boolean hasSwordSkillIgnoreViperBreath(final UUID PLAYER_UUID) {

        if (hasJellyfishSting(PLAYER_UUID)) {
            return true;
        }
        return false;
    }
    default boolean hasSwordSkillIgnoreJellyfishSting(final UUID PLAYER_UUID) {

        if (hasViperBreath(PLAYER_UUID)) {
            return true;
        }
        return false;
    }

    default boolean hasAxeSkillIgnoreDolphinDive(final UUID PLAYER_UUID) {

        if (hasViperSpit(PLAYER_UUID)) {
            return true;
        }
        return false;
    }
    default boolean hasAxeSkillIgnoreViperSpit(final UUID PLAYER_UUID) {

        if (hasDolphinDive(PLAYER_UUID)) {
            return true;
        }
        return false;
    }

    default boolean hasPassiveASkillIgnoreDrowningCannon(final UUID PLAYER_UUID) {

        if (hasFreezingCannon(PLAYER_UUID)) {
            return true;
        } else if (hasInkingCannon(PLAYER_UUID)) {
            return true;
        } else if (hasGlassCannon(PLAYER_UUID)) {
            return true;
        }
        return false;
    }
    default boolean hasPassiveASkillIgnoreFreezingCannon(final UUID PLAYER_UUID) {

        if (hasDrowningCannon(PLAYER_UUID)) {
            return true;
        } else if (hasInkingCannon(PLAYER_UUID)) {
            return true;
        } else if (hasGlassCannon(PLAYER_UUID)) {
            return true;
        }
        return false;
    }
    default boolean hasPassiveASkillIgnoreInkingCannon(final UUID PLAYER_UUID) {

        if (hasDrowningCannon(PLAYER_UUID)) {
            return true;
        } else if (hasFreezingCannon(PLAYER_UUID)) {
            return true;
        } else if (hasGlassCannon(PLAYER_UUID)) {
            return true;
        }
        return false;
    }
    default boolean hasPassiveASkillIgnoreGlassCannon(final UUID PLAYER_UUID) {

        if (hasDrowningCannon(PLAYER_UUID)) {
            return true;
        } else if (hasFreezingCannon(PLAYER_UUID)) {
            return true;
        } else if (hasInkingCannon(PLAYER_UUID)) {
            return true;
        }
        return false;
    }

    default boolean hasPassiveBSkillIgnoreAmplifiedClaws(final UUID PLAYER_UUID) {

        if (hasScaleManipulation(PLAYER_UUID)) {
            return true;
        }
        return false;
    }
    default boolean hasPassiveBSkillIgnoreScaleManipulation(final UUID PLAYER_UUID) {

        return hasAmplifiedClaws(PLAYER_UUID);
    }

    default boolean hasPassiveCSkillIgnorePoisonousBlood(final UUID PLAYER_UUID) {

        return false;
    }

}
