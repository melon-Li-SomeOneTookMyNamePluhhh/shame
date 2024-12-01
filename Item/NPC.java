package Item;

import Item_with_subclasses_and_API.RiddleFetcher;
import GUI.GUIUtility;
import java.util.Scanner;

public class NPC extends Item {
    String Riddle;
    String Speech;
    String Answer;

    // Constructor for Item.NPC that calls the Item.Item constructor
    public NPC(String name, String description, String floorDescription, String Riddle, String Answer, String Speech) {
        // Call the constructor of Item.Item class with parameters
        super(name, description, floorDescription,"NPC"); // Pass values to the superclass constructor
        this.Riddle = Riddle;
        this.Answer = Answer;
        this.Speech = Speech;
    }
    // Overloaded constructor that gets the riddle directly from the api call
    public NPC(String name, String description, String floorDescription, String Speech) {
        // Call the constructor of Item.Item class with parameters
        super(name, description, floorDescription,"NPC"); // Pass values to the superclass constructor

        // Get the riddle and answer from RiddleFetcher
        String[] riddleData = RiddleFetcher.fetchRiddleAndAnswer();

        // Assign the fetched riddle and answer to the fields
        this.Riddle = riddleData[0];  // riddle
        this.Answer = riddleData[1].trim().toLowerCase();  // answer

        this.Speech = Speech;
    }

    @Override
    public void interact(Item location) {
        // Create a Scanner object to read input from the terminal
        Scanner scanner = new Scanner(System.in);

        // Print the options for the user
        GUIUtility.displayOutput("Would you like a riddle or my speech dialogue? Enter 'riddle' for my riddle or 'speech' for my speech dialogue.");
        GUIUtility.displayOutput("Enter 'exit' to exit.");

        // Read the user's input
        String userInput = scanner.nextLine().trim().toLowerCase();  // Read input, trim whitespace, and convert to lowercase

        // Handle different options based on the input
        switch (userInput) {
            case "riddle":
                boolean correctAnswer = false;  // To track if the user answers correctly
                while (!correctAnswer) {
                    // Give the riddle and prompt the user for their answer
                    GUIUtility.displayOutput("Here is your riddle: " + Riddle + " Give your answer or type 'exit' to exit.");
                    String userAnswer = scanner.nextLine().trim().toLowerCase();  // Read the answer input

                    if (userAnswer.equals("exit")) {
                        GUIUtility.displayOutput("Goodbye!");
                        return;  // Exit the interaction
                    }

                    // Check if the user's answer is correct
                    if (userAnswer.equals(this.Answer)) {
                        GUIUtility.displayOutput("Correct! Good job!");
                        correctAnswer = true;  // Exit the loop since the answer is correct
                    } else {
                        GUIUtility.displayOutput("Your answer is incorrect. Guess again!");
                    }
                }

                break;

            case "speech":
                // Call a method to give the speech dialogue (this would be a placeholder)
                GUIUtility.displayOutput("Here is my speech dialogue: " + Speech);
                break;

            case "exit":
                // Item.Exit the interaction
                GUIUtility.displayOutput("Goodbye!");
                break;

            default:
                // If the input doesn't match any valid option, prompt again
                GUIUtility.displayOutput("Invalid option. Please enter 'riddle', 'speech', or 'exit'.");
                break;
        }

        // Close the scanner
        scanner.close();
    }

    @Override
    public Item pickup() {
        System.out.println("What are you doing? Put me down at once!");
        return null;
    }
}



