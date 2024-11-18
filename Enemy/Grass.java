package Enemy;

public class Grass extends Enemy.Enemy {
    private boolean usedSpecialAbility = false;

    public Grass(String name, String description) {
        super(name, description, new AttackList());
    }

    @Override
    public void useSpecialAbility() {
        if (!usedSpecialAbility && health < 5) {
            health += 3;
            System.out.println("GrassEnemy heals itself! Gains 3 health. Current health: " + health);
            usedSpecialAbility = true;
        } else {
            System.out.println("Special ability cannot be used.");
        }
    }
}