package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HistoryViewController {
	@FXML Label label;
	
	ArrayList<String> list = new ArrayList<String>();
	File file = new File("recordFile.txt");
	
	public void displayHistory() throws FileNotFoundException {
		String record;
		Scanner scan = new Scanner(file);
		while (scan.hasNext()) {
			record = scan.nextLine();
			list.add(record);
		}
		String thing = "";
		for (String string : list) {
			thing += string.toString() + "\n";
		}
		System.out.println(thing);
		label.setText(thing);
		scan.close();
	}
}