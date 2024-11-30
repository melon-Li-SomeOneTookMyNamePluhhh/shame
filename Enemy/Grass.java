package Enemy;

import GUI.GUIUtility;

public class Grass extends Enemy {

    public Grass(String name, String description) {
        super(name, description, new AttackList(), "Grass"); // Set type to "Grass"
    }

    @Override
    public void useSpecialAbility() {
        if (!usedSpecialAbility && health < 5) {
            health += 3;
            GUIUtility.displayOutput("GrassEnemy heals itself! Gains 3 health. Current health: " + health);
            usedSpecialAbility = true; // Mark that special ability has been used
        } else {
            GUIUtility.displayOutput("Special ability cannot be used.");
        }
    }

    @Override
    protected boolean shouldUseSpecialAbility() {
        return health < 5 && !usedSpecialAbility;
    }

    // No need to override performAction() as special ability doesn't affect attack logic
}
