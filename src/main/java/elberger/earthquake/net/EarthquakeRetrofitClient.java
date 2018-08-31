package elberger.earthquake.net;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;

import elberger.earthquake.Earthquake;
import elberger.earthquake.EarthquakeFeedModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EarthquakeRetrofitClient
{
	public static void main(String[] args) throws IOException
	{
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://earthquake.usgs.gov")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		UsgsEarthquakeService service = retrofit.create(UsgsEarthquakeService.class);
		
		Call<EarthquakeFeedModel> callMonth = service.getAllMonth();
			
		callMonth.enqueue(new Callback<EarthquakeFeedModel>()
				{
					@Override
					public void onResponse(Call<EarthquakeFeedModel> callMonth, Response<EarthquakeFeedModel> responseMonth)
					{
						EarthquakeFeedModel feedMonth = responseMonth.body();
						
						Optional<Earthquake> greatestMonth = feedMonth.getFeatures()
								.stream()
								.max(Comparator.comparing(e -> e.getProperties().getMag()));
							
							System.out.println("Month magnitude: " + greatestMonth.get().getProperties().getMag());
							System.out.println("Month location: " + greatestMonth.get().getProperties().getPlace());
					}
					
					@Override
					public void onFailure(Call<EarthquakeFeedModel> callMonth, Throwable t)
					{
						t.printStackTrace();
					}
				});
		

		Call<EarthquakeFeedModel> callWeek = service.getAllWeek();
		
		callWeek.enqueue(new Callback<EarthquakeFeedModel>()
				{
					@Override
					public void onResponse(Call<EarthquakeFeedModel> callWeek, Response<EarthquakeFeedModel> responseWeek)
					{
						EarthquakeFeedModel feedWeek = responseWeek.body();
						
						Optional<Earthquake> greatestWeek = feedWeek.getFeatures()
								.stream()
								.max(Comparator.comparing(e -> e.getProperties().getMag()));
							
							System.out.println("Week magnitude: "+ greatestWeek.get().getProperties().getMag());
							System.out.println("Week location: " + greatestWeek.get().getProperties().getPlace());
					}
					
					@Override
					public void onFailure(Call<EarthquakeFeedModel> callWeek, Throwable t)
					{
						t.printStackTrace();
					}
				});

		Call<EarthquakeFeedModel> callDay = service.getAllDay();
		
		callDay.enqueue(new Callback<EarthquakeFeedModel>()
				{
					@Override
					public void onResponse(Call<EarthquakeFeedModel> callDay, Response<EarthquakeFeedModel> responseDay)
					{
						EarthquakeFeedModel feedDay = responseDay.body();
						
						Optional<Earthquake> greatestDay = feedDay.getFeatures()
								.stream()
								.max(Comparator.comparing(e -> e.getProperties().getMag()));
							
							System.out.println("Day magnitude: " + greatestDay.get().getProperties().getMag());
							System.out.println("Day location: " + greatestDay.get().getProperties().getPlace());
					}
					
					@Override
					public void onFailure(Call<EarthquakeFeedModel> callDay, Throwable t)
					{
						t.printStackTrace();
					}
				});
		
		Call<EarthquakeFeedModel> callHour = service.getAllHour();
		
		callHour.enqueue(new Callback<EarthquakeFeedModel>()
				{
					@Override
					public void onResponse(Call<EarthquakeFeedModel> callHour, Response<EarthquakeFeedModel> responseHour)
					{
						EarthquakeFeedModel feedHour = responseHour.body();
						
						Optional<Earthquake> greatestHour = feedHour.getFeatures()
							.stream()
							.max(Comparator.comparing(e -> e.getProperties().getMag()));

						System.out.println("Hour magnitude: " + greatestHour.get().getProperties().getMag());
						System.out.println("Hour location: " + greatestHour.get().getProperties().getPlace());
					}
					
					@Override
					public void onFailure(Call<EarthquakeFeedModel> callHour, Throwable t)
					{
						t.printStackTrace();
					}
				});
	}	
}
