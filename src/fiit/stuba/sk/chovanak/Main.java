package fiit.stuba.sk.chovanak;
	

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import fiit.stuba.sk.chovanak.VIEW_CONTROLLERS.MainSceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class Main extends Application {
	
	
	private static Stage primaryStage; 
	private static FileChooser chooser = new FileChooser();
	
	public static File openFile(){
		return chooser.showOpenDialog(primaryStage);
	}
	
	public static void showEqualizer(){
		Stage EQStage = new Stage();	
		AnchorPane page;
		
		try {
			page = (AnchorPane) FXMLLoader.load(Main.class.getResource("FXML_CSS/EQStage.fxml"));
			Scene EQscene = new Scene(page);
			
		    EQStage.setScene(EQscene);
		    EQStage.setTitle("Muzikogaleria");
		    EQStage.show();
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
       
	}
	
	@Override
	    public void start(Stage primaryStage) {
	        try {
	        	
	        	this.primaryStage = primaryStage;
	        	
	            AnchorPane page = (AnchorPane) FXMLLoader.load(Main.class.getResource("FXML_CSS/formularAddToDatabase.fxml"));
	            Scene scene = new Scene(page);
	            
	            AnchorPane mainPage = (AnchorPane) FXMLLoader.load(Main.class.getResource("FXML_CSS/mainScene.fxml"));
	            Scene mainScene = new Scene(mainPage);
	            
	            primaryStage.setScene(mainScene);
	            primaryStage.setTitle("Muzikogaleria");
	            primaryStage.show();
	        
	           
	            
	        } catch (Exception ex) {
	            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	public static void main(String[] args) {
		launch(args);
	}
}
