package ChipSort;

/*PaneController
 * Authors: Bryce Robinson, Kameron Freeman
 * Professor Liao
 * CPS 240
 * Description: This class controls the Pane of our GUI
 */

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PaneController {
	
	//Instance Variables
	private static BorderPane root;
    private static Scene scene;
    private HBox barHBox;
    private static VBox vbox;
    
    private Button randomize;
    private Slider objectSlider;
    private Slider speedSlider;
    private Label speedLabel;
    private Label numOfObjectsLabel;
    private static Rectangle[] bars;

    //CLASS OBJECTS
    private UIController ui = new UIController();
    private static Bar b = new Bar();
    
    public PaneController() {
    	
    }
    
    
    public static BorderPane getRoot() {
    	return root;
    }
    
    public static void setRoot(BorderPane bp) {
    	root = bp;
    }
    
    public static Scene getScene() {
    	return scene;
    }
    
	
    /**
     * setScene
     * @param primaryStage
     * Method to create borderpane and align all child objects accordingly
     */
    public void setScene(Stage primaryStage) {
    	root = new BorderPane();
    	VBox topvbox = new VBox();
    	Label chipSort = new Label("ChipSort!");
    	
    	HBox hbox = addControlHBox();
    	chipSort.setFont(new Font("Times New Roman", 24));
    	topvbox.getChildren().addAll(chipSort,hbox);
    	topvbox.setAlignment(Pos.CENTER);
    	topvbox.setBackground((new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY,Insets.EMPTY))));
    	root.setTop(topvbox);
    	vbox = addVBox();
    	vbox.setBackground((new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY,Insets.EMPTY))));
    	root.setLeft(vbox);
    	
    	
        scene = new Scene(root, 600, 400);
        barHBox = addBarHBox();
    	root.setCenter(barHBox);
    	
    	
        primaryStage.setScene(scene);
        primaryStage.setTitle("ChipSort!");
        
        primaryStage.show();
    }
    
    /**
     * addControlHBox
     * @return HBox
     * used to create HBox for sorting algorithm buttons
     */
	private HBox addControlHBox() {

		
    	HBox hbox = new HBox(5);
    	
    	Button selectionSortButton = ui.createSelectionButton();
    	Button bubbleSortButton = ui.createBubbleButton();
    	Button insertionSortButton = ui.createInsertionButton();
    	Button quickSortButton = ui.createQuickButton();

    	
    	hbox.getChildren().addAll(selectionSortButton, bubbleSortButton, insertionSortButton, quickSortButton);
    
    	return hbox;
    	
    }
    
    /**
     * addBarHBox
     * @return HBox
     * Method to create HBox for the bars
     */
    public static HBox addBarHBox() {
    	HBox hbox = new HBox(2);
    	hbox.setAlignment(Pos.BOTTOM_CENTER);

    	bars = b.createBars();
    	b.colorAndSizeBars(bars, scene.getWidth(),scene.getHeight(), vbox.getWidth());
    	hbox.getChildren().addAll(bars);
               
        
        return hbox;
    	
    	
    	
    }
    
    /**
     * addVBox
     * @return VBox
     * VBox used to hold sliders and randomize button
     */
    private VBox addVBox() {
    	VBox vbox = new VBox(100);
    	VBox speedvbox = new VBox(10);
    	VBox objectsvbox = new VBox(10);
    	speedvbox.setAlignment(Pos.CENTER);
    	objectsvbox.setAlignment(Pos.CENTER);
    	
    	speedLabel = ui.createSpeedLabel();
    	numOfObjectsLabel = ui.createNumOfObjectsLabel();
    	
    	speedSlider = ui.createSpeedSlider();

    	objectSlider = ui.createObjectSlider();


    	
    	speedvbox.getChildren().addAll(speedLabel,speedSlider);
    	objectsvbox.getChildren().addAll(numOfObjectsLabel, objectSlider);
    	
    	randomize = ui.createRandomizeButton();   

        vbox.setAlignment(Pos.CENTER);    
    	vbox.getChildren().addAll(speedvbox,objectsvbox,randomize);
    	return vbox;
    }
}

