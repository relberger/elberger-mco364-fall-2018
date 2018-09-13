package elberger.earthquake.net;

import com.google.inject.AbstractModule;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class EarthquakeModule extends AbstractModule
{

	@Override
	protected void configure()
	{
		super.configure();
		
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://earthquake.usgs.gov")
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.build();
		
		UsgsEarthquakeService service = retrofit.create(UsgsEarthquakeService.class);
			
		bind(UsgsEarthquakeService.class).toInstance(service);
	}
	

}
