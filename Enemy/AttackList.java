package Enemy;

import GUI.GUIUtility;

public class AttackList {
    public void normalAttack() {
        GUIUtility.displayOutput("Normal attack! The player loses 2 health.");
    }

    public void criticalStrike() {
        GUIUtility.displayOutput("Critical strike! The player loses 5 health.");
    }

    public void defense() {
        GUIUtility.displayOutput("Defense! Enemy absorbs 3 damage from the attack.");
    }
}

