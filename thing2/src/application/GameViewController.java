package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameViewController {
	String name1;
	String name2;
	GameOfPig game;
	Image setImg;
	
	@FXML private Label nameLabel1;
	@FXML private Label nameLabel2;
	@FXML private Label scoreLabel1;
	@FXML private Label scoreLabel2;
	@FXML private Label scoreLabelGen;
	@FXML private Label turnLabel;
	@FXML private ImageView imageDiceView;
	@FXML private AnchorPane anchorPane;
	
	public void rollButton() {
		System.out.println("roll!");
		int num = game.roll();
		setImg = new Image("dice" + num + ".png");
		imageDiceView.setImage(setImg);
		scoreLabelGen.setText(Integer.toString(game.scoreTemp));
		if (num == 1) {
			scoreLabelGen.setText("Rolled one! Click HOLD for next turn.");
			game.scoreTemp = 0;
		} 
	}
	public void holdButton() throws IOException {
		System.out.println("hold!");
		setImg = new Image("diceimg.png");
		imageDiceView.setImage(setImg);
		if(game.turn) {
			game.p1.score += game.scoreTemp;
			game.turn = false;
		}
		else {
			game.p2.score += game.scoreTemp;
			game.turn = true;
		}
		displayTurn();
		game.scoreTemp = 0;
		if (game.p1.score >= 100 || game.p2.score >= 100) {
			winnerScene();
		}
	}
	
	public void displayTurn() {
		if (game.turn) {
			turnLabel.setText(game.p1.name + "'s turn!");
		}
		else {
			turnLabel.setText(game.p2.name + "'s turn!");
		}
		scoreLabel1.setText("Score: " + game.p1.score);
		scoreLabel2.setText("Score: " + game.p2.score);
		scoreLabelGen.setText("0");
	}
	
	public void initializeTextLabel(String name1, String name2) {
		nameLabel1.setText(name1);
		nameLabel2.setText(name2);
		createGame(name1, name2);
		displayTurn();
	}
	
	public void createGame(String name1, String name2) {
		game = new GameOfPig(name1, name2);
	}
	
	public void winnerScene() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("WinnerView.fxml"));
		Parent gameViewParent = loader.load();
		WinnerViewController controller = loader.getController();
		controller.displayWinner(game);
		Scene gameViewScene = new Scene(gameViewParent);
		//This line gets the Stage information
		Stage window = (Stage) anchorPane.getScene().getWindow();
		
		window.setScene(gameViewScene);
		window.show();
	}
}