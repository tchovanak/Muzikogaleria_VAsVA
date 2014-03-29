package fiit.stuba.sk.chovanak.VIEW_CONTROLLERS;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddToDatabaseController {
		@FXML 
		TextField txtNameOfSong;
		
		@FXML 
		TextField txtAuthorOfSong;
		
		@FXML 
		TextField txtMoodOfSong;
		
	
		public void addToDatabase(){
				
				String name = txtNameOfSong.getText();
				String mood = txtMoodOfSong.getText();
				String author = txtAuthorOfSong.getText();
				
				System.out.println("adding to database > " + name +  " " + author + " " + mood + " " );
		}
		
}
