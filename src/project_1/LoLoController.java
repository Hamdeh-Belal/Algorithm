package project_1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class LoLoController implements Initializable {

	private Contener[] contenre;
	  @FXML
	    private ScrollPane scrollPane;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void showResutl(String data) {

		Pane stackPane = new Pane();
		scrollPane.setContent(stackPane);
		HBox genHb = new HBox(200);
		genHb.setMaxWidth(290);
		stackPane.getChildren().add(genHb);
		VBox vbImg = new VBox(5);
		vbImg.maxWidth(40);
		VBox vbSwitch = new VBox(5);
		vbSwitch.setMaxWidth(40);
		genHb.getChildren().addAll(vbImg, vbSwitch);
		LCS lcs = new LCS(data);
		int length = lcs.getTrueLength();
		int[] y = lcs.getYss();
		int[] arrT = lcs.calculated();
		contenre = new Contener[arrT.length];

		for (int i = 0; i < length; i++) {

			boolean flage = false;
			int JT=-1;
//			int arrOfTure = -1;
			for (int j = 0; j < arrT.length; j++) {

				if (arrT[j] == y[i]) { // add LED's
					HBox hb = new HBox();
					hb.setMaxHeight(60);
					hb.setMinHeight(60);
					Label label = new Label("" + arrT[j]);
					label.setStyle(
							"-fx-background-color: lightblue; -fx-padding: 5px; -fx-border-color: black; -fx-border-width: 1px;");
					ImageView imgOfLight = new ImageView("C:\\BelalWorkSpace\\Algorithms\\lightOn.png");
					imgOfLight.setFitWidth(25);
					imgOfLight.setFitHeight(25);
					hb.getChildren().addAll(imgOfLight, label);
					vbImg.getChildren().add(hb);
					
					JT=j;
					
					contenre[j] = new Contener(i, label, label.getText());
					contenre[j].setIndexSwitch(arrT[j]-1);
					flage = true;
					break;

				}
			}

			if (!flage) { // add image of no light

				HBox hb = new HBox();
				hb.setMaxHeight(60);
				hb.setMinHeight(60);
				Label label = new Label("" + y[i]);
				label.setStyle(
						"-fx-background-color: lightblue; -fx-padding: 5px; -fx-border-color: black; -fx-border-width: 1px;");
				ImageView imgOfNoLight = new ImageView("C:\\BelalWorkSpace\\Algorithms\\lightOff.png");
				imgOfNoLight.setFitWidth(25);
				imgOfNoLight.setFitHeight(25);
				hb.getChildren().addAll(imgOfNoLight, label);
				vbImg.getChildren().add(hb);

			}

			HBox hbSwitch = new HBox();
			hbSwitch.setMaxHeight(60);
			hbSwitch.setMinHeight(60);
			hbSwitch.setMaxWidth(40);
			Label labelSwitch = new Label("" + (i+1));
			labelSwitch.setStyle(
					"-fx-background-color: lightblue; -fx-padding: 5px; -fx-border-color: black; -fx-border-width: 1px;");
			hbSwitch.getChildren().add(labelSwitch);
			vbSwitch.getChildren().add(hbSwitch);

			if (JT != -1) {
//				contenre[JT].setIndexSwitch(i);

			}

		}

		// _______________________________________________________________________________________________________________________

		for (int i = 0; i < contenre.length; i++) {
			if (contenre[i] != null) {
				int indexImg = contenre[i].getIndex();
				int indexSwitch = contenre[i].getIndexSwitch();

				Line line = new Line(45, ((65 * indexImg)+5), 250,
						( (65 * (indexSwitch)))+5);
				line.setStroke(Color.ORANGE);
				line.setStrokeWidth(3);
				stackPane.getChildren().add(line);
			} else
				System.out.println("the index line " + i + " is Null !!!");

		}

		
	}
	public void showResutl(int data[]) {

//		ScrollPane scrollPane = new ScrollPane();
		Pane stackPane = new Pane();
		scrollPane.setContent(stackPane);
		HBox genHb = new HBox(200);
		genHb.setMaxWidth(290);
		stackPane.getChildren().add(genHb);
		VBox vbImg = new VBox(5);
		vbImg.maxWidth(40);
		VBox vbSwitch = new VBox(5);
		vbSwitch.setMaxWidth(40);
		genHb.getChildren().addAll(vbImg, vbSwitch);
		LCS lcs = new LCS(data);
		int length = lcs.getTrueLength();
		int[] y = lcs.getYss();
		int[] arrT = lcs.calculated();
		contenre = new Contener[arrT.length];

		for (int i = 0; i < length; i++) {

			boolean flage = false;
			int JT=-1;
//			int arrOfTure = -1;
			for (int j = 0; j < arrT.length; j++) {

				if (arrT[j] == y[i]) { // add LED's
					HBox hb = new HBox();
					hb.setMaxHeight(60);
					hb.setMinHeight(60);
					Label label = new Label("" + arrT[j]);
					label.setStyle(
							"-fx-background-color: lightblue; -fx-padding: 5px; -fx-border-color: black; -fx-border-width: 1px;");
					ImageView imgOfLight = new ImageView("C:\\BelalWorkSpace\\Algorithms\\lightOn.png");
					imgOfLight.setFitWidth(25);
					imgOfLight.setFitHeight(25);
					hb.getChildren().addAll(imgOfLight, label);
					vbImg.getChildren().add(hb);
					
					JT=j;
					
					contenre[j] = new Contener(i, label, label.getText());
					contenre[j].setIndexSwitch(arrT[j]-1);
					flage = true;
					break;

				}
			}

			if (!flage) { // add image of no light

				HBox hb = new HBox();
				hb.setMaxHeight(60);
				hb.setMinHeight(60);
				Label label = new Label("" + y[i]);
				label.setStyle(
						"-fx-background-color: lightblue; -fx-padding: 5px; -fx-border-color: black; -fx-border-width: 1px;");
				ImageView imgOfNoLight = new ImageView("C:\\BelalWorkSpace\\Algorithms\\lightOff.png");
				imgOfNoLight.setFitWidth(25);
				imgOfNoLight.setFitHeight(25);
				hb.getChildren().addAll(imgOfNoLight, label);
				vbImg.getChildren().add(hb);

			}

			HBox hbSwitch = new HBox();
			hbSwitch.setMaxHeight(60);
			hbSwitch.setMinHeight(60);
			hbSwitch.setMaxWidth(40);
			Label labelSwitch = new Label("" + (i+1));
			labelSwitch.setStyle(
					"-fx-background-color: lightblue; -fx-padding: 5px; -fx-border-color: black; -fx-border-width: 1px;");
			hbSwitch.getChildren().add(labelSwitch);
			vbSwitch.getChildren().add(hbSwitch);

			if (JT != -1) {
//				contenre[JT].setIndexSwitch(i);

			}

		}

		// _______________________________________________________________________________________________________________________

		for (int i = 0; i < contenre.length; i++) {
			if (contenre[i] != null) {
				int indexImg = contenre[i].getIndex();
				int indexSwitch = contenre[i].getIndexSwitch();

				Line line = new Line(45, ((65 * indexImg)+5), 250,
						( (65 * (indexSwitch)))+5);
				line.setStroke(Color.ORANGE);
				line.setStrokeWidth(3);
				stackPane.getChildren().add(line);
			} else
				System.out.println("the index line " + i + " is Null !!!");

		}

	}

}
