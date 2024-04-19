package project_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileController implements Initializable {
	private int data[];

	@FXML
	private Button calculateBt;

	@FXML
	private ImageView fileImg;
	@FXML
	private Button dpTableBt;

	@FXML
	void showDptable(ActionEvent event) {
		if (!dpTableBt.isDisable()) {

			FXMLLoader handing = new FXMLLoader(getClass().getResource("DpTableFX.fxml"));
			try {

				Stage stage = new Stage();
				Scene scene = new Scene(handing.load());
				stage.setScene(scene);
				stage.setTitle("");
				DPController dp = handing.getController();
				dp.showTables(data);
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
		if (!calculateBt.isDisable()) {

			FXMLLoader handing = new FXMLLoader(getClass().getResource("LED.fxml"));
			try {

				Stage stagee = new Stage();
				Scene scene = new Scene(handing.load());
				stagee.setScene(scene);
				stagee.setTitle("");
				LoLoController con = handing.getController();
				con.showResutl(data);
				stagee.show();

			} catch (Exception e) {
				Alert alertt = new Alert(AlertType.ERROR);
				alertt.setTitle("Open Error");
				alertt.setContentText("Error:" + e.getMessage());
				e.printStackTrace();
			}
			

		}
	}

	@FXML
	void uploadFileNow(MouseEvent event) {
		data=null;
		Stage stage = new Stage();
		FileChooser filechooser = new FileChooser();
		File file = filechooser.showOpenDialog(stage);
		if (!file.exists() || file == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("File Read Unsuccessfully");
			alert.setContentText("The file has been read Unsuccessfully.");
			alert.showAndWait();
		} else {
			data = readFile(file);
			
			if(data== null||(checkSum(data))) {

				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("File Read Unsuccessfully");
				alert.setContentText("Input has NonDigit charector");
				alert.showAndWait();
				return;
			}
			else {
//			LCS lcs = new LCS(data);
//			lcs.calculateAndPrint();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("File Read Successful");
			alert.setContentText("The file has been read successfully.");
			alert.showAndWait();

			calculateBt.setStyle("-fx-background-color: #90EE90");
			calculateBt.setDisable(false);

			dpTableBt.setStyle("-fx-background-color: #90EE90");
			dpTableBt.setDisable(false);
		}
		}
	}

	private int[] readFile(File file) {
		int inputFileArray[] = null;
		String data = "";
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				data = data + scan.nextLine();

			}
			String[] dataLine = data.split(",");
			inputFileArray = new int[dataLine.length];
			for (int i = 0; i < dataLine.length; i++) {
				if(dataLine[i].length()==1&&Character.isDigit(dataLine[i].charAt(0))) {
				inputFileArray[i] = Integer.parseInt(dataLine[i]);
				}
				else if(dataLine[i].length()>1) {
					for(int w =0 ;w<dataLine[i].length();w++) {
						if(!Character.isDigit(dataLine[i].charAt(w))) {
							return null;
						}
						else
						inputFileArray[i] = Integer.parseInt(dataLine[i]);

					}
					
				}else if(dataLine[i].length()==1&&!Character.isDigit(dataLine[i].charAt(0))) {
					return null;
				}
			}

			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputFileArray;

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		calculateBt.setDisable(true);
		calculateBt.setStyle("-fx-background-color:  red");
		dpTableBt.setDisable(true);
		dpTableBt.setStyle("-fx-background-color:  red");
	}
	private boolean checkSum(int[]datas) {
		int sum=0;
		int max=-1;
		for(int i =0;i<datas.length;i++){
			sum=sum+datas[i];
			
			if(max<datas[i])
				max=datas[i];
		}
		int checksum=0;
//		if(max!=(-1) ){
		for(int i =1;i<=max;i++) {
			checksum=+i;
		}
//		}
		if(sum==checksum)
			return true;
		else
		return false;
	}
}
