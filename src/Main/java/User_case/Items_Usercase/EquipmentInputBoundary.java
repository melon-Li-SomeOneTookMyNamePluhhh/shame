package User_case.Items_Usercase;

import Entity.Item;
import Entity.Equipment;

public class EquipmentInputBoundary extends ItemInputBoundary implements EquipmentInputBoundaryInterface {

    private Equipment equipment; // Key object to be interacted with
    private EquipmentOutputBoundaryInterface OutputBoundary;

    // Constructor that takes an NPC object
    public EquipmentInputBoundary(Equipment equipment, EquipmentOutputBoundaryInterface OutputBoundary) {
        super(equipment, OutputBoundary);
        this.equipment = equipment;
        this.OutputBoundary = OutputBoundary;
    }

    @Override
    public void interact(Item location) {
        return;
    }

    @Override
    public Item pickup() {
        OutputBoundary.displayOutput("You pickup " + equipment.getName());
        return equipment;
    }

}