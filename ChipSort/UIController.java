package ChipSort;

/*UIController
 * Authors: Bryce Robinson, Kameron Freeman
 * Professor Liao
 * CPS 240
 * Description: This class creates buttons and adds action listeners
 */
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

public class UIController {

	private static Button insertionSortButton;
	private static Button selectionSortButton;
	private static Button bubbleSortButton;
	private static Button gnomeSortButton;
	private SortingAlgorithms sa = new SortingAlgorithms();

	public UIController() {

	}

	public static Button getInsertionButton() {
		return insertionSortButton;
	}

	public static Button getBubbleSortButton() {
		return bubbleSortButton;
	}

	public static Button getSelectionSortButton() {
		return selectionSortButton;
	}

	public static Button getGnomeSortButton() {
		return gnomeSortButton;
	}

	/**
	 * createSelectionButton
	 * 
	 * @return Button used to create Selection Sort Button
	 */
	public Button createSelectionButton() {
		selectionSortButton = new Button("Selection Sort");
		HBox.setHgrow(selectionSortButton, Priority.ALWAYS);
		selectionSortButton.setMaxWidth(Double.MAX_VALUE);

		selectionSortButton.setOnAction(e -> {
			if ((bubbleSortButton.getStyle() == "-fx-background-color: #00ff00")
					|| (insertionSortButton.getStyle() == "-fx-background-color: #00ff00")
					|| (gnomeSortButton.getStyle() == "-fx-background-color: #00ff00")) {

			} else {
				selectionSortButton.setStyle("-fx-background-color: #00ff00");
				sa.selectionSort();
			}

		});

		return selectionSortButton;
	}

	/**
	 * createBubbleButton
	 * 
	 * @return Button used to create Bubble Sort Button
	 */
	public Button createBubbleButton() {
		bubbleSortButton = new Button("Bubble Sort");
		HBox.setHgrow(bubbleSortButton, Priority.ALWAYS);
		bubbleSortButton.setMaxWidth(Double.MAX_VALUE);

		bubbleSortButton.setOnAction(e -> {
			if ((selectionSortButton.getStyle() == "-fx-background-color: #00ff00")
					|| (insertionSortButton.getStyle() == "-fx-background-color: #00ff00")
					|| (gnomeSortButton.getStyle() == "-fx-background-color: #00ff00")) {

			} else {
				bubbleSortButton.setStyle("-fx-background-color: #00ff00");
				sa.bubbleSort();
			}
		});

		return bubbleSortButton;
	}

	/**
	 * createInsertionButton
	 * 
	 * @return Button used to create Insertion Sort Button
	 */
	public Button createInsertionButton() {
		insertionSortButton = new Button("Insertion Sort");
		HBox.setHgrow(insertionSortButton, Priority.ALWAYS);
		insertionSortButton.setMaxWidth(Double.MAX_VALUE);

		insertionSortButton.setOnAction(e -> {
			if ((selectionSortButton.getStyle() == "-fx-background-color: #00ff00")
					|| (bubbleSortButton.getStyle() == "-fx-background-color: #00ff00")
					|| (gnomeSortButton.getStyle() == "-fx-background-color: #00ff00")) {

			} else {
				insertionSortButton.setStyle("-fx-background-color: #00ff00");
				sa.insertionSort();
			}
		});

		return insertionSortButton;
	}

	/**
	 * createQuickButton
	 * 
	 * @return Button used to create Gnome Sort Button
	 */
	public Button createQuickButton() {
		gnomeSortButton = new Button("Gnome Sort");
		HBox.setHgrow(gnomeSortButton, Priority.ALWAYS);
		gnomeSortButton.setMaxWidth(Double.MAX_VALUE);

		gnomeSortButton.setOnAction(e -> {
			if ((selectionSortButton.getStyle() == "-fx-background-color: #00ff00")
					|| (bubbleSortButton.getStyle() == "-fx-background-color: #00ff00")
					|| (insertionSortButton.getStyle() == "-fx-background-color: #00ff00")) {

			} else {
				gnomeSortButton.setStyle("-fx-background-color: #00ff00");
				sa.gnomeSort();
			}
		});

		return gnomeSortButton;
	}

	/**
	 * createSpeedLabel
	 * 
	 * @return Label
	 */
	public Label createSpeedLabel() {
		Label speedLabel = new Label("Adjust Sorting Speed");
		return speedLabel;
	}

	/**
	 * createNumOfObjectsLabel
	 * 
	 * @return Label creates label for the number of objects slider
	 */
	public Label createNumOfObjectsLabel() {
		Label numOfObjectsLabel = new Label("Adjust # of Objects");
		return numOfObjectsLabel;
	}

	/**
	 * createSpeedSlider
	 * 
	 * @return Slider Method to create the slider for altering speed of animations
	 */
	public Slider createSpeedSlider() {
		Slider speedSlider = new Slider();
		speedSlider.setMin(20);
		speedSlider.setMax(1000);

		speedSlider.setValue(sa.getSpeed());
		speedSlider.valueProperty().addListener(new ChangeListener<Number>() {

			public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {

				if (sa.getIsSorting()) {

				} else {
					sa.setSpeed(newValue.intValue());
				}
			}

		});

		return speedSlider;
	}

	/**
	 * createObjectSlider
	 * 
	 * @return Slider Method to create slider to alter number of rectangles
	 */
	public Slider createObjectSlider() {
		Slider objectSlider = new Slider();
		objectSlider.setMin(0);
		objectSlider.setMax(40);

		objectSlider.setValue(Bar.num_bars);
		objectSlider.valueProperty().addListener(new ChangeListener<Number>() {

			public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {

				if (sa.getIsSorting()) {

				} else {
					Bar.num_bars = (newValue.intValue());
					sa.setNumBars(newValue.intValue());
					HBox barHBox = PaneController.addBarHBox();
					PaneController.getRoot().setCenter(barHBox);
				}
			}

		});

		return objectSlider;

	}

	/**
	 * createRandomizeButton
	 * 
	 * @return Button
	 * Creates button to call randomizeBars Method
	 */
	public Button createRandomizeButton() {
		Button randomize = new Button("Randomize");
		randomize.setOnAction(e -> randomizeBars());
		return randomize;
	}

	/**
	 * randomizeBars
	 * Method to randomize the height of the bars
	 */
	private void randomizeBars() {
		// only randomize if not sorting
		if (sa.getIsSorting() == false) {
			for (int i = 0; i < Bar.num_bars; i++) {
				int barHeight = (int) (Math.random() * (PaneController.getScene().getHeight() - 40) + 40);
				Bar.bars[i].setHeight(barHeight);
				Bar.bars[i].setFill(Color.BLUE);
			}

		}
	}

}