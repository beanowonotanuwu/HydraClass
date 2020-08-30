package hydra.hunter.core.constants.util;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public interface SkillConstants {

    Material STANDARD_SWORD = Material.IRON_SWORD;
    Material STANDARD_AXE = Material.IRON_AXE;
    Material STANDARD_BOW = Material.BOW;

    Material BOOSTER_SWORD = Material.GOLDEN_SWORD;
    Material BOOSTER_AXE = Material.GOLDEN_AXE;

    Material POWER_SWORD = Material.DIAMOND_SWORD;
    Material POWER_AXE = Material.DIAMOND_AXE;


    Action RIGHT_CLICK_AIR = Action.RIGHT_CLICK_AIR;
    Action RIGHT_CLICK_BLOCK = Action.RIGHT_CLICK_BLOCK;

    Action LEFT_CLICK_AIR = Action.LEFT_CLICK_AIR;
    Action LEFT_CLICK_BLOCK = Action.LEFT_CLICK_BLOCK;


    ArrayList<Material> IS_SWORD = new ArrayList<>(Arrays.asList(
            STANDARD_SWORD,
            BOOSTER_SWORD,
            POWER_SWORD
    ));

    ArrayList<Material> IS_AXE = new ArrayList<>(Arrays.asList(
            STANDARD_AXE,
            BOOSTER_AXE,
            POWER_AXE
    ));


    ArrayList<Action> IS_RIGHT_CLICK = new ArrayList<>(Arrays.asList(
            RIGHT_CLICK_AIR,
            RIGHT_CLICK_BLOCK
    ));

    ArrayList<Action> IS_LEFT_CLICK = new ArrayList<>(Arrays.asList(
            LEFT_CLICK_AIR,
            LEFT_CLICK_BLOCK
    ));



    default boolean isSword(final Player PLAYER) {

        final ItemStack ITEM_IN_HAND = PLAYER.getItemInHand();
        final Material ITEM_IN_HAND_TYPE = ITEM_IN_HAND.getType();

        if (IS_SWORD.contains(ITEM_IN_HAND_TYPE)) {
            return true;
        }
        return false;
    }

    default boolean isAxe(final Player PLAYER) {

        final ItemStack ITEM_IN_HAND = PLAYER.getItemInHand();
        final Material ITEM_IN_HAND_TYPE = ITEM_IN_HAND.getType();

        if (IS_AXE.contains(ITEM_IN_HAND_TYPE)) {
            return true;
        }
        return false;
    }


    default boolean rightClickedLivingEntity(final Entity ENTITY) {

        if (ENTITY instanceof LivingEntity) {
            return true;
        }
        return false;
    }

    default boolean isPlayer(final Entity ENTITY) {

        if (ENTITY instanceof Player) {
            return true;
        }
        return false;
    }


    default boolean isRightClick(final Action ACTION) {

        if (IS_RIGHT_CLICK.contains(ACTION)) {
            return true;
        }
        return false;
    }

    default boolean isLeftClick(final Action ACTION) {

        if (IS_LEFT_CLICK.contains(ACTION)) {
            return true;
        }
        return false;
    }


    default boolean isSneaking(final Player PLAYER) {

        if (PLAYER.isSneaking()) {
            return true;
        }
        return false;
    }
}
