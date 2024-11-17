package DungenKeeper;

import java.util.LinkedList;

public class DungenBuilder {
    private LinkedList<Room> levels;

    public DungenBuilder() {
        this.levels = new LinkedList<Room>();
    }

    public void addLevel(Room room) {
        levels.add(room);
    }

    public LinkedList<Room> getLevels() {
        return levels;
    }

}
