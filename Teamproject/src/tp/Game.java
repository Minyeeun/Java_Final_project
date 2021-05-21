package tp;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
	Plant plant = new Plant();

	public void currentTime() { // ����ð� �޾ƿͼ� ������ ������ �������� ������ �������� ����
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR);
		if (hour > 6 && hour < 18) {
			// 6�� ���İų� 18�� �����̸� ���� ��������� ����
			// changeColor()�Լ� ������ �ܵ����� ���� ����
		} else if (hour < 6 && hour > 18) {
			// 6�� �����̰ų� 18�� ���ĸ� ���� �������� ����
			// changeColor()�� ������� �ܵ����� ���� ����
		}
	}

	/*
	 * changeColor(): ���� �����Ű�� �̺�Ʈ�Լ�
	 * 
	 * if(���� ����(ó�� ������ �� ���� �ð� �޾ƿͼ� ������ ����) == �����) { 
	 * ���� = ����; 
	 * } else if(���� ���� == ����) { 
	 * ���� = �����; 
	 * }
	 * 
	 * <�����or���� 2���� �������� �����ϴ� �Լ���>
	 */

	static int tmp = 0;

	public void temperature() { // 0~25�� ������ �������� ����µ� ��� ///���Ǵ� ��츦 ���ϱ� int �� �ʿ䰡 ������� void�� �ٲپ����ϴ�
		tmp = (int) (Math.random() * 26);
		
	}

	int dayCount = 1;

	public void dayAndNight() { // 1�� �������� ���� ���� �ٲ�
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				if (work() == true && dayCount <= 10) { ///����ڰ� Ŭ���� ���� ������ ��¥�� �ȹٲ�� ���
					// changeColor(); //�㳷�ٲ� �� ������ �ٲ���
					dayCount++;
				} else if (dayCount > 10) { // 2�� �ٲ𶧸��� �Ϸ簡 ī��Ʈ ��(10�� �ٲ�� 5�� ���� ������)
					timer.cancel();
				}
			}

		};
		timer.schedule(task, 60000, 2000); // 1�а���
	}

	public boolean work() {	//�ൿ ���g���� �˻�(���콺�̺�Ʈ ������)
		if() {	//���콺 Ŭ���� ������ �ൿ ���� ��
			return true;
		} else {	//���콺Ŭ�� ������ �ൿ �� ���� ��
			return false;
		}
	}
	
	public void hp() {
		if (tmp < 7) {
			// �� �ؿ��ִ� �̺�Ʈ �� Ŭ��������
			plant.setHP(plant.getHP() + 10);
			// �׷���������
			plant.setHP(plant.getHP() - 10);
		} else if (tmp > 12) {
			// ��ǳ�� Ʋ���ִ� �̺�Ʈ �� Ŭ��������
			plant.setHP(plant.getHP() + 10);
			// �׷���������
			plant.setHP(plant.getHP() - 10);
		}
	}

	public boolean isFinish() { // ���ӳ������� �Ǵ�
		if (dayCount == 11 || plant.getHP() <= 0) { // 5���� �����ų� hp�� 0�̵Ǹ� �������� ///Ȥ�� �𸣴ϱ� 0���� ���ų� �۴ٷ� ���ƽ��ϴ�
			return true;
		} else {
			return false;
		}
	}

	public void printRate() { // ������ �����ֱ�
		System.out.print(plant.getHP()); // ��������� hp�޾ƿͼ� ������ ���
	}
}
