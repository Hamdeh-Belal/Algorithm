/**
 * 
 */
package project_1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * @author Belal Hamdeh
 *
 */
public class DriverClass extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader starting = new FXMLLoader(getClass().getResource("StartScreenFX.fxml"));
		try {
			Scene scene = new Scene(starting.load());
			stage.setScene(scene);
			stage.setTitle("Start");
			stage.show();

		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Open Error");
			alert.setContentText("Error:" + e.getMessage());
			e.printStackTrace();
		}
	}
}
