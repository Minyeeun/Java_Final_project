package tp;

public class Plant{

	public Plant() {
		
	}
	private int hp;
	private int rate;	//게임종료시 남아있는 hp를 받아와 점수 매기기
	
	public int getrate() {	//식물의 hp를 받아와서 성공률 보여주기
		return rate;
	}
	
	public void setHP() {	//work 검사 후 +- 10씩
		this.hp = hp;
	}
	
	
}
