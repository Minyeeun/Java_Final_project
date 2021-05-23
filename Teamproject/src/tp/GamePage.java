package team_project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePage extends JFrame{
	
	/* 게임 페이지 */
	
	/* 가본 세팅 */
	JFrame fm;
	JPanel infoPn, imagePn, playPn, entire; 
	JTextArea plantInfo, envirInfo; 
	JButton light, wind, water;

	GamePage(){
		
		fm = new JFrame("Plant Game");
		infoPn = new JPanel(new GridLayout(1,2)); // 정보 보여주는  
		imagePn = new JPanel(); // 식물 그림 보여주는  
		playPn = new JPanel(); // 클릭 버튼 이용해 게임하는  
		entire = new JPanel(); // panel 묶기  
		plantInfo = new JTextArea(); // 식물 정보  
		envirInfo = new JTextArea(); // 환경 정보 
		light = new JButton("light"); // 빛 버튼
		wind = new JButton("wind"); // 선풍기 버튼   
		water = new JButton("water"); // 물 버튼   
		
		infoPn.setLayout(new BoxLayout(infoPn, BoxLayout.X_AXIS));
		infoPn.setPreferredSize(new Dimension(500, 200)); // 크키 조절  
		infoPn.add(plantInfo);
		infoPn.add(envirInfo);
		
		imagePn.setLayout(new BoxLayout(imagePn, BoxLayout.X_AXIS));
		imagePn.setPreferredSize(new Dimension(500, 500));
		
		playPn.setLayout(new BoxLayout(playPn, BoxLayout.X_AXIS));
		playPn.setPreferredSize(new Dimension(500, 100));
		playPn.add(light);
		playPn.add(wind);
		playPn.add(water);
		
		entire.setLayout(new BoxLayout(entire, BoxLayout.Y_AXIS));
		entire.add(infoPn);
		entire.add(imagePn);
		entire.add(playPn);
		
		fm.getContentPane().add(entire, BorderLayout.CENTER);
		
		fm.setResizable(false); // 사이즈 조정 불가능  
		fm.setDefaultCloseOperation(EXIT_ON_CLOSE); // 창 끄면 프로그램 종료하도록  
		fm.setSize(500, 800); // 사이즈 설정  
		fm.setLocationRelativeTo(null); // 창 가운로  
		fm.setVisible(true); // 창 보이도록 
		
	}
	
	class ButtonClickListener implements ActionListener {
		/* 빛 선풍기 물 버튼 선택시 hp 변경   */
		
	}
	
}
