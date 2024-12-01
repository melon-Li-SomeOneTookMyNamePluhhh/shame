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

    private static final String API_KEY = "your_api_key_here";

    // Method to fetch the riddle and answer
    public static String[] fetchRiddleAndAnswer() {
        try {
            // Set the API URL for riddles
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
            JsonNode root = mapper.readTree(response.toString());

            // Since the response is an array, get the first riddle object
            JsonNode firstRiddle = root.get(0);

            // Extract the question (riddle) and answer
            String riddle = firstRiddle.path("question").asText();
            String answer = firstRiddle.path("answer").asText();

            // Return both riddle and answer in an array
            return new String[]{riddle, answer};

        } catch (Exception e) {
            e.printStackTrace();
            return new String[]{"No riddle found", "No answer found"};
        }
    }
}


