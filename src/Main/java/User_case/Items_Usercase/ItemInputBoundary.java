package User_case.Items_Usercase;
import Entity.Exit;
import Entity.Equipment;
import Entity.Key;
import Entity.NPC;
import Entity.Item;

import java.util.Scanner;

public class ItemInputBoundary implements ItemInputBoundaryInterface {

    private Item item; // Key object to be interacted with
    private ItemOutputBoundaryInterface OutputBoundary;

    // Constructor that takes an NPC object
    public ItemInputBoundary(Item item, ItemOutputBoundaryInterface OutputBoundary) {
        this.item = item;
        this.OutputBoundary = OutputBoundary;
    }

    public void interact(Item player_location) {
        if (item.getType() == "Exit") {
            Exit exit = (Exit) item;
            Item inhand = player_location;
            if (exit.getLocked() && inhand.getType() != "Key") {
                OutputBoundary.displayOutput("you tried to pick the lock but it didn't work");
            }
            else if (exit.getLocked() && inhand.getType() == "Key") {
                Key keyInHand = (Key) inhand;

                if (keyInHand.isUsed()) {
                    OutputBoundary.displayOutput(keyInHand.getName() + " does not match the" + exit.getName());
                }
                else {
                    exit.setLocked(false);  // Unlock the exit
                    keyInHand.setUsed(true);  // Mark the key as used
                    OutputBoundary.displayOutput("You unlocked the door! You walk through the doorway.");
                    exit.getwhichRoom().leave();
                }
            }

            else {
                OutputBoundary.displayOutput("the door is already opened");
            }

        }
        else if (item.getType() == "Equipment") {
            return;
        }
        else if (item.getType() == "Key") {
            Key key = (Key) item;
            if (player_location.getType() == "Exit" && key.isUsed()) {
                OutputBoundary.displayOutput(key.getName() + " does not match the" + player_location.getName());
            } else if (player_location.getType() == "Exit" && key.isUsed() == false) {
                OutputBoundary.displayOutput("You have cleared the " + player_location.getName() + " you can leave the room at anytime");
                player_location.setLocked(false);
                key.setUsed(true);
            } else {
                OutputBoundary.displayOutput("you poked the" + key.getName() + " onto " + player_location.getName() + " nothing happens");
            }
        }
        else {
            NPC npc = (NPC) item;
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
    }

    public Item pickup() {
        if (item.getType() == "Exit") {
            OutputBoundary.displayOutput("You can't just lift the exit, silly!");
            return null;
        }
        else if (item.getType() == "Equipment") {
            OutputBoundary.displayOutput("You pickup " + item.getName());
            return item;
        }
        else if (item.getType() == "Key") {
            OutputBoundary.displayOutput("You pickup " + item.getName());
            return item;
        }
        else {
            OutputBoundary.displayOutput("What are you doing? Put me down at once!");
            return null;
        }
    }

    // Regular method to inspect the item (has a body)
    public void Inspect() {
        OutputBoundary.displayOutput("Inspecting the item: " + item.getName() + ": " + item.getDescription() + ".");
    }

    // Regular method to pick up the item
    // this method should to regularly overrided such that awkward moment of you picked up exit will not happen


}
