package User_case.Items_Usercase;

public class ExitOutputBoundary implements ExitOutputBoundaryInterface {
    /**
     * Displays a general message to the user.
     * @param message The message to be displayed.
     */
    public void displayOutput(String message){
        System.out.println(message);
    }

}