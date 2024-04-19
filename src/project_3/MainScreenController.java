package project_3;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.text.Text;

public class MainScreenController implements Initializable {
	private ArrayList<Vertex> listV;// list of all vertex
	private ArrayList<Vertex> listC;// list of all cites
	@FXML
	private Label distanceTable;

	@FXML
	private ImageView gazaImage;

	@FXML
	private Label pathTable;

	@FXML
	private ImageView runImage;
	@FXML
    private Pane panee;

	@FXML
	private ComboBox<String> sourceComboBox;
	@FXML
	private ComboBox<String> targetCombo;

	@FXML
	void showTheShortestWay(MouseEvent event) {
		if (sourceComboBox.getSelectionModel().getSelectedItem() != null
				&& targetCombo.getSelectionModel().getSelectedItem() != null) {
			String sourceS = sourceComboBox.getSelectionModel().getSelectedItem();
			String targetS = targetCombo.getSelectionModel().getSelectedItem();
			Vertex source = null;
			Vertex target = null;
			for (int i = 0; i < listC.size(); i++) {
				if (listC.get(i).getName().equals(sourceS))
					source = listC.get(i);
			}
			for (int i = 0; i < listC.size(); i++) {
				if (listC.get(i).getName().equals(targetS))
					target = listC.get(i);
			}
			if (source != null && target != null) {
				Dijkstra dij = new Dijkstra(source, target, listV);
				LinkedList<Vertex> list = dij.getPath();
				String str=" ";
				str+=sourceS+" ";
				for(int i =0;i<list.size()-1;i++) {
//					System.out.print(" "+list.get(i).getName().trim()+" to");
					
					Line line = new Line();
					line.setStartX(list.get(i).getX());
					line.setStartY(list.get(i).getY());
					line.setEndX(list.get(i+1).getX());
					line.setEndY(list.get(i+1).getY());
					
					panee.getChildren().add(line);
					distanceTable.setText(dij.getDis()+"");
					if(listC.indexOf(list.get(i))!=-1){
						str+=" "+list.get(i).getName();
						str+=" "+list.get(i).hasCityAdj();
					}
				}
				
				Circle rec = new Circle(5);
					rec.setCenterX(list.get(0).getX());
					rec.setCenterY(list.get(0).getY());
					panee.getChildren().add(rec);
					Circle rec2 = new Circle(5);
					rec2.setCenterX(list.get(list.size()-1).getX());
					rec2.setCenterY(list.get(list.size()-1).getY());
					rec2.setFill(Color.BLUE);
					panee.getChildren().add(rec2);
				pathTable.setText(str);
			}
		}
	}

	public void getTable(ArrayList<Vertex> listt) {

		this.listV = listt;
		listC = new ArrayList<>();
		if (listV != null) {
			for (int i = 0; i < listV.size(); i++) {
				if (listV.get(i).isCity_street()) {
					listC.add(listV.get(i));
					sourceComboBox.getItems().add(listV.get(i).getName());
					targetCombo.getItems().add(listV.get(i).getName());// don't forget to remove the item selected in
																		// source
				}
			}
			sourceComboBox.setOnAction(e -> {
				if (!sourceComboBox.getItems().isEmpty()
						&& sourceComboBox.getSelectionModel().getSelectedItem() != null) {
					int t = getIndex(sourceComboBox.getSelectionModel().getSelectedItem(), targetCombo);
					if (t != -1)
						targetCombo.getItems().remove(t);
				}

			});

			for (int i = 0; i < listC.size(); i++) {
				Circle circle = new Circle(5);
				circle.setFill(Color.RED);
				circle.setCenterX(listC.get(i).getX());
				circle.setCenterY(listC.get(i).getY());
				panee.getChildren().add(circle);
				Text txt = new Text(listC.get(i).getName());
				txt.setX(listC.get(i).getX());
				txt.setY(listC.get(i).getY());
				panee.getChildren().add(txt);
				circle.setOnMouseClicked(e -> {
					if (sourceComboBox.getSelectionModel().getSelectedItem() == null) {
						sourceComboBox.setValue(txt.getText());
					} else if (sourceComboBox.getSelectionModel().getSelectedItem() != null
							&& targetCombo.getSelectionModel().getSelectedItem() == null) {
						targetCombo.setValue(txt.getText());
					} else {
						targetCombo.setValue(txt.getText());
					}
				});
			}

		} else {
			System.out.println("list vertex null !");
		}
	}

	private int getIndex(String str, ComboBox<String> comb) {
		if (!sourceComboBox.getItems().isEmpty() && sourceComboBox.getSelectionModel().getSelectedItem() != null) {
			for (int i = 0; i < comb.getItems().size(); i++) {
				if (comb.getItems().get(i).equals(str))
					return i;
			}
		}
		return -1;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Circle rec = new Circle(5);
		rec.setCenterX(20);
		rec.setCenterY(20);
		panee.getChildren().add(rec);
		Circle rec2 = new Circle(5);
		rec2.setCenterX(20);
		rec2.setCenterY(30);
		rec2.setFill(Color.BLUE);
		panee.getChildren().add(rec2 );
		Text txt = new Text("Target");
		txt.setX(40);
		txt.setY(25);
		Text txt2 = new Text("Source");
		txt2.setX(40);
		txt2.setY(35);
		panee.getChildren().addAll(txt,txt2);

	}
}
