package elberger.earthquake;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.function.Predicate;

import com.google.gson.*;
public class EarthquakeReader
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Gson gson = new Gson();
		
		BufferedReader in = new BufferedReader 
				(new FileReader(new File("src/elberger/earthquake/all_month.geojson")));
		
		EarthquakeFeedModel feed = gson.fromJson(in, EarthquakeFeedModel.class);
		
		System.out.println(feed.getFeatures()
									.stream()
									.filter(e -> e.getProperties().getMag() >= 5)
									.count());
	}

}
