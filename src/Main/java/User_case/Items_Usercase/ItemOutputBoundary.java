package User_case.Items_Usercase;

import Entity.Item.Item;

public class ItemOutputBoundary implements ItemOutputBoundaryInterface {

    /**
     * Displays a general message to the user.
     * @param message The message to be displayed.
     */
    public void displayOutput(String message){
        System.out.println(message);
    }

}
