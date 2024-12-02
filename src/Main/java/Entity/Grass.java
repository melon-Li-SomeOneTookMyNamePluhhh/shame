package Entity;

public class Grass extends Enemy {

    public Grass(String name, String description) {
        super(name, description, "Grass");
    }

    @Override
    public void useSpecialAbility() {
        if (!usedSpecialAbility && health < 5) {
            health += 3;
            Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
            guiUtility.displayOutput(name + " heals itself! Gains 3 health. Current health: " + health);
            usedSpecialAbility = true;
        }
    }

    @Override
    protected boolean shouldUseSpecialAbility() {
        return health < 5 && !usedSpecialAbility;
    }
}

