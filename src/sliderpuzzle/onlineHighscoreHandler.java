package sliderpuzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author nikalsh
 */
public class onlineHighscoreHandler {

    private String url = "http://nodejs.nikals.se/highscore/highscore.php";
    private ArrayList<String> highScoreList = new ArrayList<>();

    public onlineHighscoreHandler() throws MalformedURLException, IOException {
    }

    public void postNewHighScore(String registerHighScore) throws MalformedURLException, IOException {

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        try {
            OutputStreamWriter sw = new OutputStreamWriter(connection.getOutputStream());
            sw.write(registerHighScore);
            sw.flush();
            sw.close();

        } catch (IOException e) {
            System.out.println("Could not open connection " + e);
        }

        System.out.println(connection.getResponseCode());
        connection.disconnect();

    }

    public ArrayList<String> getHighScoreList() throws MalformedURLException, IOException {
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        String inputLine;

        connection.setRequestMethod("GET");

        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        System.out.println(connection.getResponseCode());

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));

        while ((inputLine = in.readLine()) != null) {
            highScoreList.add(inputLine);
        }

        in.close();
        connection.disconnect();

        return this.highScoreList;
    }

}
