package User_case.Items_Usercase;

public class ItemOutputBoundary implements ItemOutputBoundaryInterface {

    /**
     * Displays a general message to the user.
     * @param message The message to be displayed.
     */
    public void displayOutput(String message){
        Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
        guiUtility.displayOutput(message);
    }

}
