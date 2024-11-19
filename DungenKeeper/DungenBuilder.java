package DungenKeeper;

import java.util.ArrayList;
import java.util.List;

public class DungenBuilder {

    private List<Room> levels;
    private int currentLevel;

    public DungenBuilder() {
        this.levels = new ArrayList<>();
        this.currentLevel = 0;
    }

    public void addLevel(Room room) {
        levels.add(room);
    }

    public Room getLevels() {
        return levels.get(currentLevel);
    }

    public void nextLevel() {
        this.currentLevel += 1;
    }


}
