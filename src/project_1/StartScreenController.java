/**
 * 
 */
package project_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author Belal Hamdeh
 *
 */
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class StartScreenController implements Initializable {

	@FXML
	private ImageView byHandImage;

	@FXML
	private ImageView fileImage;

	@FXML
	private ImageView logoImage;

	@FXML
	private ImageView randomImage;

	@FXML
	void EnterByKeyboardOption(MouseEvent event) {
		FXMLLoader handing = new FXMLLoader(getClass().getResource("HandEnterFX.fxml"));
		try {
			Stage stage = new Stage();
			Scene scene = new Scene(handing.load());
			stage.setScene(scene);
			stage.setTitle("Enter by Keyboard");
			stage.show();

		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Open Error");
			alert.setContentText("Error:" + e.getMessage());
			e.printStackTrace();
		}
	}

	@FXML
	void RandomOption(MouseEvent event) {
		FXMLLoader randomly = new FXMLLoader(getClass().getResource("RandomFX.fxml"));
		try {
			Stage stage = new Stage();
			Scene scene = new Scene(randomly.load());
			stage.setScene(scene);
			stage.setTitle("Random");
			stage.show();

		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Open Error");
			alert.setContentText("Error:" + e.getMessage());
			e.printStackTrace();
		}
	}

	@FXML
	void openFileOption(MouseEvent event) {
		FXMLLoader randomly = new FXMLLoader(getClass().getResource("FileScreen.fxml"));
		try {
			Stage stage = new Stage();
			Scene scene = new Scene(randomly.load());
			stage.setScene(scene);
			stage.setTitle("File");
			stage.show();

		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Open Error");
			alert.setContentText("Error:" + e.getMessage());
			e.printStackTrace();
		}
	}

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
}
