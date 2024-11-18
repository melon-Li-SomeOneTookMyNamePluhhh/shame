package Enemy;

import Player.Player;

public class Water extends Enemy {
    private boolean usedSpecialAbility = false;

    public Water(String name, String description) {
        super(name, description, new AttackList());
    }

    @Override
    public void useSpecialAbility() {
        if (health < 5 && !usedSpecialAbility) {
            System.out.println(name + " activates its water shield!");
            usedSpecialAbility = true;
        }
    }

    public void action(Player player) {
        if (health < 5 && !usedSpecialAbility) {
            useSpecialAbility();
        }

        if (usedSpecialAbility) {
            // reduce player's damage to realize defence
            player.setDamage(player.getDamage() - 2);
            if (player.getDamage() < 0) {
                player.setDamage(0); // make sure damage can not be negative
            }
            attackList.defense();
        } else {
            attackList.normalAttack(); // or normal attack
        }
    }
}
