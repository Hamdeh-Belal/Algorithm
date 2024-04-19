package project_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainDriver extends Application {
	private ArrayList<Vertex> list;

	public static void main(String[] args) {
		launch(args);

	}

	private boolean readFile(File file) {
		try {
			Scanner input = new Scanner(file);
			String length = input.nextLine();
			String[] lengthData = length.split(",");
			int city_streetSize = Integer.parseInt(lengthData[0].trim());
			int adjSize = Integer.parseInt(lengthData[1].trim());
			list = new ArrayList<>();

			for (int i = 0; i < city_streetSize; i++) {
//				System.out.println(i);

				String line = input.nextLine();
				String[] lineData = line.split(",");
				String name = lineData[0].trim();
				String CS = lineData[1].trim();
				boolean cs = false;
				
				if(CS.charAt(0) == 'c')
					cs=true;
				
				double latitudeY = Double.parseDouble(lineData[2].trim());
				double longitudeX = Double.parseDouble(lineData[3].trim());
				Vertex vertex = new Vertex(name, cs, longitudeX, latitudeY);
				list.add(vertex);
			}

			for (int j = 0; j < adjSize; j++) {
				String line = input.nextLine();
				String[] lineData = line.split(",");
				String firstCity = lineData[0].trim();
				String secondCity = lineData[1].trim();
				for (int i = 0; i < list.size(); i++) {
					if (firstCity.equals(list.get(i).getName().trim())) {
						Vertex temp1 = list.get(i);
						for (int k = 0; k < list.size(); k++) {
							if (secondCity.equals(list.get(k).getName().trim())) {
								Vertex temp2 = list.get(k);
								temp1.addEdge(temp2);
								temp2.addEdge(temp1);
//								System.out.println(temp1+"    ::::::    "+temp2);
//								System.out.println(temp2+"    ::::::    "+temp1);
							}

						}
					}
				}
			}
			input.close();
			return true;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void start(Stage arg0) throws Exception {
		File file = new File("C:\\BelalWorkSpace\\Algorithms\\CitryStreetAdj.txt");
		if (readFile(file)) {

			FXMLLoader handing = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
			try {

				Stage stage = new Stage();
				Scene scene = new Scene(handing.load());
				stage.setScene(scene);
				stage.setTitle("Gzaz");
				MainScreenController mC = handing.getController();
				mC.getTable(list);
				stage.show();

			} catch (Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Open Error");
				alert.setContentText("Error:" + e.getMessage());
				e.printStackTrace();
			}

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("File reading .....");
			alert.setContentText("Error: File Read EX");

		}

	}
}
