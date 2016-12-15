import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class RacingCar extends JFrame {
	private CarPanel cp = new CarPanel ();
	public RacingCar() {
		add (cp);
	}
	
	public static void main (String [] args)  {

	RacingCar rc = new RacingCar ();
	rc.setSize (1000, 300) ;
	rc.setTitle ("Race Car");
	rc.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	rc.setLocationRelativeTo (null);
	rc.setVisible (true );
	}

}

class CarPanel extends JPanel {
	
	private int x;
	private int y = 100;
	private int [] xPoints = new int [4];
	private int [] yPoints = {y - 20, y - 30, y - 30, y - 20};
 
	public int getX () {
		return x;
	}
	
	public void setX (int x) {
		this.x = x;
	}
	
	public int getY () {
		return y;
	}
	
	public void setY (int y) {
		this.y = y;
	}

	public CarPanel () {
		Timer timer = new Timer ( 50, new TimerListener ());
		timer.start ();
	}

	protected void paintChildren (Graphics g) {
		super.paintChildren (g);
	}
	
	protected void paintborder (Graphics g) {
		super.paintBorder (g);
	}
	
	protected void paintComponent (Graphics g) {
		super.paintComponent (g);
		if (x> getWidth ()) {
			x = -20;
		}
		
		setX (getX () + 5);
		g.setColor (Color.BLACK);
		g.fillOval (x + 10, y - 10, 10, 10);
		g.fillOval (x + 30, y - 10, 10, 10);
		g.setColor (Color.YELLOW);
		g.fillRect (x, y - 20, 50, 10);
		g.setColor (Color.BLUE);
		
		for (int i = 1; i <= 4; i++) xPoints [i-1] = x + i * 10;
		g.fillPolygon (xPoints, yPoints, 4);
		System. out.println (x);

}

class TimerListener implements ActionListener {
	public void actionPerformed (ActionEvent e) {
		repaint ();
	}
}
}
