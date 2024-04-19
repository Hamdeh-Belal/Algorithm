package project_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Lolo  {
	private String data;
	private Contener[] contenre;

	/**
	 * @param data
	 */
	public Lolo(String data,Stage stage) {
		super();
		this.data = data;
		try {
			solo(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public void solo (Stage stage) {
		stage= new Stage();
		ScrollPane scrollPane = new ScrollPane();
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

		Scene scene = new Scene(scrollPane,300,600);
		stage.setScene(scene);
		stage.show();
	}
}
