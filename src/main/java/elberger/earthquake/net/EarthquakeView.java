package elberger.earthquake.net;

import java.awt.BorderLayout;
import java.awt.GridLayout;
/*import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Comparator;
import java.util.Optional;
*/
import javax.swing.*;
import javax.swing.text.JTextComponent;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;

import elberger.earthquake.Earthquake;
/*import elberger.earthquake.Earthquake;
import elberger.earthquake.EarthquakeFeed;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;*/
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class EarthquakeView extends JFrame //implements WindowListener
{
	private static final long serialVersionUID = 6111006689421939040L;
	private JTextField monthMag;
	private JTextField monthLoc;
	private JTextField weekMag;
	private JTextField weekLoc;
	private JTextField dayMag;
	private JTextField dayLoc;
	private JTextField hourMag;
	private JTextField hourLoc;
	
	public EarthquakeView()
	{
		setTitle("Largest Earthquakes");
		setSize(700, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel earthquakePanel = new JPanel();
		earthquakePanel.setLayout(new GridLayout(8, 2));
		
		JLabel monthMagLabel = new JLabel("Past month magnitude:");
		JLabel monthLocLabel = new JLabel("Past month location:");
		JLabel weekMagLabel = new JLabel("Past week magnitude:");
		JLabel weekLocLabel = new JLabel("Past week location:");
		JLabel dayMagLabel = new JLabel("Past day magnitude:");
		JLabel dayLocLabel = new JLabel("Past day location:");
		JLabel hourMagLabel = new JLabel("Past hour magnitude:");
		JLabel hourLocLabel = new JLabel("Past hour location:");
		
		monthMag = new JTextField();
		monthLoc = new JTextField();
		weekMag = new JTextField();
		weekLoc = new JTextField();
		dayMag = new JTextField();
		dayLoc = new JTextField();
		hourMag = new JTextField();
		hourLoc = new JTextField();
		
		earthquakePanel.add(monthMagLabel);
		earthquakePanel.add(monthMag);
		earthquakePanel.add(monthLocLabel);
		earthquakePanel.add(monthLoc);
		earthquakePanel.add(weekMagLabel);
		earthquakePanel.add(weekMag);
		earthquakePanel.add(weekLocLabel);
		earthquakePanel.add(weekLoc);
		earthquakePanel.add(dayMagLabel);
		earthquakePanel.add(dayMag);
		earthquakePanel.add(dayLocLabel);
		earthquakePanel.add(dayLoc);		
		earthquakePanel.add(hourMagLabel);
		earthquakePanel.add(hourMag);
		earthquakePanel.add(hourLocLabel);
		earthquakePanel.add(hourLoc);		
		
		monthMag.setEditable(false);
		monthLoc.setEditable(false);		
		weekMag.setEditable(false);
		weekLoc.setEditable(false);
		dayMag.setEditable(false);
		dayLoc.setEditable(false);
		hourMag.setEditable(false);
		hourLoc.setEditable(false);
		
//		addWindowListener(this);
		
		panel.add(earthquakePanel, BorderLayout.CENTER);
		
		add(panel);
	}

/*	public void getMonthValues()
	{
		Call<EarthquakeFeed> callMonth = service.getAllMonth();
		callMonth.enqueue(new Callback<EarthquakeFeed>()
				{
					@Override
					public void onResponse(Call<EarthquakeFeed> callMonth, Response<EarthquakeFeed> responseMonth)
					{
						EarthquakeFeed feedMonth = responseMonth.body();
						
						Optional<Earthquake> greatestMonth = feedMonth.getFeatures()
								.stream()
								.max(Comparator.comparing(e -> e.getProperties().getMag()));
							
							String monthMagValue = String.valueOf(greatestMonth.get().getProperties().getMag());
							String monthLocValue = String.valueOf(greatestMonth.get().getProperties().getPlace());
							monthMag.setText(monthMagValue);
							monthLoc.setText(monthLocValue);
					}
					
					@Override
					public void onFailure(Call<EarthquakeFeed> callMonth, Throwable t)
					{
						t.printStackTrace();
					}
				});
	}
	
	public void getWeekValues()
	{
		Call<EarthquakeFeed> callWeek = service.getAllWeek();
		callWeek.enqueue(new Callback<EarthquakeFeed>()
				{
					@Override
					public void onResponse(Call<EarthquakeFeed> callWeek, Response<EarthquakeFeed> responseWeek)
					{
						EarthquakeFeed feedWeek = responseWeek.body();
						
						Optional<Earthquake> greatestWeek = feedWeek.getFeatures()
								.stream()
								.max(Comparator.comparing(e -> e.getProperties().getMag()));
							
							String weekMagValue = String.valueOf(greatestWeek.get().getProperties().getMag());
							String weekLocValue = String.valueOf(greatestWeek.get().getProperties().getPlace());
							weekMag.setText(weekMagValue);
							weekLoc.setText(weekLocValue);
					}
					
					@Override
					public void onFailure(Call<EarthquakeFeed> callMonth, Throwable t)
					{
						t.printStackTrace();
					}
				});
	}
	
	public void getDayValues()
	{
		Call<EarthquakeFeed> callDay = service.getAllDay();
		callDay.enqueue(new Callback<EarthquakeFeed>()
		{
			@Override
			public void onResponse(Call<EarthquakeFeed> callDay, Response<EarthquakeFeed> responseDay)
			{
				EarthquakeFeed feedDay = responseDay.body();
				
				Optional<Earthquake> greatestDay = feedDay.getFeatures()
						.stream()
						.max(Comparator.comparing(e -> e.getProperties().getMag()));
					
					String dayMagValue = String.valueOf(greatestDay.get().getProperties().getMag());
					String dayLocValue = String.valueOf(greatestDay.get().getProperties().getPlace());
					dayMag.setText(dayMagValue);
					dayLoc.setText(dayLocValue);
			}
			
			@Override
			public void onFailure(Call<EarthquakeFeed> callDay, Throwable t)
			{
				t.printStackTrace();
			}
		});
	}
	
	public void getHourValues()
	{
		Call<EarthquakeFeed> callHour = service.getAllHour();
		callHour.enqueue(new Callback<EarthquakeFeed>()
		{
			@Override
			public void onResponse(Call<EarthquakeFeed> callHour, Response<EarthquakeFeed> responseHour)
			{
				EarthquakeFeed feedHour = responseHour.body();
				
				Optional<Earthquake> greatestHour = feedHour.getFeatures()
					.stream()
					.max(Comparator.comparing(e -> e.getProperties().getMag()));
				
				String hourMagValue = String.valueOf(greatestHour.get().getProperties().getMag());
				String hourLocValue = String.valueOf(greatestHour.get().getProperties().getPlace());
				hourMag.setText(hourMagValue);
				hourLoc.setText(hourLocValue);
			}
			
			@Override
			public void onFailure(Call<EarthquakeFeed> callHour, Throwable t)
			{
				t.printStackTrace();
			}
		});
		
	}*/

	public JTextField getMonthMagTextField()
	{
		return monthMag;
	}

	public JTextField getMonthLocTextField()
	{
		return monthLoc;
	}


	public JTextField getWeekMagTextField()
	{
		return weekMag;
	}

	public JTextField getWeekLocTextField()
	{
		return weekLoc;
	}

	public JTextField getDayMagTextField()
	{
		return dayMag;
	}

	public JTextComponent getDayLocTextField()
	{
		return dayLoc;
	}

	public JTextComponent getHourMagTextField()
	{
		return hourMag;
	}

	public JTextComponent getHourLocTextField()
	{
		return hourLoc;
	}
	
	public static void main(String[] args)
	{
		Injector injector = Guice.createInjector(new EarthquakeModule());
		
		EarthquakeView view = injector.getInstance(EarthquakeView.class);
		
		EarthquakeController controller = injector.getInstance(EarthquakeController.class);
		
		controller.refreshData();

		view.setVisible(true);
	}
}
