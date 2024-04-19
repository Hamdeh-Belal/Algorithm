package project_1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

public class DPController implements Initializable {

	@FXML
	private ScrollPane scrollPane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	private void showTable(int[][] array,int []y) {
		try {
		if (array != null) {
			GridPane gPane = new GridPane();
			
			Label labell = new Label("" + 0);
			labell.setStyle("-fx-padding: 10px; " + "-fx-border-radius: 5px; " + "-fx-border-color: black; "
					+ "-fx-border-width: 2px;");
			gPane.add(labell,0,0);
			Label labelll = new Label("" + 0);
			labelll.setStyle("-fx-padding: 10px; " + "-fx-border-radius: 5px; " + "-fx-border-color: black; "
					+ "-fx-border-width: 2px;");
			gPane.add(labelll,0,1);
			Label label3 =new Label("" + 0);
			label3.setStyle("-fx-padding: 10px; " + "-fx-border-radius: 5px; " + "-fx-border-color: black; "
					+ "-fx-border-width: 2px;");
			gPane.add(label3,1,0);
			
			
			for(int i=0;i<y.length;i++) {
				Label label = new Label("" + y[i]);
				label.setStyle("-fx-padding: 10px; " + "-fx-border-radius: 5px; " + "-fx-border-color: black; "
						+ "-fx-border-width: 2px;");
				gPane.add(label,0,i+1+1 );
				Label labels = new Label("" + (i+1));
				labels.setStyle("-fx-padding: 10px; " + "-fx-border-radius: 5px; " + "-fx-border-color: black; "
						+ "-fx-border-width: 2px;");
				gPane.add(labels,i+1+1,0 );

			}
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
				

						Label label = new Label("" + array[i][j]);
						label.setStyle("-fx-padding: 10px; " + "-fx-border-radius: 5px; " + "-fx-border-color: black; "
								+ "-fx-border-width: 2px;");
						gPane.add(label, i+1, j+1);
						
						if(j==(array[i].length-1)&&i==(array.length-1))
							label.setStyle("-fx-background-color: #B90E0A; " + "-fx-text-fill: white; "
								+ "-fx-padding: 10px; " + "-fx-border-radius: 5px; " + "-fx-border-color: black; "
								+ "-fx-border-width: 2px;");

				}

			}
			scrollPane.setContent(gPane);

		}
		else {
			Alert alertt = new Alert(AlertType.ERROR);
			alertt.setTitle("Open Error");
			alertt.setContentText("Error: intput is Null ");
			
			
			
			
		}
		}
		catch (Exception e) {
			Alert alertt = new Alert(AlertType.ERROR);
			alertt.setTitle(" Error");
			alertt.setContentText("Error:" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public void showTables(String data) {
		LCS lcs = new LCS(data);
		int dataArray [][]=lcs.getTable();
		int []y=lcs.getYss();
		showTable(dataArray,y);
	}
	public void showTables(int[] data) {
		LCS lcs = new LCS(data);
		int dataArray [][]=lcs.getTable();
		int []y=lcs.getYss();

		showTable(dataArray,y);
	}
}
