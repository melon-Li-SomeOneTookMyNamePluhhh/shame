// 文件路径: entities/Fire.java
package Entity;

public class Fire extends Enemy {
    private boolean convertedToCritical = false;

    public Fire(String name, String description) {
        super(name, description, "Fire");
    }

    @Override
    public void useSpecialAbility() {
        if (health < 3 && !usedSpecialAbility) {

            Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
            guiUtility.displayOutput(name + " activates its special ability! All normal attacks become critical strikes.");
            usedSpecialAbility = true;
            convertedToCritical = true;
        }
    }

    @Override
    protected boolean shouldUseSpecialAbility() {
        return health < 5 && !usedSpecialAbility;
    }
}

