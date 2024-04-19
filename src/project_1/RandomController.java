package project_1;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class RandomController implements Initializable {

   

    @FXML
    private Button calculateBt;

    @FXML
    private TextField numberTF;
    @FXML
    private Button dpTableBt;

    @FXML
    void showDptable(ActionEvent event) {

    	if(numberTF.getText()!=null) {
    		String dataTxt = numberTF.getText();
    		for(int i =0;i<dataTxt.length();i++) {
    			if(checkInt(dataTxt.charAt(i)))
    				continue;
    			else {
    				Alert alert = new Alert(AlertType.ERROR);
    				alert.setTitle("Numerical error");
    				alert.setContentText("The text has character not in [0,9]");
    				alert.showAndWait();
    				return;
    			}
    		}
    			
    		Integer [] data = new Integer[Integer.parseInt(dataTxt)];
    		for(int i =0;i<data.length;i++)
    			data[i]=i+1;
    		
    		
    		
        	Collections.shuffle(Arrays.asList(data));
        	
        	int [] goData = new int[data.length];
        	for(int i =0;i<goData.length;i++) {
        		goData[i]=data[i];
        	}
        	
        	
        	FXMLLoader handing = new FXMLLoader(getClass().getResource("DpTableFX.fxml"));
    		try {
    			
    			Stage stage = new Stage();
    			Scene scene = new Scene(handing.load());
    			stage.setScene(scene);
    			stage.setTitle("");
    			DPController dp= handing.getController();
    			dp.showTables(goData);
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
    	if(numberTF.getText()!=null) {
    		String dataTxt = numberTF.getText();
    		for(int i =0;i<dataTxt.length();i++) {
    			if(checkInt(dataTxt.charAt(i)))
    				continue;
    			else {
    				Alert alert = new Alert(AlertType.ERROR);
    				alert.setTitle("Numerical error");
    				alert.setContentText("The text has character not in [0,9]");
    				alert.showAndWait();
    				return;
    			}
    		}
    			
    		Integer [] data = new Integer[Integer.parseInt(dataTxt)];
    		for(int i =0;i<data.length;i++)
    			data[i]=i+1;
    		
    		
    		
        	Collections.shuffle(Arrays.asList(data));
        	
        	int [] goData = new int[data.length];
        	for(int i =0;i<goData.length;i++) {
        		goData[i]=data[i];
        	}
        	
        	
        	FXMLLoader handing = new FXMLLoader(getClass().getResource("LED.fxml"));
			try {
				
				Stage stagee = new Stage();
				Scene scene = new Scene(handing.load());
				stagee.setScene(scene);
				stagee.setTitle("");
				LoLoController con=	handing.getController();
				con.showResutl(goData);
				stagee.show();
				

			} catch (Exception e) {
				Alert alertt = new Alert(AlertType.ERROR);
				alertt.setTitle("Open Error");
				alertt.setContentText("Error:" + e.getMessage());
				e.printStackTrace();
			}
        	
        	
        	
        	
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
	private boolean checkInt (char num) {
		for(int i=0;i<10;i++) {
			if(num==(i+48))
				return true;
		}
		return false;
	}
}
