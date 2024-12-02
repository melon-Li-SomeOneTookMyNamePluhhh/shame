package Entity;

public class Water extends Enemy {
    private boolean damageReduced = false;

    public Water(String name, String description) {
        super(name, description, "Water");
    }

    @Override
    public void useSpecialAbility() {
        if (health < 5 && !usedSpecialAbility) {
            System.out.println(name + " activates its water shield!");
            usedSpecialAbility = true;
            damageReduced = true;
        }
    }

    @Override
    protected boolean shouldUseSpecialAbility() {
        return health < 5 && !usedSpecialAbility;
    }
}
