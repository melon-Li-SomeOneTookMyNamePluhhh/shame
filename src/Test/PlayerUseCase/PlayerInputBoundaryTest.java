package PlayerUseCase;

import Entity.*;
import User_case.GameLevelsUserCase.LevelAdder;
import User_case.PlayerUsercase.PlayerInputBoundary;
import User_case.PlayerUsercase.PlayerOutBoundary;
import User_case.RoomUserCase.RoomItemAdder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerInputBoundaryTest {
    @BeforeEach
    void setUp() {
        Item item = new Exit("exit", "", "this is exit", "regular");
        Enemy enemy = new Fire("enemy", "this is enemy");
        Room room = new Room("room");
        GameLevelList levels = new GameLevelList();
        Player player = new Player(10, 10, 5, room);
        RoomItemAdder adder = new RoomItemAdder(room);
        adder.addItem(item);
        LevelAdder levelAdder = new LevelAdder(levels);
        PlayerInputBoundary playerActions = new PlayerInputBoundary(player, new PlayerOutBoundary());

    }

    @Test
    void walkTo() {
        Item item = new Exit("exit", "", "this is exit", "regular");
        Enemy enemy = new Fire("enemy", "this is enemy");
        Room room = new Room("room");
        GameLevelList levels = new GameLevelList();
        RoomItemAdder adder = new RoomItemAdder(room);
        adder.addItem(item);
        Player player = new Player(10, 10, 5, room);
        LevelAdder levelAdder = new LevelAdder(levels);
        levelAdder.addLevel(room);
        levelAdder.addPlayer(player);
        PlayerInputBoundary playerActions = new PlayerInputBoundary(player, new PlayerOutBoundary());
        playerActions.walkTo("exit");
        assertEquals(item, levels.getPlayer().getLocation());
    }

    @Test
    void pickUp() {
    }

    @Test
    void interact() {
    }

    @Test
    void inspectBag() {
    }

    @Test
    void getFromBag() {
    }

    @Test
    void putInBag() {
    }

    @Test
    void testInteract() {
    }
}