package Enemy;

import GUI.GUIUtility;
import Player.Player;
public class Water extends Enemy {
    private boolean damageReduced = false; // Tracks if player's damage is reduced

    public Water(String name, String description) {
        super(name, description, "Water"); // Set type to "Water"
    }

    @Override
    public void useSpecialAbility() {
        if (health < 5 && !usedSpecialAbility) {
            GUIUtility.displayOutput(name + " activates its water shield!");
            usedSpecialAbility = true;
            damageReduced = true;
        }
    }

    @Override
    protected boolean shouldUseSpecialAbility() {
        return health < 5 && !usedSpecialAbility;
    }

    @Override
    public int performAction() {
        if (shouldUseSpecialAbility()) {
            useSpecialAbility();
            return this.damage;
        } else {
            String attackType = getRandomAttack();
            switch (attackType) {
                case "normal":
                    this.damage = attackList.normalAttack();
                    System.out.println(name + " used a normal attack, dealing "
                            + damage + " damage.");
                    return damage;
                case "critical":
                    this.damage = attackList.criticalStrike();
                    System.out.println(name + " used a critical strike, dealing "
                            + damage + " damage.");
                    return damage;
                case "defense":
                    int absorbed = attackList.defense();
                    System.out.println(name + " used defense, absorbing " + absorbed + " damage.");
                    this.damage = 0;
                    return this.damage;
                default:
                    System.out.println(name + " used an unknown attack type.");
                    this.damage = 0;
                    return this.damage;
            }
        }
    }
}


