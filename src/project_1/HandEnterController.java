package project_1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class HandEnterController implements Initializable {

	@FXML
	private Button calculateBt;

	@FXML
	private TextArea numbersTextArea;

	@FXML
	private Button dpTableBt;

	@FXML
	void showDptable(ActionEvent event) {
		if (numbersTextArea.getText() != null && check(numbersTextArea.getText())) {

			FXMLLoader handing = new FXMLLoader(getClass().getResource("DpTableFX.fxml"));
			try {

				Stage stage = new Stage();
				Scene scene = new Scene(handing.load());
				stage.setScene(scene);
				stage.setTitle("");
				DPController dp = handing.getController();
				dp.showTables(numbersTextArea.getText());
				stage.show();

			} catch (Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Open Error");
				alert.setContentText("Error:" + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	@FXML
	void calculateTheResult(ActionEvent event) {
		if (numbersTextArea.getText() != null && check(numbersTextArea.getText())) {
			String data = numbersTextArea.getText();

			FXMLLoader handing = new FXMLLoader(getClass().getResource("LED.fxml"));
			try {

				Stage stage = new Stage();
				Scene scene = new Scene(handing.load());
				stage.setScene(scene);
				stage.setTitle("");
				LoLoController con = handing.getController();
				con.showResutl(data);
				stage.show();

			} catch (Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Open Error");
				alert.setContentText("Error:" + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	private boolean check(String str) {

		String[] data = str.split(",");
		int[] dataI = new int[data.length];
		for (int i = 0; i < data.length; i++) {
			dataI[i] = Integer.parseInt(data[i]);

			if (data[i].length() == 1 && (!Character.isDigit(data[i].charAt(0)))) {
				return false;

			} else if (data[i].length() > 1) {
				for (int k = 0; k < data[i].length(); k++) {
					if (!Character.isDigit(data[i].charAt(k)))
						return false;
				}
			}
		}
		return true;
	}
}
