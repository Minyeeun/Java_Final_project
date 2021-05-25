package tp;

public class runGame {

	public static void main(String[] args) {
		Game game = new Game();
		
		//처음 게임시작하고 한번은 바로 설정됨
		game.currentTime();
		game.temperature(); 
		
		while(!game.isFinish()) {
			//어떤 동작이 있을때만 다음으로 넘어감
			if(true//game.work()
					) {
				game.dayAndNight();
				game.temperature();
				game.hp();
			}
		}
		game.printRate();	//성공률 보여주기
		//게임종료 함수
	}

}