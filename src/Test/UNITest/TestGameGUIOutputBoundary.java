package src.Test.UNITest;

import User_case.GUI.GUIOutputBoundry;

import java.util.ArrayList;
import java.util.List;

public class TestGameGUIOutputBoundary implements GUIOutputBoundry {
    private final List<String> messages = new ArrayList<>();

    @Override
    public void displayResult(String message) {
        messages.add(message);
    }

    public String getLastMessage() {
        return messages.isEmpty() ? null : messages.get(messages.size() - 1);
    }

    public List<String> getAllMessages() {
        return messages;
    }
}