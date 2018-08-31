package elberger.earthquake.net;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;

@Singleton
public class EarthquakeView3 extends JFrame //implements WindowListener
{
	private static final long serialVersionUID = 6111006689421939040L;
	private JTextField hourMag1;
	private JTextField hourLoc1;

	public EarthquakeView3()
	{
		setTitle("Largest Earthquakes");
		setSize(700, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel earthquakePanel = new JPanel();
		earthquakePanel.setLayout(new GridLayout(8, 2));
		
		JLabel hourMagLabel1 = new JLabel("Past hour magnitude 1:");
		JLabel hourLocLabel1 = new JLabel("Past hour location 1:");
		
		hourMag1 = new JTextField();
		hourLoc1 = new JTextField();
		
		earthquakePanel.add(hourMagLabel1);
		earthquakePanel.add(hourMag1);
		earthquakePanel.add(hourLocLabel1);
		earthquakePanel.add(hourLoc1);
		
		hourMag1.setEditable(false);
		hourLoc1.setEditable(false);
		
		panel.add(earthquakePanel, BorderLayout.CENTER);
		
		add(panel);
	}

	public JTextComponent getHourMagTextField()
	{
		return hourMag1;
	}

	public JTextComponent getHourLocTextField()
	{
		return hourLoc1;
	}
	
	public static void main(String[] args)
	{
		Injector injector = Guice.createInjector(new EarthquakeModule());
		
		EarthquakeView3 view = injector.getInstance(EarthquakeView3.class);
		
		EarthquakeController3 controller = injector.getInstance(EarthquakeController3.class);
		
		controller.refreshData();

		view.setVisible(true);
	}
}
