package tp;

public class runGame {

	public static void main(String[] args) {
		Game game = new Game();
		
		//ó�� ���ӽ����ϰ� �ѹ��� �ٷ� ������
		game.currentTime();
		game.temperature(); 
		
		while(!game.isFinish()) {
			//� ������ �������� �������� �Ѿ
			if(true//game.work()
					) {
				game.dayAndNight();
				game.temperature();
				game.hp();
			}
		}
		game.printRate();	//������ �����ֱ�
		//�������� �Լ�
	}

}