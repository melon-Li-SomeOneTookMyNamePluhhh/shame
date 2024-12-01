package Item_with_subclasses_and_API;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class RiddleFetcher {

    // Replace this with your API key
    private static final String API_KEY = "lj0hDTdEved2xF7Vy5vIeg==o8Q4z17dIbKgLkyT";

    public static void main(String[] args) {
        try {
            // Set the API URL for riddles so we get riddles
            URL url = new URL("https://api.api-ninjas.com/v1/riddles");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Add the API Key in the request header
            connection.setRequestProperty("X-Api-Key", API_KEY);
            connection.setRequestProperty("Accept", "application/json");

            // Get the response stream
            InputStream responseStream = connection.getInputStream();

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(responseStream));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse the JSON response
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = null;

            try {
                root = mapper.readTree(response.toString()); // This is where the exception might occur
            } catch (JsonProcessingException e) {
                System.err.println("Error processing JSON: " + e.getMessage());
                e.printStackTrace();
                return; // Exit if there's an issue processing the response
            }

            // Since the response is an array, we need to access the first element
            JsonNode firstRiddle = root.get(0); // Get the first riddle object

            // Extract the question and answer
            String riddle = firstRiddle.path("question").asText(); // Use "question" instead of "riddle"
            String answer = firstRiddle.path("answer").asText(); // Use "answer" as is
            System.out.println("Riddle: " + riddle);
            System.out.println("Answer: " + answer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
