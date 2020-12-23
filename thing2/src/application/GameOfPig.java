package application;

public class GameOfPig {
	Player p1;
	Player p2;
	int scoreTemp = 0;
	int rando = 0;
	boolean turn = true; //true is p1's turn, false is p2's turn
	boolean winner; //true = p1 won, false = p2 won
	
	GameOfPig(String name1, String name2){
		p1 = new Player(name1);
		p2 = new Player(name2);
	}
	public int roll() {
		rando = (int) (Math.random() * (6 - 1 + 1) + 1);
		scoreTemp += rando;
		return rando;
	}
	
	public class Player {
		String name;
		int score = 0;
		
		Player(String name){
			this.name = name;
		}
	}
}