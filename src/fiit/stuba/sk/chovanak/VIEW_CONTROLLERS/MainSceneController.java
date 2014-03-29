package fiit.stuba.sk.chovanak.VIEW_CONTROLLERS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import fiit.stuba.sk.chovanak.Main;

public class MainSceneController {
	
	private static final Logger LOG = Logger.getLogger(MainSceneController.class.getName());
	
	@FXML
	private MediaView mediaView;
	
	private MediaPlayer player;
	
	@FXML
	private Button btnOpen;
	
	@FXML
	private Button btnEQ;
	
	@FXML
	private  Button btnPlay;
	
	@FXML
	private Button btnPause;
	
	@FXML
	private Button btnStop;
	
	@FXML
	private Slider sldVolume;
	
	private String MEDIA_URL =
			 "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";

	/**
	 * Multilanguage variables
	 */
	private Locale locale = Locale.getDefault();
	private ResourceBundle LangResource = ResourceBundle.getBundle("Resource_sk");
	
	
	public void setMediaURL(String url){
		MEDIA_URL = url;
	}
	
	
	/**
	 * This method is called when FXML loader initializes object of this controller class
	 */
	public void initialize(){
		initLanguage();
		setConfigurations();
		LOG.info("Starting aplication and initializing controller class");
	}

	
	private void initLanguage(){
		btnPlay.setText(LangResource.getString("main.btnPlay"));
		btnPause.setText(LangResource.getString("main.btnPause"));
	}
	
	private void setConfigurations(){
			// SET CONTROLLER OBJECTS CONFIGURATION
			sldVolume.setMin(0.0);
			sldVolume.setMax(1.0);
			
			//SET LOGGER CONFIGURATION
			try {
				FileInputStream loggingProps = new FileInputStream("etc/logging.properties");
				LogManager.getLogManager().readConfiguration(loggingProps);
			} catch (FileNotFoundException e) {
				LOG.warning("Could not load file for logging properties." + e.getMessage());
			} catch (SecurityException e) {
				LOG.warning("Security exception when trying to load logging.properties." + e.getMessage());
			} catch (IOException e) {
				LOG.warning("IO exception when trying to load logging.properties." + e.getMessage());
			}
	}
	
	public  void openMediaFile(){
		Platform.runLater(new Task(){
			@Override
			protected Object call() throws Exception {
				File mediaFile = Main.openFile();
				setMediaURL(mediaFile.toURI().toString());
				return null;
			}
		});
	}
	
	public  void showEqualizer(){
		Platform.runLater(new Task(){
			@Override
			protected Object call() throws Exception {
				Main.showEqualizer();
				return null;
			}
		});	
	}
	
	public void updateVolume(){
		Platform.runLater(new Task(){
			@Override
			protected Object call() throws Exception {
				if(player != null){
					player.setVolume(sldVolume.getValue());
				}
				return null;
			}
		});		
	}
	
	
	public  void playFile(){
		Platform.runLater(new Task(){
			@Override
			protected Object call() throws Exception {
	
				Media media = new Media(MEDIA_URL);
				
				if(player != null){
					if(player.getStatus() == MediaPlayer.Status.PAUSED){
						player.play();
						return null;
					}else if(player.getStatus() == MediaPlayer.Status.PLAYING){
						player.stop();
					}
				}
				
				player = new MediaPlayer(media);
				updateVolume();
		        
				/*AudioEqualizer eq = player.getAudioEqualizer();
				
				ObservableList<EqualizerBand> bands = eq.getBands();*/
				
		        mediaView.setMediaPlayer(player);
		        
		        player.play();
				
		        return null;
			}
		});	  
	}
	
	public void pauseFile(){
		Platform.runLater(new Task(){
			@Override
			protected Object call() throws Exception {
		        if(player != null){		        	
		        	if(player.getStatus() == MediaPlayer.Status.PLAYING){
		        		player.pause();
		        	}		        	
		        }
		        return null;
			}
		});	  
	}
	
	public void stopFile(){
		Platform.runLater(new Task(){
			@Override
			protected Object call() throws Exception {
		        if(player != null){		        	
		        	player.stop();		        	
		        }else{
		        	LOG.info("Trying to stop playing on null player");
		        }
		        return null;
			}
		});	  
	}
	
}
