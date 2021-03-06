package elberger.earthquake.net;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
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

import static java.lang.Thread.sleep;

@Singleton
public class EarthquakeView  extends JFrame implements WindowListener
{
	/*private static Timer timer;
	private static final long serialVersionUID = 6111006689421939040L;
		private JTextField monthMag;
		private JTextField monthLoc;
		private JTextField weekMag;
		private JTextField weekLoc;
		private JTextField dayMag;
		private JTextField dayLoc;
		private JTextField hourMag;
		private JTextField hourLoc;*/
	private JTextField e1;
	private JTextField e2;
	private JTextField e3;
	private JTextField e4;
	private JTextField e5;

	public EarthquakeView()
	{
		setTitle("Largest Earthquakes");
		setSize(700, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel earthquakePanel = new JPanel();
		earthquakePanel.setLayout(new GridLayout(5, 1));

		e1 = new JTextField();
		e2 = new JTextField();
		e3 = new JTextField();
		e4 = new JTextField();
		e5 = new JTextField();

		earthquakePanel.add(e1);
		earthquakePanel.add(e2);
		earthquakePanel.add(e3);
		earthquakePanel.add(e4);
		earthquakePanel.add(e5);

		e1.setEditable(false);
		e2.setEditable(false);
		e3.setEditable(false);
		e4.setEditable(false);
		e5.setEditable(false);

		/*JLabel monthMagLabel = new JLabel("Past month magnitude:");
		JLabel monthLocLabel = new JLabel("Past month location:");
		JLabel weekMagLabel = new JLabel("Past week magnitude:");
		JLabel weekLocLabel = new JLabel("Past week location:");
		JLabel dayMagLabel = new JLabel("Past day magnitude:");
		JLabel dayLocLabel = new JLabel("Past day location:");
		JLabel hourMagLabel = new JLabel("Past hour magnitude:");
		JLabel hourLocLabel = new JLabel("Past hour location:");*/
		
		/*monthMag = new JTextField();
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
		hourLoc.setEditable(false);*/
		
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
							
							String monthMagValue = String.valueOf(greatestMonth.getCell().getProperties().getMag());
							String monthLocValue = String.valueOf(greatestMonth.getCell().getProperties().getPlace());
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
							
							String weekMagValue = String.valueOf(greatestWeek.getCell().getProperties().getMag());
							String weekLocValue = String.valueOf(greatestWeek.getCell().getProperties().getPlace());
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
					
					String dayMagValue = String.valueOf(greatestDay.getCell().getProperties().getMag());
					String dayLocValue = String.valueOf(greatestDay.getCell().getProperties().getPlace());
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
				
				String hourMagValue = String.valueOf(greatestHour.getCell().getProperties().getMag());
				String hourLocValue = String.valueOf(greatestHour.getCell().getProperties().getPlace());
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

	/*public JTextField getMonthMagTextField()
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
	}*/

	public JTextField getE1()
	{
		return e1;
	}

	public JTextField getE2()
	{
		return e2;
	}

	public JTextField getE3()
	{
		return e3;
	}

	public JTextField getE4()
	{
		return e4;
	}

	public JTextField getE5()
	{
		return e5;
	}

	public static void main(String[] args)
	{
		Injector injector = Guice.createInjector(new EarthquakeModule());
		
		EarthquakeView view = injector.getInstance(EarthquakeView.class);
		
		EarthquakeController controller = injector.getInstance(EarthquakeController.class);

		controller.refreshData();

		view.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosed(WindowEvent e)
			{
				//controller.stop();
			}
		});

		/*timer = new Timer(30000, (event) -> controller.refreshData());
		timer.setInitialDelay(0);
		timer.start();

		Thread thread = new Thread()
		{
			public void run()
			{
				controller.refreshData();
				try
				{
					sleep(30000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		};

		thread.start();*/

		view.setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e)
	{

	}

	@Override
	public void windowClosing(WindowEvent e)
	{

	}

	@Override
	public void windowClosed(WindowEvent e)
	{

	}

	@Override
	public void windowIconified(WindowEvent e)
	{

	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{

	}

	@Override
	public void windowActivated(WindowEvent e)
	{

	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{

	}
}
