package leonoronhas.weatherapp;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class BackgroundRun extends AsyncTask<Void, Void, Void> {
    private String city;
    private String jsonData = "";

    BackgroundRun(String city) {
        this.city = city;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        String urlOpenW = "http://api.openweathermap.org/data/2.5/weather?";
        String test = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";

        String apiKey = "5c0ee6fc0e7c15065604f7c1215e0e5f";
        String query = urlOpenW + "q=" + city + "&apiKey=" + apiKey;

        //combine parts of url and create URL Object
        String urlC = urlOpenW + query;

        try {
            URL url = new URL(test);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while (line != null){
                line = bufferedReader.readLine();
                jsonData = jsonData +  line;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.data.setText(this.jsonData);
    }
    //    private MainActivity activity;
//    private MainActivity city;
//
//    private String urlOpenW = "http://api.openweathermap.org/data/2.5/weather?";
//
//    private String apiKey = "5c0ee6fc0e7c15065604f7c1215e0e5f";
//
//
//    private String query = urlOpenW + "q=" + city + "&apiKey=" + apiKey + "&units=metric";
//
//    //combine parts of url and create URL Object
//    private String urlC = urlOpenW + query;
//
//
//    BackgroundRun(MainActivity activity, MainActivity city) {
//        this.activity = activity;
//        this.city = city;
//    }
//
//    @Override
//    public void run() {
//        super.run();
//
//        HTTPHelper http = new HTTPHelper();
//        String jsonData = http.readHTTP(urlC);
//
//System.out.println("Run inside the background run");
//    }
}