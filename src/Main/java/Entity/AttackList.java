package Entity;

import java.util.Random;

public class AttackList {
    private Random random;

    public AttackList() {
        this.random = new Random();
    }

    public int normalAttack() {
        return random.nextInt(3) + 1; // 生成 1, 2, 或 3
    }

    public int criticalStrike() {
        return random.nextInt(3) + 4; // 生成 4, 5, 或 6
    }

    public int defense() {
        return random.nextInt(3) + 1; // 生成 1, 2, 或 3
    }
}
