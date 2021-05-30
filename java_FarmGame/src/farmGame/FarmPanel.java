package farmGame;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

/*밭을 화면에 표시하고 CropPanel 클래스의 인스턴스를 생성하는 클래스
 * JFrame 클래스 상속, ActionListener, Runnable 인터페이스 구현
 */
public class FarmPanel extends JFrame implements ActionListener, Runnable {
	static private int cropResult[] = new int[3]; // 수확한 농작물의 수를 저장하는 배열 사과 감자 토마토

	private JButton btnz[]; // 밭을 배치하는 버튼 배열
	private JLabel remainTime[]; // 농작물이 심어지고 수확까지or상할 때까지 남은 시간을 표시하는 라벨 배열
	private JLabel result; // 수확한 농작물의 총 갯수를 저장하는 라벨
	/*
	 * pan1:pan2 배열의 각 요소를 저장하는 패널 pan2:btnz와 remainTime을 저장하는 패널 배열 pan3:result를
	 * 저장하는 패널
	 */
	private Panel pan1, pan2[], pan3;

	private CropPanel cp[]; // 밭 버튼을 클릭할 때 심을 농작물들을 표시하는 CropPanel 클래스 배열
	private Thread th1; // cp의 스레드
	private int fail_num = 0; // 게임 종료를 위한 변수  
	private boolean stop = false; // 쓰레드 종료를 위한 
	private ImageIcon ic[] = new ImageIcon[20]; // 밭의 이미지를 저장하는 Icon 배열(비어있는 밭, 농작물 심은 이미지, 수확대기 이미지, 상한 농작물 이미지)

	// FarmPanel class의 생성자
	public FarmPanel() {
		cp = new CropPanel[16]; // CropPanel 인스턴스 배열 생성
		btnz = new JButton[16]; // 밭 버튼 배열 인스턴스 생성
		remainTime = new JLabel[16]; // 남은시간 배열 인스턴스 생성

		pan1 = new Panel(new GridLayout(4, 4)); // pan1을 4x4 Grid Layout set
		pan2 = new Panel[16]; // pan2 패널 인스턴스 16개 생성
		pan3 = new Panel(new FlowLayout()); // pan3를 Flow Layout set

		// Icon 인스턴스 생성
		ic[0] = new ImageIcon("field.png"); // 비어있는 밭
		ic[1] = new ImageIcon("apple_1.png");
		ic[2] = new ImageIcon("apple_2.png");
		ic[3] = new ImageIcon("apple_3.png");
		ic[4] = new ImageIcon("apple_4.png");
		ic[5] = new ImageIcon("apple_5.png");
		ic[6] = new ImageIcon("apple_6.png"); // 사과밖에 안했지만 감자나 토마토 추가

		ic[7] = new ImageIcon("sweetpotato_1.png");
		ic[8] = new ImageIcon("sweetpotato_2.png");
		ic[9] = new ImageIcon("sweetpotato_3.png");
		ic[10] = new ImageIcon("sweetpotato_4.png");
		ic[11] = new ImageIcon("sweetpotato_5.png");
		ic[12] = new ImageIcon("sweetpotato_6.png");

		ic[13] = new ImageIcon("tomato_1.png");
		ic[14] = new ImageIcon("tomato_2.png");
		ic[15] = new ImageIcon("tomato_3.png");
		ic[16] = new ImageIcon("tomato_4.png");
		ic[17] = new ImageIcon("tomato_5.png");
		ic[18] = new ImageIcon("tomato_6.png");

		ic[19] = new ImageIcon("fail.png"); // 상한 농작물

		for (int i = 0; i < btnz.length; i++) {
			cp[i] = new CropPanel(); // cp의 각 인스턴스를 생성
			pan2[i] = new Panel(new BorderLayout()); // pan2의 각 요소들을 Border Layout으로 set

			btnz[i] = new JButton("밭" + (i + 1), ic[0]); // 버튼요소들에 밭이름과 이미지를 붙여 버튼 생성
			btnz[i].addActionListener(this); // 각 버튼들을 액션리스너에 추가
			remainTime[i] = new JLabel("비어있음"); // 남은 시간의 각 라벨들 생성(초기 표시 문자열 : 비어있음)
			pan2[i].add(btnz[i], BorderLayout.CENTER); // 밭 버튼을 가운데 추가
			pan2[i].add(remainTime[i], BorderLayout.SOUTH); // 남은시간 라벨을 아래에 추가
			pan1.add(pan2[i]); // Border Layout으로 set된 pan2를 pan1에 추가
		}

		result = new JLabel(getCropResult()); // result 라벨 생성
		pan3.add(result); // pan3에 result 라벨 추가

		setLayout(new BorderLayout()); // 전체화면을 Border Layout set
		add(pan1, BorderLayout.CENTER); // pan2을 중앙에 추가
		add(pan3, BorderLayout.SOUTH); // pan3을 아래쪽에 추가
	}

