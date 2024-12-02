package User_case.Items_Usercase;

public class NPCOutputBoundary implements NPCOutputBoundaryInterface {
    /**
     * Displays a general message to the player.
     * @param message The message to be displayed.
     */
    public void displayOutput(String message){
        System.out.println(message);
    }
}
