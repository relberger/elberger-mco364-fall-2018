package forecast;

import retrofit2.Call;
import retrofit2.http.GET;
//import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ForecastService
{
	@GET("http://api.openweathermap.org/data/2.5/forecast?&APPID=c62a04efaf47575752e10468810ee065&units=imperial")
	Call<ForecastFeedModel> getWeatherByZip(@Query("zip") String zip);
}
