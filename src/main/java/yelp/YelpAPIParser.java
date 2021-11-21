package yelp;

import com.google.gson.*;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Interfaces with the Yelp API and deserializes JSON results.
 * @author Thomas Peters
 */
public class YelpAPIParser {
	
	private static final String API_KEY = "6GWN8BWsSv53vOxwAEqW-L3LQ2sObaOZg5NYWuWyuHlP-HWs4oUkRZpILmSB5Pssq8MTkKUIkvX9z28aiHdG5IWW7vjpqQKnI6Q_1ppfgL19feg_OCH_yqnOhGeEYXYx";
	
	/**
	 * Queries the Yelp API to search for the top 10 best restaurant matches.
	 * @param restaurant Name of the restaurant to search for.
	 * @param location Location to search for restaurants nearby.
	 * @return list of 10 restaurants.
	 */
    public static List<Restaurant> searchRestaurants(String restaurant, String location) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder().build();
            String builder = "https://api.yelp.com/v3/businesses/search" + "?term=" + restaurant 
            		+ "&location=" + location
            		+ "&limit=10";
            Request request = new Request.Builder().url(builder).method("GET", null).addHeader(
                    "Authorization",
                    "Bearer " + API_KEY)
                    .build();
            Response response = client.newCall(request).execute();

            String responseString = Objects.requireNonNull(response.body()).string();
            if (responseString.contains("error")){
              System.out.println("Yelp API Failure.");
              return null;
            }
            
            JsonElement content = JsonParser.parseString(responseString).getAsJsonObject().getAsJsonArray("businesses");
            List<Restaurant> restaurants = Arrays.asList(new Gson().fromJson(content, Restaurant[].class));
            return restaurants;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }
}
