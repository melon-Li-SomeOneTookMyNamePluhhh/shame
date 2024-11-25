package Enemy;

import GUI.GUIUtility;

public class Fire extends Enemy {
    private boolean usedSpecialAbility = false;

    public Fire(String name, String description) {
        super(name, description, new AttackList());
    }

    @Override
    public void useSpecialAbility() {
        if (health < 3 && !usedSpecialAbility) {
            GUIUtility.displayOutput(name + " activates its special ability! All normal attacks become critical strikes.");
            usedSpecialAbility = true;
        } else {
            GUIUtility.displayOutput(name + " cannot use its special ability.");
        }
    }

    public void action() {
        if (health < 3 && !usedSpecialAbility) {
            useSpecialAbility();
        }

        if (usedSpecialAbility) {
            attackList.criticalStrike();
        } else {
            attackList.normalAttack();
        }
    }
}
