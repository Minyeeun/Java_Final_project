package tp;

public class PlantObject {
	private int hp;
	
	public int getHP() {	//식물의 hp를 받아와서 성공률 보여주기
		return hp;
	}
	
	public void setHP(int hp) {	//work 검사 후 +- 10씩
		this.hp = hp;
	}
	
}
