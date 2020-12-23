package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class WinnerViewController {
	GameOfPig game;
	
	@FXML AnchorPane anchorPane;
	@FXML Label scoreLabel1;
	@FXML Label scoreLabel2;
	@FXML Label winnerLabel;
	
	public void displayWinner(GameOfPig game) {
		this.game = game;
		
		if (game.p1.score > game.p2.score ) {
			game.winner = true;
		} else {
			game.winner = false;
		}
		
		if (game.winner) {
			winnerLabel.setText(game.p1.name + " is the winner of PIG!");
		} else {
			winnerLabel.setText(game.p2.name + " is the winner of PIG!");
		}
		
		scoreLabel1.setText(game.p1.name + "'s score is: " + game.p1.score);
		scoreLabel2.setText(game.p2.name + "'s score is: " + game.p2.score);
	}
	
	public String format() {
		String format = "Winner: ";
		if (game.winner) {
			format += game.p1.name + " - " + game.p1.score +", Loser: " + game.p2.name + " - " + game.p2.score;
		} else {
			format += game.p2.name + " - " + game.p2.score + ", Loser: " + game.p1.name + " - " + game.p1.score;
		}
		return format;
	}
	
	public void backButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewIntro.fxml"));
		Parent gameViewParent = loader.load();
		Scene gameViewScene = new Scene(gameViewParent);
		//This line gets the Stage information
		Stage window = (Stage) anchorPane.getScene().getWindow();
		
		window.setScene(gameViewScene);
		window.show();
	}
	
	public void saveButton() throws IOException {
		String record = format();
		System.out.println(record);
		writeToFile(record);
		winnerLabel.setText("The game record was saved!");
	}
	
	public void writeToFile(String record) throws IOException {
		String fileName = "recordFile.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
		writer.append("\n");
		writer.append(record);
		writer.close();
	}
}
