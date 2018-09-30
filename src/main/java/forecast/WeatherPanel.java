package forecast;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WeatherPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JLabel time;
	private JLabel icon;
	private JLabel desc;
	private JLabel high;
	private JLabel low;
	
	public WeatherPanel()
	{
		this.time = new JLabel();
		this.icon = new JLabel();
		this.desc = new JLabel();
		this.high = new JLabel();
		this.low = new JLabel();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(time);
		this.add(icon);
		this.add(desc);
		this.add(high);
		this.add(low);
	}
	
	public JLabel getTime()
	{
		return time;
	}
	
	public JLabel getIcon()
	{
		return icon;
	}

	public JLabel getDesc()
	{
		return desc;
	}

	public JLabel getHigh()
	{
		return high;
	}

	public JLabel getLow()
	{
		return low;
	}
}
