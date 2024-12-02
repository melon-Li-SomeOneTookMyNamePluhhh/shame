package Entity;

import Frameworks_and_drivers.RiddleFetcher;

public class NPC extends Item {
    String Riddle;
    String Speech;
    String Answer;

    // Constructor for Item.NPC that calls the Item.Item constructor
    public NPC(String name, String description, String floorDescription, String Riddle, String Answer, String Speech) {
        // Call the constructor of Item.Item class with parameters
        super(name, description, floorDescription,"NPC", "regular"); // Pass values to the superclass constructor
        this.Riddle = Riddle;
        this.Answer = Answer;
        this.Speech = Speech;
    }
    // Overloaded constructor that gets the riddle directly from the api call
    public NPC(String name, String description, String floorDescription, String Speech) {
        // Call the constructor of Item.Item class with parameters
        super(name, description, floorDescription,"NPC", "regular" ); // Pass values to the superclass constructor

        // Get the riddle and answer from RiddleFetcher
        String[] riddleData = RiddleFetcher.fetchRiddleAndAnswer();

        // Assign the fetched riddle and answer to the fields
        this.Riddle = riddleData[0];  // riddle
        this.Answer = riddleData[1].trim().toLowerCase();  // answer

        this.Speech = Speech;
    }
    public String getRiddle() {
        return Riddle;
    }
    public String getAnswer() {
        return Answer;
    }
    public String getSpeech() {
        return Speech;
    }
}



