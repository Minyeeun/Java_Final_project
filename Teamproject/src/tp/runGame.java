package tp;

public class runGame {

	public static void main(String[] args) {
		Game game = new Game();
		
		game.currentTime();
		
		while(!game.isFinish()) {
			do {
				game.temperature();
				game.dayAndNight();
			} while(game.work());
		}
		game.printRate();
	}

}
