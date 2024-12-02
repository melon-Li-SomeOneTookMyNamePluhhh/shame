package User_case.Items_Usercase;

import Entity.Item;
import Entity.NPC;
import java.util.Scanner;

public class NPCInputBoundary implements NPCInputBoundaryInterface {

    private NPC npc; // NPC object to be interacted with
    private NPCOutputBoundaryInterface OutputBoundary;
    // Constructor that takes an NPC object
    public NPCInputBoundary(NPC npc, NPCOutputBoundaryInterface OutputBoundary) {
        this.npc = npc;
       this.OutputBoundary = OutputBoundary;
    }

    @Override
    public void interact(Item location) {
        // Create a Scanner object to read input from the terminal
        Scanner scanner = new Scanner(System.in);

        // Print the options for the user
        OutputBoundary.displayOutput("Would you like a riddle or my speech dialogue? Enter 'riddle' for my riddle or 'speech' for my speech dialogue.");
        OutputBoundary.displayOutput("Enter 'exit' to exit.");

        // Read the user's input
        String userInput = scanner.nextLine().trim().toLowerCase();  // Read input, trim whitespace, and convert to lowercase

        // Handle different options based on the input
        switch (userInput) {
            case "riddle":
                boolean correctAnswer = false;  // To track if the user answers correctly
                while (!correctAnswer) {
                    // Give the riddle and prompt the user for their answer
                    OutputBoundary.displayOutput("Here is your riddle: " + npc.getRiddle() + " Give your answer or type 'exit' to exit.");
                    String userAnswer = scanner.nextLine().trim().toLowerCase();  // Read the answer input

                    if (userAnswer.equals("exit")) {
                        OutputBoundary.displayOutput("Goodbye!");
                        return;  // Exit the interaction
                    }

                    // Check if the user's answer is correct
                    if (userAnswer.equals(npc.getAnswer())) {
                        OutputBoundary.displayOutput("Correct! Good job!");
                        correctAnswer = true;  // Exit the loop since the answer is correct
                    } else {
                        OutputBoundary.displayOutput("Your answer is incorrect. Guess again!");
                    }
                }

                break;

            case "speech":
                // Call a method to give the speech dialogue (this would be a placeholder)
                OutputBoundary.displayOutput("Here is my speech dialogue: " + npc.getSpeech());
                break;

            case "exit":
                // Item.Exit the interaction
                OutputBoundary.displayOutput("Goodbye!");
                break;

            default:
                // If the input doesn't match any valid option, prompt again
                OutputBoundary.displayOutput("Invalid option. Please enter 'riddle', 'speech', or 'exit'.");
                break;
        }

        // Close the scanner
        scanner.close();
    }


    @Override
    public Item pickup() {
        OutputBoundary.displayOutput("What are you doing? Put me down at once!");
        return null;
    }
}

