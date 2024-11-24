import DungenKeeper.DungenBuilder;

public class Main {

    // build your custom level here!
    public static void main(String[] args) {

        System.out.println("can I commit?");
        startGame();
    }

    public static void startGame(){
        DungenBuilder dungen = new DungenBuilder();
        dungen.addLevel();

    }
}