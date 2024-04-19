package project_1;

import javafx.application.Application;
import javafx.stage.Stage;

public class LoloMain extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		String data ="4,2,6,7,13,3,10,8,12,9,11,1,5";
		Lolo lolo = new Lolo(data,stage);
		
	}
	

}
