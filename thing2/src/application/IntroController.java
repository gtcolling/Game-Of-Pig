package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class IntroController {
	private GameViewController thing;
	
	@FXML private TextField nameBox1;
	@FXML private TextField nameBox2;
	
	/**
	 * when this method is called, it will change the Scene to GameView
	 * @throws IOException
	 * 
	 */
	public void startButton(ActionEvent event) throws IOException {
		System.out.println("click");
		System.out.println(nameBox1.getText() + " " + nameBox2.getText());
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("GameView.fxml"));
		Parent gameViewParent = loader.load();
		GameViewController controller = loader.getController();
		controller.initializeTextLabel(nameBox1.getText(), nameBox2.getText());
		Scene gameViewScene = new Scene(gameViewParent);
		//This line gets the Stage information
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(gameViewScene);
		window.show();
	}
	
	public void displayHistoryScene(ActionEvent event) throws IOException {
		System.out.println("click");
		System.out.println(nameBox1.getText() + " " + nameBox2.getText());
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("HistoryView.fxml"));
		Parent gameViewParent = loader.load();
		HistoryViewController controller = loader.getController();
		controller.displayHistory();
		Scene gameViewScene = new Scene(gameViewParent);
		//This line gets the Stage information
		Stage window = new Stage();
		
		window.setScene(gameViewScene);
		window.show();
	}
}