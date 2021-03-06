package application;

import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Formelrad Application
 * 
 * @author Peter Rutschmann
 * @version 22.10.2018
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();

			// Creating an image
			Image image = new Image(getClass().getResourceAsStream("formelradelektronik.gif"));
			ImageView imageView = new ImageView(image);
			imageView.setX(10);
			imageView.setY(10);
			imageView.setFitHeight(300);
			imageView.setFitWidth(300);
			imageView.setPreserveRatio(true);
			root.getChildren().add(imageView);

			Label lbleistung = new Label("Leistung:");
			lbleistung.relocate(10, 285);
			lbleistung.setFont(Font.font(15));
			root.getChildren().add(lbleistung);

			final Pattern pattern = Pattern.compile("^\\d*\\.?\\d*$");
			final TextField txLeistung = new TextField() {
				@Override
				public void replaceText(int start, int end, String text) {
					String newText = getText().substring(0, start) + text + getText().substring(end);
					if (pattern.matcher(newText).matches()) {
						super.replaceText(start, end, text);
					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Input Error");
						alert.setHeaderText("ERROR: Invalid Format");
						alert.setContentText("Please make sure you only add numbers and one dot");
						alert.showAndWait();
					}
				}
			};
			txLeistung.relocate(100, 285);
			txLeistung.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txLeistung);

			Label lblSpannung = new Label("Spannung:");
			lblSpannung.relocate(10, 325);
			lblSpannung.setFont(Font.font(15));
			root.getChildren().add(lblSpannung);

			final TextField txSpannung = new TextField() {
				@Override
				public void replaceText(int start, int end, String text) {
					String newText = getText().substring(0, start) + text + getText().substring(end);
					if (pattern.matcher(newText).matches()) {
						super.replaceText(start, end, text);
					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Input Error");
						alert.setHeaderText("ERROR: Invalid Format");
						alert.setContentText("Please make sure you only add numbers and one dot");
						alert.showAndWait();
					}
				}
			};
			txSpannung.relocate(100, 325);
			txSpannung.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txSpannung);

			Label lblStrom = new Label("Strom:");
			lblStrom.relocate(10, 365);
			lblStrom.setFont(Font.font(15));
			root.getChildren().add(lblStrom);

			final TextField txStrom = new TextField() {
				@Override
				public void replaceText(int start, int end, String text) {
					String newText = getText().substring(0, start) + text + getText().substring(end);
					if (pattern.matcher(newText).matches()) {
						super.replaceText(start, end, text);
					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Input Error");
						alert.setHeaderText("ERROR: Invalid Format");
						alert.setContentText("Please make sure you only add numbers and one dot");
						alert.showAndWait();
					}
				}
			};
			txStrom.relocate(100, 365);
			txStrom.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txStrom);

			Label lblWiderstand = new Label("Widerstand:");
			lblWiderstand.relocate(10, 405);
			lblWiderstand.setFont(Font.font(15));
			root.getChildren().add(lblWiderstand);

			final TextField txWiderstand = new TextField() {
				@Override
				public void replaceText(int start, int end, String text) {
					String newText = getText().substring(0, start) + text + getText().substring(end);
					if (pattern.matcher(newText).matches()) {
						super.replaceText(start, end, text);
					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Input Error");
						alert.setHeaderText("ERROR: Invalid Format");
						alert.setContentText("Please make sure you only add numbers and one dot");
						alert.showAndWait();
					}
				}
			};
			txWiderstand.relocate(100, 405);
			txWiderstand.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txWiderstand);
			
			Button btnBerechnen = new Button();
			btnBerechnen.relocate(220, 445);
			btnBerechnen.setText(" Berechnen ");
			root.getChildren().addAll(btnBerechnen);
			
			Label lblRechnungLeistung = new Label("");
			lblRechnungLeistung.relocate(8, 475);
			lblRechnungLeistung.setFont(Font.font(12));
			root.getChildren().add(lblRechnungLeistung);

			Label lblRechnungSpannung = new Label("");
			lblRechnungSpannung.relocate(8, 490);
			lblRechnungSpannung.setFont(Font.font(12));
			root.getChildren().add(lblRechnungSpannung);
			
			Label lblRechnungStrom = new Label("");
			lblRechnungStrom.relocate(8, 505);
			lblRechnungStrom.setFont(Font.font(12));
			root.getChildren().add(lblRechnungStrom);

			Label lblRechnungWiderstand = new Label("");
			lblRechnungWiderstand.relocate(8, 520);
			lblRechnungWiderstand.setFont(Font.font(12));
			root.getChildren().add(lblRechnungWiderstand);

			btnBerechnen.setOnAction(e -> {
				btnBerechnen.isDefaultButton();
				double power = 0.0;
				double tension = 0.0;
				double current = 0.0;
				double resistence = 0.0;

				if (txLeistung.getText().isEmpty() == true & txSpannung.getText().isEmpty() == true
						& txStrom.getText().isEmpty() == true & txWiderstand.getText().isEmpty() == true) {

					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Input Error");
					alert.setHeaderText("ERROR: No Input");
					alert.setContentText("Please make sure you fill out 2 fields");
					alert.showAndWait();
				} else {

					if (txLeistung.getText().isEmpty() == false) {
						power = Double.parseDouble(txLeistung.getText());
					}

					else {
						txLeistung.setStyle("-fx-text-inner-color: red;");
					}
					if (txSpannung.getText().isEmpty() == false) {
						tension = Double.parseDouble(txSpannung.getText());
					}

					else {
						txSpannung.setStyle("-fx-text-inner-color: red;");
					}
					if (txStrom.getText().isEmpty() == false) {
						current = Double.parseDouble(txStrom.getText());
					}

					else {
						txStrom.setStyle("-fx-text-inner-color: red;");
					}

					if (txWiderstand.getText().isEmpty() == false) {
						resistence = Double.parseDouble(txWiderstand.getText());
					}

					else {
						txWiderstand.setStyle("-fx-text-inner-color: red;");
					}

					Calculator myCalculator = new Calculator(power, tension, current, resistence);

					
					myCalculator.calculate();
					txLeistung.setText(Double.toString(myCalculator.getLeistung()));
					txSpannung.setText(Double.toString(myCalculator.getSpannung()));
					txStrom.setText(Double.toString(myCalculator.getStrom()));
					txWiderstand.setText(Double.toString(myCalculator.getWiderstand()));				
					
					lblRechnungSpannung.setText(myCalculator.getRechnungSpannung());				
					lblRechnungStrom.setText(myCalculator.getRechnungStrom());	
					lblRechnungLeistung.setText(myCalculator.getRechnungLeistung());					
					lblRechnungWiderstand.setText(myCalculator.getRechnungWiderstand());
					
				
				}
			});

			txLeistung.setOnKeyPressed(event -> {
				switch (event.getCode()) {
				case ENTER:
					double power = 0.0;
					double tension = 0.0;
					double current = 0.0;
					double resistence = 0.0;

					if (txLeistung.getText().isEmpty() == true & txSpannung.getText().isEmpty() == true
							& txStrom.getText().isEmpty() == true & txWiderstand.getText().isEmpty() == true) {

						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Input Error");
						alert.setHeaderText("ERROR: No Input");
						alert.setContentText("Please make sure you fill out 2 fields");
						alert.showAndWait();
					} else {
						if (txLeistung.getText().isEmpty() == false) {
							power = Double.parseDouble(txLeistung.getText());
						}

						else {
							txLeistung.setStyle("-fx-text-inner-color: red;");
						}
						if (txSpannung.getText().isEmpty() == false) {
							tension = Double.parseDouble(txSpannung.getText());
						}

						else {
							txSpannung.setStyle("-fx-text-inner-color: red;");
						}
						if (txStrom.getText().isEmpty() == false) {
							current = Double.parseDouble(txStrom.getText());
						}

						else {
							txStrom.setStyle("-fx-text-inner-color: red;");
						}

						if (txWiderstand.getText().isEmpty() == false) {
							resistence = Double.parseDouble(txWiderstand.getText());
						}

						else {
							txWiderstand.setStyle("-fx-text-inner-color: red;");
						}

						Calculator myCalculator = new Calculator(power, tension, current, resistence);

						myCalculator.calculate();
						txLeistung.setText(Double.toString(myCalculator.getLeistung()));
						txSpannung.setText(Double.toString(myCalculator.getSpannung()));
						txStrom.setText(Double.toString(myCalculator.getStrom()));
						txWiderstand.setText(Double.toString(myCalculator.getWiderstand()));
						
						lblRechnungSpannung.setText(myCalculator.getRechnungSpannung());				
						lblRechnungStrom.setText(myCalculator.getRechnungStrom());	
						lblRechnungLeistung.setText(myCalculator.getRechnungLeistung());					
						lblRechnungWiderstand.setText(myCalculator.getRechnungWiderstand());
					}
				}
			});

			txStrom.setOnKeyPressed(event -> {
				switch (event.getCode()) {
				case ENTER:
					double power = 0.0;
					double tension = 0.0;
					double current = 0.0;
					double resistence = 0.0;

					if (txLeistung.getText().isEmpty() == true & txSpannung.getText().isEmpty() == true
							& txStrom.getText().isEmpty() == true & txWiderstand.getText().isEmpty() == true) {

						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Input Error");
						alert.setHeaderText("ERROR: No Input");
						alert.setContentText("Please make sure you fill out 2 fields");
						alert.showAndWait();
					} else {
						if (txLeistung.getText().isEmpty() == false) {
							power = Double.parseDouble(txLeistung.getText());
						}

						else {
							txLeistung.setStyle("-fx-text-inner-color: red;");
						}
						if (txSpannung.getText().isEmpty() == false) {
							tension = Double.parseDouble(txSpannung.getText());
						}

						else {
							txSpannung.setStyle("-fx-text-inner-color: red;");
						}
						if (txStrom.getText().isEmpty() == false) {
							current = Double.parseDouble(txStrom.getText());
						}

						else {
							txStrom.setStyle("-fx-text-inner-color: red;");
						}

						if (txWiderstand.getText().isEmpty() == false) {
							resistence = Double.parseDouble(txWiderstand.getText());
						}

						else {
							txWiderstand.setStyle("-fx-text-inner-color: red;");
						}

						Calculator myCalculator = new Calculator(power, tension, current, resistence);

						myCalculator.calculate();
						txLeistung.setText(Double.toString(myCalculator.getLeistung()));
						txSpannung.setText(Double.toString(myCalculator.getSpannung()));
						txStrom.setText(Double.toString(myCalculator.getStrom()));
						txWiderstand.setText(Double.toString(myCalculator.getWiderstand()));
						
						lblRechnungSpannung.setText(myCalculator.getRechnungSpannung());				
						lblRechnungStrom.setText(myCalculator.getRechnungStrom());	
						lblRechnungLeistung.setText(myCalculator.getRechnungLeistung());					
						lblRechnungWiderstand.setText(myCalculator.getRechnungWiderstand());
					}
				}
			});

			txSpannung.setOnKeyPressed(event -> {
				switch (event.getCode()) {
				case ENTER:
					double power = 0.0;
					double tension = 0.0;
					double current = 0.0;
					double resistence = 0.0;

					if (txLeistung.getText().isEmpty() == true & txSpannung.getText().isEmpty() == true
							& txStrom.getText().isEmpty() == true & txWiderstand.getText().isEmpty() == true) {

						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Input Error");
						alert.setHeaderText("ERROR: No Input");
						alert.setContentText("Please make sure you fill out 2 fields");
						alert.showAndWait();
					} else {
						if (txLeistung.getText().isEmpty() == false) {
							power = Double.parseDouble(txLeistung.getText());
						}

						else {
							txLeistung.setStyle("-fx-text-inner-color: red;");
						}
						if (txSpannung.getText().isEmpty() == false) {
							tension = Double.parseDouble(txSpannung.getText());
						}

						else {
							txSpannung.setStyle("-fx-text-inner-color: red;");
						}
						if (txStrom.getText().isEmpty() == false) {
							current = Double.parseDouble(txStrom.getText());
						}

						else {
							txStrom.setStyle("-fx-text-inner-color: red;");
						}

						if (txWiderstand.getText().isEmpty() == false) {
							resistence = Double.parseDouble(txWiderstand.getText());
						}

						else {
							txWiderstand.setStyle("-fx-text-inner-color: red;");
						}

						Calculator myCalculator = new Calculator(power, tension, current, resistence);

						myCalculator.calculate();
						txLeistung.setText(Double.toString(myCalculator.getLeistung()));
						txSpannung.setText(Double.toString(myCalculator.getSpannung()));
						txStrom.setText(Double.toString(myCalculator.getStrom()));
						txWiderstand.setText(Double.toString(myCalculator.getWiderstand()));
						
						lblRechnungSpannung.setText(myCalculator.getRechnungSpannung());				
						lblRechnungStrom.setText(myCalculator.getRechnungStrom());	
						lblRechnungLeistung.setText(myCalculator.getRechnungLeistung());					
						lblRechnungWiderstand.setText(myCalculator.getRechnungWiderstand());
					}
				}
			});

			txWiderstand.setOnKeyPressed(event -> {
				switch (event.getCode()) {
				case ENTER:
					double power = 0.0;
					double tension = 0.0;
					double current = 0.0;
					double resistence = 0.0;

					if (txLeistung.getText().isEmpty() == true & txSpannung.getText().isEmpty() == true
							& txStrom.getText().isEmpty() == true & txWiderstand.getText().isEmpty() == true) {

						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Input Error");
						alert.setHeaderText("ERROR: No Input");
						alert.setContentText("Please make sure you fill out 2 fields");
						alert.showAndWait();
					} else {
						if (txLeistung.getText().isEmpty() == false) {
							power = Double.parseDouble(txLeistung.getText());
						}

						else {
							txLeistung.setStyle("-fx-text-inner-color: red;");
						}
						if (txSpannung.getText().isEmpty() == false) {
							tension = Double.parseDouble(txSpannung.getText());
						}

						else {
							txSpannung.setStyle("-fx-text-inner-color: red;");
						}
						if (txStrom.getText().isEmpty() == false) {
							current = Double.parseDouble(txStrom.getText());
						}

						else {
							txStrom.setStyle("-fx-text-inner-color: red;");
						}

						if (txWiderstand.getText().isEmpty() == false) {
							resistence = Double.parseDouble(txWiderstand.getText());
						}

						else {
							txWiderstand.setStyle("-fx-text-inner-color: red;");
						}

						Calculator myCalculator = new Calculator(power, tension, current, resistence);

						myCalculator.calculate();
						txLeistung.setText(Double.toString(myCalculator.getLeistung()));
						txSpannung.setText(Double.toString(myCalculator.getSpannung()));
						txStrom.setText(Double.toString(myCalculator.getStrom()));
						txWiderstand.setText(Double.toString(myCalculator.getWiderstand()));
						
						lblRechnungSpannung.setText(myCalculator.getRechnungSpannung());				
						lblRechnungStrom.setText(myCalculator.getRechnungStrom());	
						lblRechnungLeistung.setText(myCalculator.getRechnungLeistung());					
						lblRechnungWiderstand.setText(myCalculator.getRechnungWiderstand());
					}
				}
			});
			Button btnClear = new Button();
			btnClear.relocate(100, 445);
			btnClear.setText("     Clear     ");
			root.getChildren().add(btnClear);

			btnClear.setOnAction(e -> {

				txLeistung.setText("");
				txLeistung.setStyle("-fx-text-inner-color: black;");
				txSpannung.setText("");
				txSpannung.setStyle("-fx-text-inner-color: black;");
				txStrom.setText("");
				txStrom.setStyle("-fx-text-inner-color: black;");
				txWiderstand.setText("");
				txWiderstand.setStyle("-fx-text-inner-color: black;");
			});

			Scene scene = new Scene(root, 330, 550);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Formelrad");
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
