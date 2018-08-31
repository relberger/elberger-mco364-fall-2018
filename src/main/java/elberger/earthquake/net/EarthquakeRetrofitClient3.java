package elberger.earthquake.net;

import elberger.earthquake.Earthquake;
import elberger.earthquake.EarthquakeFeedModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class EarthquakeRetrofitClient3
{
	public static void main(String[] args) throws IOException
	{
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://earthquake.usgs.gov")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		UsgsEarthquakeService service = retrofit.create(UsgsEarthquakeService.class);
		
		Call<EarthquakeFeedModel> callHour = service.getAllHour();

		callHour.enqueue(new Callback<EarthquakeFeedModel>()
				{
					@Override
					public void onResponse(Call<EarthquakeFeedModel> callHour, Response<EarthquakeFeedModel> responseHour)
					{
						EarthquakeFeedModel feedHour = responseHour.body();
						
						Stream<Earthquake> greatestHour = feedHour.getFeatures()
							.stream()
							.filter(e -> e.getProperties().getMag() >= 3);
					}
					
					@Override
					public void onFailure(Call<EarthquakeFeedModel> callHour, Throwable t)
					{
						t.printStackTrace();
					}
				});
	}	
}
