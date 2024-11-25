package Enemy;

import GUI.GUIUtility;

public class Grass extends Enemy {
    private boolean usedSpecialAbility = false;

    public Grass(String name, String description) {
        super(name, description, new AttackList());
    }

    @Override
    public void useSpecialAbility() {
        if (!usedSpecialAbility && health < 5) {
            health += 3;
            GUIUtility.displayOutput("GrassEnemy heals itself! Gains 3 health. Current health: " + health);
            usedSpecialAbility = true;
        } else {
            GUIUtility.displayOutput("Special ability cannot be used.");
        }
    }
}