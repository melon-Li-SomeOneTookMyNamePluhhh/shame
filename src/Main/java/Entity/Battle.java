package Entity;

public class Battle {
    private Player player;
    private Enemy enemy;
    private boolean specialUsed;

    public Battle(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        this.specialUsed = false;
    }
    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }
    public Enemy getEnemy(){return this.enemy;}
    public void setEnemy(Enemy enemy) {this.enemy = enemy;}
    public boolean getSpecialUsed() { return this.specialUsed;}
    public void setSpecialUsed() { this.specialUsed = True;}
}
