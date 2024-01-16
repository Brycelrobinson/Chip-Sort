package ChipSort;

/*ChipSort
 * Authors: Bryce Robinson, Kameron Freeman
 * Professor Liao
 * CPS 240
 * Description: This class creates and runs our ChipSort Program.
 * 				It makes visualizing sorting algorithms easy.
 */

import javafx.application.Application;
import javafx.stage.Stage;


public class ChipSort extends Application {

	//creates PaneController object
	private PaneController pc = new PaneController();
	
	//start
    @Override
    public void start(Stage primaryStage) {
        pc.setScene(primaryStage);
    }
      
    //main
    public static void main(String[] args) {
    	launch(args);
    }

}
