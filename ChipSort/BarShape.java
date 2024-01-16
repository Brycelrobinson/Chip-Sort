package ChipSort;

/*BarShape
 * Authors: Bryce Robinson, Kameron Freeman
 * Professor Liao
 * CPS 240
 * Description: This class creates arrays of Rectangle
 */
import javafx.scene.shape.Rectangle;

public class BarShape extends Rectangle{

	protected static Rectangle[] bars;
	protected static int num_bars = 20;
	
	public BarShape() {
		
	}
	/**
	 * setNumBars
	 * @param x
	 * setter method to change number of bars
	 */
	public void setNumBars(int x) {
		num_bars = x;
	}
	
	/**
	 * createBars
	 * @return Rectangle array
	 * method to add rectangle objects to bars array
	 */
	public Rectangle[] createBars() {		
        bars = new Rectangle[num_bars];
		return bars;	
	}
	

	
}

