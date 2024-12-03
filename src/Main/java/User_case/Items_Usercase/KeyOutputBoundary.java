package User_case.Items_Usercase;

import java.awt.event.KeyListener;

public class KeyOutputBoundary implements KeyOutputBoundaryInterface{

    /**
     * Displays a general message to the user.
     * @param message The message to be displayed.
     */
    public void displayOutput(String message){
        System.out.println(message);
    }

}
