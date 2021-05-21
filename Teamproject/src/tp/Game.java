package tp;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
	Plant plant = new Plant();

	public void currentTime() { // 현재시간 받아와서 게임을 낮으로 시작할지 밤으로 시작할지 결정
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR);
		if (hour > 6 && hour < 18) {
			// 6시 이후거나 18시 이전이면 배경색 노란색으로 설정
			// changeColor()함수 사용없이 단독으로 배경색 설정
		} else if (hour < 6 && hour > 18) {
			// 6시 이전이거나 18시 이후면 배경색 남색으로 설정
			// changeColor()랑 상관없이 단독으로 배경색 설정
		}
	}

	/*
	 * changeColor(): 배경색 변경시키는 이벤트함수
	 * 
	 * if(이전 배경색(처음 시작할 때 현재 시간 받아와서 결정된 배경색) == 노란색) { 
	 * 배경색 = 남색; 
	 * } else if(이전 배경색 == 남색) { 
	 * 배경색 = 노란색; 
	 * }
	 * 
	 * <노란색or남색 2가지 선택지만 존재하는 함수로>
	 */

	static int tmp = 0;

	public void temperature() { // 0~25도 내에서 랜덤으로 현재온도 출력 ///사용되는 경우를 보니까 int 일 필요가 없어보여서 void로 바꾸었습니다
		tmp = (int) (Math.random() * 26);
		
	}

	int dayCount = 1;

	public void dayAndNight() { // 1분 간격으로 낮과 밤이 바뀜
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				if (work() == true && dayCount <= 10) { ///사용자가 클릭을 하지 않으면 날짜가 안바뀌는 경우
					// changeColor(); //밤낮바뀔 때 배경색도 바꿔줌
					dayCount++;
				} else if (dayCount > 10) { // 2번 바뀔때마다 하루가 카운트 됨(10번 바뀌면 5일 지난 것으로)
					timer.cancel();
				}
			}

		};
		timer.schedule(task, 60000, 2000); // 1분간격
	}

	public boolean work() {	//행동 취헸는지 검사(마우스이벤트 유무로)
		if() {	//마우스 클릭이 있으면 행동 취한 것
			return true;
		} else {	//마우스클릭 없으면 행동 안 취한 것
			return false;
		}
	}
	
	public void hp() {
		if (tmp < 7) {
			// 빛 쬐여주는 이벤트 잘 클릭했으면
			plant.setHP(plant.getHP() + 10);
			// 그렇지않으면
			plant.setHP(plant.getHP() - 10);
		} else if (tmp > 12) {
			// 선풍기 틀어주는 이벤트 잘 클릭했으면
			plant.setHP(plant.getHP() + 10);
			// 그렇지않으면
			plant.setHP(plant.getHP() - 10);
		}
	}

	public boolean isFinish() { // 게임끝났는지 판단
		if (dayCount == 11 || plant.getHP() <= 0) { // 5일이 지났거나 hp가 0이되면 게임종료 ///혹시 모르니까 0보다 같거나 작다로 고쳤습니다
			return true;
		} else {
			return false;
		}
	}

	public void printRate() { // 성공률 보여주기
		System.out.print(plant.getHP()); // 게임종료시 hp받아와서 성공률 계산
	}
}