	// 수확한 농작물의 각 갯수를 get하는 메소드
	public String getCropResult() {
		return "사과 : " + cropResult[0] + "개,  고구마: " + cropResult[1] + "개,  토마토: " + cropResult[2] + "개";
	}
	
	// 수확한 농작물로 점수를 할당하여 소켓에 전송하는 메소드
	public void return_result() throws IOException {
		int score = cropResult[0] * 3 + cropResult[1] * 2 + cropResult[2]; // 총점수
		SocketConnect.getInstance().SaveRank(score); // 소켓에 전송  
	}
	
	// 게임 종료 
	public boolean finish() {
		if (fail_num >= 5) {
			return true;
		}
		return false;
	}

	// 액션리스너 구현부분
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < btnz.length; i++) {
			// 버튼을 클릭했을 때
			if (e.getSource() == btnz[i]) {
				// 해당버튼이 농작물을 이미 키우는 중일 때
				if (!((btnz[i].getIcon() == ic[0]) || (btnz[i].getIcon() == ic[19]) || (btnz[i].getIcon() == ic[6])
						|| (btnz[i].getIcon() == ic[12]) || (btnz[i].getIcon() == ic[18]))) {
					// 생산중이라는 메시지를 출력(이미 키우는 농작물에 중복으로 농작물을 심는 것을 방지)
					JOptionPane.showMessageDialog(btnz[i], String.format("%s은/는 농작물 생산중입니다.", e.getActionCommand()));
					break;
				}

				for (int j = 6; j <= 18; j += 6) {
					// 해당버튼이 수확대기 상태일 때
					if ((btnz[i].getIcon() == ic[6]) || (btnz[i].getIcon() == ic[12])
							|| (btnz[i].getIcon() == ic[18])) {
						// 농작물을 수확한다는 메시지 출력
						JOptionPane.showMessageDialog(btnz[i],
								String.format("%s의 %s을 수확합니다.", e.getActionCommand(), cp[i].getCropName()));
						cp[i] = new CropPanel(); // 해당 밭의 cp 인스턴스 재생성(초기화)
						cropResult[j / 6 - 1]++; // 수확한 농작물의 갯수 증가 사과밖에 없어서 0
						result.setText(getCropResult()); // result 라벨을 새로 set(변경된 값 반영)
						remainTime[i].setText("비어있음"); // remainTime 라벨을 비어있음으로 set
						return;
					}
				}
				// 해당 버튼의 농작물이 상한 상태일 때
				if (btnz[i].getIcon() == ic[19]) {
					// 밭을 갈아 엎는다는 메시지 출력
					JOptionPane.showMessageDialog(btnz[i], String.format("%s을/를 갈아 엎었습니다.", e.getActionCommand()));
					cp[i] = new CropPanel(); // 해당 밭의 cp 인스턴스 재생성(초기화)
					remainTime[i].setText("비어있음"); // remainTime 라벨을 비어있음으로 set
					fail_num++; // 실패한 경우 추가
					break;
				}
				// 해당 버튼이 비어있는 밭일 때, 밭 이름과 작물을 심어주세요라는 메시지 출력
				JOptionPane.showMessageDialog(btnz[i], String.format("%s: 작물을 심어주세요.", e.getActionCommand()));
				th1 = new Thread(cp[i]); // 해당 밭의 cp인스턴스에 대해 스레드 생성
				th1.start(); // 스레드 시작
				break;
			}
		}
	}

	// 스레드 시작시 실행되는 메소드
	public void run() {
		this.setTitle("Farm Panel");
		this.setVisible(true);
		this.setSize(1300, 1300);
		this.setLocation(200, 0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 스레드가 종료될 때까지 계속 반복
		while (!stop) {
			/*
			 * 각 밭에 대한 농작물의 상태를 나타내기 위한 for문 모든 농작물을 처음 심고 10초 동안 생산 중 상태 이며 10초 후에는 수확 대기
			 * 상태, 20초 후에는 작물이 상한다.
			 */
			for (int i = 0; i < cp.length; i++) {

				if (cp[i].getCrop(0) == true) {
					// cp i의 timer값이 10초이상인 경우(10~20)
					if (cp[i].getTimer().getTime() > 30) {
						// 버튼 이미지를 생산중인 이미지로
						btnz[i].setIcon(ic[1]);
						// 수확까지 남은 시간 표시
						remainTime[i].setText("수확까지 남은시간 : " + (cp[i].getTimer().getTime() - 10));
					} else if (cp[i].getTimer().getTime() > 25) {
						// 버튼 이미지를 생산중인 이미지로
						btnz[i].setIcon(ic[2]);
						// 수확까지 남은 시간 표시
						remainTime[i].setText("수확까지 남은시간 : " + (cp[i].getTimer().getTime() - 10));
					} else if (cp[i].getTimer().getTime() > 20) {
						// 버튼 이미지를 생산중인 이미지로
						btnz[i].setIcon(ic[3]);
						// 수확까지 남은 시간 표시
						remainTime[i].setText("수확까지 남은시간 : " + (cp[i].getTimer().getTime() - 10));
					} else if (cp[i].getTimer().getTime() > 15) {
						// 버튼 이미지를 생산중인 이미지로
						btnz[i].setIcon(ic[4]);
						// 수확까지 남은 시간 표시
						remainTime[i].setText("수확까지 남은시간 : " + (cp[i].getTimer().getTime() - 10));
					}

					else if ((10 < cp[i].getTimer().getTime()) && (cp[i].getTimer().getTime() <= 15)) {
						// 버튼 이미지를 수확대기 이미지로
						btnz[i].setIcon(ic[5]);
						// 상할 때까지 남은 시간 표시
						remainTime[i].setText("수확까지 남은시간 : " + (cp[i].getTimer().getTime() - 10));
					} else if ((0 < cp[i].getTimer().getTime()) && (cp[i].getTimer().getTime() <= 10)) {
						// 버튼 이미지를 수확대기 이미지로
						btnz[i].setIcon(ic[6]);
						// 상할 때까지 남은 시간 표시
						remainTime[i].setText("상할 때까지 남은시간 : " + cp[i].getTimer().getTime());
					}
					// cp i의 timer값이 0이하인 경우
					else if (cp[i].getTimer().getTime() <= 0) {
						// 버튼 이미지를 상한 농작물 이미지로
						btnz[i].setIcon(ic[19]);
						// remainTime 라벨에 작물 상함으로 set
						remainTime[i].setText("작물 상함.");
					}
				}

				// 밭 i의 심은 농작물이 브로콜리인 경우
				else if (cp[i].getCrop(1) == true) {
					// cp i의 timer값이 10초이상인 경우(10~20)
					if (cp[i].getTimer().getTime() > 30) {
						// 버튼 이미지를 생산중인 이미지로
						btnz[i].setIcon(ic[7]);
						// 수확까지 남은 시간 표시
						remainTime[i].setText("수확까지 남은시간 : " + (cp[i].getTimer().getTime() - 10));
					} else if (cp[i].getTimer().getTime() > 25) {
						// 버튼 이미지를 생산중인 이미지로
						btnz[i].setIcon(ic[8]);
						// 수확까지 남은 시간 표시
						remainTime[i].setText("수확까지 남은시간 : " + (cp[i].getTimer().getTime() - 10));
					} else if (cp[i].getTimer().getTime() > 20) {
						// 버튼 이미지를 생산중인 이미지로
						btnz[i].setIcon(ic[9]);
						// 수확까지 남은 시간 표시
						remainTime[i].setText("수확까지 남은시간 : " + (cp[i].getTimer().getTime() - 10));
					} else if (cp[i].getTimer().getTime() > 15) {
						// 버튼 이미지를 생산중인 이미지로
						btnz[i].setIcon(ic[10]);
						// 수확까지 남은 시간 표시
						remainTime[i].setText("수확까지 남은시간 : " + (cp[i].getTimer().getTime() - 10));
					}

					else if ((10 < cp[i].getTimer().getTime()) && (cp[i].getTimer().getTime() <= 15)) {
						// 버튼 이미지를 수확대기 이미지로
						btnz[i].setIcon(ic[11]);
						// 상할 때까지 남은 시간 표시
						remainTime[i].setText("수확까지 남은시간 : " + (cp[i].getTimer().getTime() - 10));
					} else if ((0 < cp[i].getTimer().getTime()) && (cp[i].getTimer().getTime() <= 10)) {
						// 버튼 이미지를 수확대기 이미지로
						btnz[i].setIcon(ic[12]);
						// 상할 때까지 남은 시간 표시
						remainTime[i].setText("상할 때까지 남은시간 : " + cp[i].getTimer().getTime());
					}
					// cp i의 timer값이 0이하인 경우
					else if (cp[i].getTimer().getTime() <= 0) {
						// 버튼 이미지를 상한 농작물 이미지로
						btnz[i].setIcon(ic[19]);
						// remainTime 라벨에 작물 상함으로 set
						remainTime[i].setText("작물 상함.");
					}
				}
				// 밭 i의 심은 농작물이 배추인 경우
				else if (cp[i].getCrop(2) == true) {
					// cp i의 timer값이 10초이상인 경우(10~20)
					if (cp[i].getTimer().getTime() > 30) {
						// 버튼 이미지를 생산중인 이미지로
						btnz[i].setIcon(ic[13]);
						// 수확까지 남은 시간 표시
						remainTime[i].setText("수확까지 남은시간 : " + (cp[i].getTimer().getTime() - 10));
					} else if (cp[i].getTimer().getTime() > 25) {
						// 버튼 이미지를 생산중인 이미지로
						btnz[i].setIcon(ic[14]);
						// 수확까지 남은 시간 표시
						remainTime[i].setText("수확까지 남은시간 : " + (cp[i].getTimer().getTime() - 10));
					} else if (cp[i].getTimer().getTime() > 20) {
						// 버튼 이미지를 생산중인 이미지로
						btnz[i].setIcon(ic[15]);
						// 수확까지 남은 시간 표시
						remainTime[i].setText("수확까지 남은시간 : " + (cp[i].getTimer().getTime() - 10));
					} else if (cp[i].getTimer().getTime() > 15) {
						// 버튼 이미지를 생산중인 이미지로
						btnz[i].setIcon(ic[16]);
						// 수확까지 남은 시간 표시
						remainTime[i].setText("수확까지 남은시간 : " + (cp[i].getTimer().getTime() - 10));
					}

					else if ((10 < cp[i].getTimer().getTime()) && (cp[i].getTimer().getTime() <= 15)) {
						// 버튼 이미지를 수확대기 이미지로
						btnz[i].setIcon(ic[17]);
						// 상할 때까지 남은 시간 표시
						remainTime[i].setText("수확까지 남은시간 : " + (cp[i].getTimer().getTime() - 10));
					} else if ((0 < cp[i].getTimer().getTime()) && (cp[i].getTimer().getTime() <= 10)) {
						// 버튼 이미지를 수확대기 이미지로
						btnz[i].setIcon(ic[18]);
						// 상할 때까지 남은 시간 표시
						remainTime[i].setText("상할 때까지 남은시간 : " + cp[i].getTimer().getTime());
					}
					// cp i의 timer값이 0이하인 경우
					else if (cp[i].getTimer().getTime() <= 0) {
						// 버튼 이미지를 상한 농작물 이미지로
						btnz[i].setIcon(ic[19]);
						// remainTime 라벨에 작물 상함으로 set
						remainTime[i].setText("작물 상함.");
					}
				}
				// 밭 i의 심은 농작물이 아무것도 없는 경우
				else
					// 해당 버튼을 비어있는 이미지로
					btnz[i].setIcon(ic[0]);
			} 
			
			if(finish() == true){
				try {
					return_result();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // 현재까지 점수 소켓에 전송
				stop = true;
			}
			
		}
	}
}
