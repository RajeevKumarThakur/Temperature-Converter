package com.mnr.javafx_app;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	public ChoiceBox choiceBox;
	@FXML
	public TextField userInputField;
	@FXML
	public Button convertButton;
	@FXML
	public Label welcomeLabel;

	private static final String C_To_F_Text="Celsius to fahrenheit";
	private static final String F_To_C_Text="Fahrenheit to Celsius";
	private boolean isC_To_F =true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choiceBox.getItems().add(C_To_F_Text);
		choiceBox.getItems().add(F_To_C_Text);
		choiceBox.setValue(C_To_F_Text);

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.equals(C_To_F_Text)) {
				isC_To_F = true;
			}  else {
				isC_To_F=false;
			}
		});

		convertButton.setOnAction(event -> {
			convert();
		});
	}
	private void convert() {
		String input=userInputField.getText();
		float enteredTemperature = 0.0f;
		try {
			enteredTemperature = Float.parseFloat(input);
		} catch (Exception ex) {
			warnUser();
			return;
		}
		float newTemperature1=0.0f;
		if(isC_To_F) {
			newTemperature1 = (enteredTemperature * 9 / 5) + 32;
		} else {
			newTemperature1 = (enteredTemperature - 32) * 5 / 9;
		}
		display(newTemperature1);
	}
	private void display(float newTemperature) {
		String unit=isC_To_F? "F":"C";
		System.out.println("new temperature = "+newTemperature + unit);
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("new temperature = "+newTemperature +" " + unit);
		alert.show();
	}

	private void warnUser() {
		Alert alert=new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occurred");
		alert.setHeaderText("Invalid temperature entered");
		alert.setContentText("Please enter a valid temperature");
		alert.show();
	}

}
