package User_case.BattleUserCase;

import Entity.Player;
import Entity.Equipment;
import Entity.Enemy;
import User_case.EnemyUseCase.EnemyInputBoundary;

public interface BattleInputBoundaryInterface {
        void askForEquipment(Player player);
        void compareElement(Player player, Equipment equipment, Enemy enemy);
        void battleRound(Player player, Enemy enemy, EnemyInputBoundary boundary);
}
