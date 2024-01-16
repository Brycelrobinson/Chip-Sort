package ChipSort;

/*SortingAlgorithms
 * Authors: Bryce Robinson, Kameron Freeman
 * Professor Liao
 * CPS 240
 * Description: This class contains sorting algorithms and 
 * 				animations used to visualize sorting
 * 				
 */

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class SortingAlgorithms {

	private Boolean isSorting = false;
	private int num_bars = 20;
	private int speed = 200;
	private static Color barColor = Color.BLUE;
	private static  Color finalColor = Color.RED;
	private static Color iterColor = Color.GREEN;

	//GETTERS AND SETTERS
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int x) {
		speed = x;
	}
	
	public void setNumBars(int x) {
		num_bars = x;
	}
	
	public Boolean getIsSorting() {
		return isSorting;
	}
	
	
	public SortingAlgorithms() {
		
	}
	
	/**
	 * insertionSort
	 * Method to run insertion sort on bars array
	 */
    public void insertionSort() {

    	//only sort if not already sorting
    	if(isSorting == false) {
    	isSorting = true;


    	Thread animationThread = new Thread(() -> {

    	//Sorting Algorithm
    	//while(keepSorting) {
    	for (int i = 0; i < num_bars; i++) {
  
    		int j = i;

    		// change bar color to iterColor during while iterating
    		Bar.bars[j].setFill(iterColor);
    		// Move bars[j] into correct position
    		while (j > 0 && Bar.bars[j-1].getHeight() > Bar.bars[j].getHeight()) {

    		//Start the animation
    		animateSwap(j-1, j, speed);

    		//Pause the sorting algorithm for the duration of the animation
    		try {
    			Thread.sleep(speed + 50);
    		} catch (InterruptedException e) {

    			e.printStackTrace();
    		}
    		// Swap the bars
    		swapBars(j-1, j);
    		j--;
    		}

    	// set bar to final color after being placed
    	Bar.bars[j].setFill(finalColor);
    	
    	}

    	//set final bar to finalColor
    	Bar.bars[num_bars-1].setFill(finalColor);
    	isSorting = false;
    	UIController.getInsertionButton().setStyle(null);
    	});

    	animationThread.start();
    	}
    }
    
    /**
     * selectionSort
     * Method to perform Selection Sort and call animateSwap() method
     */
    public void selectionSort() {
    	//only sort if not already sorting
    	if(isSorting == false) {
	    	isSorting = true;
	        // Creates thread for sorting to separate from animation
	        Thread animationThread = new Thread(() -> {
	        	
	        	//Sorting Algorithm
	            for (int i = 0; i < num_bars - 1; i++) {
	                int minIndex = i;
	                for (int j = i + 1; j < num_bars; j++) {
	                	//change bar color to iterColor during while iterating
	                	Bar.bars[j].setFill(iterColor);
	                	
	                	//try-catch to sleep sorting thread to display iteration bar color
	                	 try {
	                         Thread.sleep(speed/3);
	                     } catch (InterruptedException e) {
	                         e.printStackTrace();
	                     }
	                	 
	                	 //sets bars back to barColor for next iteration
	                	 Bar.bars[j].setFill(barColor);
	                	 
	                	 //if current bar is shorter than minIndex, set minIndex and set bar to finalColor
	                    if (Bar.bars[j].getHeight() < Bar.bars[minIndex].getHeight()) {
	                    	Bar.bars[minIndex].setFill(barColor);
	                        minIndex = j;
	                        Bar.bars[j].setFill(finalColor);
	                    } 
	                }
	
	                if (minIndex != i) {
	                	
	                     //Start the animation
	                    animateSwap(i, minIndex, speed);
	                    
	                    //Pause the sorting algorithm for the duration of the animation
	                    try {
	                        Thread.sleep(speed+20);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                    
	                 //Swap the bars
	                    swapBars(i, minIndex);
	                    
	                }
	                
	                //set bar to final color after being placed
	                Bar.bars[i].setFill(finalColor);
	            }
	            
	            //set final bar to finalColor
	            Bar.bars[num_bars-1].setFill(finalColor);
	            isSorting = false;
	            UIController.getSelectionSortButton().setStyle(null);
	            
	        });
	
	        animationThread.start();
	    	
    	}
    }
    
    
    /**
     * bubbleSort
     * Method to perform Bubble Sort and call animateSwap() method
     */
    public void bubbleSort() {
    	//only sort if not already sorting
    	if(isSorting == false) {
    		isSorting = true;
	        Thread animationThread = new Thread(() -> {
	            for (int i = 0; i < num_bars - 1; i++) {
	                for (int j = 0; j < num_bars - i - 1; j++) {
	                    // change bar color to iterColor during while iterating
	                    Bar.bars[j].setFill(iterColor);
	                    Bar.bars[j + 1].setFill(iterColor);
	                    
	                    // pause sorting thread to display iteration bar color
	                    try {
	                        Thread.sleep(speed / 3);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                    
	                    // compare two adjacent bars and swap if necessary
	                    if (Bar.bars[j].getHeight() > Bar.bars[j + 1].getHeight()) {
	                        //Start the animation
	                        animateSwap(j, j + 1, speed/2);
	                        
	                        //Pause the sorting algorithm for the duration of the animation
	                        try {
	                            Thread.sleep(speed+20);
	                        } catch (InterruptedException e) {
	                            e.printStackTrace();
	                        }
	                        
	                        //Swap the bars
	                        swapBars(j, j + 1);
	                    }
	                    
	                    //sets bars back to barColor for next iteration
	                    Bar.bars[j].setFill(barColor);
	                    Bar.bars[j + 1].setFill(barColor);
	                }
	                // set bar to final color after being placed
	                Bar.bars[num_bars - i - 1].setFill(finalColor);
	            }
	            //set final bar to finalColor
	            Bar.bars[0].setFill(finalColor);
	            isSorting = false;
	            UIController.getBubbleSortButton().setStyle(null);
	        });
	
	        animationThread.start();
	        
    	}
    }
    
    
    /**
     * gnomeSort
     * Method to perform Gnome Sort and call animateSwap() method
     */
    public void gnomeSort() {
    	if(isSorting == false) {
    		isSorting = true;
    	
    		Thread animationThread = new Thread(() -> {
    			int index = 0;

    			while (index < num_bars) {

    				if (index == 0)
    					index++;
    				if (Bar.bars[index].getHeight() >= Bar.bars[index - 1].getHeight()) {
    					Bar.bars[index].setFill(finalColor);

    					index++;
                   // bars[index].setFill(finalColor);
    				}else {
    					Bar.bars[index].setFill(iterColor);
    					animateSwap(index, index-1, speed);
    					try {
    						Thread.sleep(speed + 50);
    					} catch (InterruptedException e) {
    						e.printStackTrace();
    					}
    					Bar.bars[index].setFill(barColor);
    					swapBars(index, index-1);
    					index--;

    				}

    				Bar.bars[0].setFill(finalColor); 
    				
    			}
    			isSorting = false;
				UIController.getGnomeSortButton().setStyle(null);
    		});
    		animationThread.start();
    	}
    }

 
    /**
     * swapBars
     * helper method for sorting to swap bars indexes
     */
    private void swapBars(int i, int j) {
    	Rectangle temp = Bar.bars[i];
    	Bar.bars[i] = Bar.bars[j];
    	Bar.bars[j] = temp;
    }
    
    /**
     * animateSwap
     * Animates the swapping of rectangle objects
     */
    private void animateSwap(int i, int j, int speed) {
    	
    	//get visual X position of both bars
    	double barOne = Bar.bars[i].localToScene(Bar.bars[i].getBoundsInLocal()).getMinX();
    	double barTwo = Bar.bars[j].localToScene(Bar.bars[j].getBoundsInLocal()).getMinX();
    	double diff = barTwo - barOne;
        
    	//Transition to animate swap
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(Bar.bars[i]);
        translate.setDuration(Duration.millis(speed));
        translate.setByX(diff);

        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(Bar.bars[j]);
        translate2.setDuration(Duration.millis(speed));
        translate2.setByX(-diff);
        
        //play animations
        translate.play();
        translate2.play();
       
   

    }
}