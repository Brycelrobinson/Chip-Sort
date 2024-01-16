package ChipSort;

/*
 * Bar
 * Authors: Bryce Robinson, Kameron Freeman
 * Professor Liao
 * CPS 240
 * Description: This class colors and sizes Rectangle objects
 */

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bar extends BarShape{
	private double barWidth;
	private int SPACING = 5;
	
	
	// CONSTRUCTOR
	public Bar() {
		
		
	}
	
	
	/**
	 * colorAndSizeBars
	 * @param bars
	 * @param scWidth
	 * @param scHeight
	 * @param vboxWidth
	 * @return Rectangle array
	 * Method to add coloring and height declarations to bars
	 */
	public Rectangle[] colorAndSizeBars(Rectangle[] bars, double scWidth, double scHeight, double vboxWidth) {
		
		barWidth = ((scWidth - vboxWidth) - (num_bars - 1) * (SPACING* 2)) / num_bars;
        
        //loop to initialize bars and create rectangle objects
        for (int i = 0; i < num_bars; i++) {
            int barHeight = (int) (Math.random() * (scHeight-40) + 40);
            bars[i] = new Rectangle(i * (barWidth + SPACING),
                                     scHeight - barHeight,
                                     barWidth,
                                     barHeight);
            
            bars[i].setFill(Color.BLUE);
                       
        }
        
        double totalWidth = num_bars * barWidth + (num_bars - 1) * SPACING;
        double startX = (scWidth - totalWidth) / 2;
        for (int i = 0; i < num_bars; i++) {
            bars[i].setX(startX + i * (barWidth + SPACING));
        }
		
		
		
		return bars;
	}
	
	
}
