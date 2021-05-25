package tp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EndPage extends JFrame{
	
	/* 게임 종료 페이지 */
	
	/* 가본 세팅 */
	JFrame fm;
	JPanel EndPn;
	JTextArea score, hp, day;
	
	EndPage(){
		
		fm = new JFrame("Plant Game");
		EndPn = new JPanel(new GridLayout(3,2)); // 패널
		score = new JTextArea();
		hp = new JTextArea();
		day = new JTextArea();
		
		EndPn.setLayout(new BoxLayout(EndPn, BoxLayout.X_AXIS));
		EndPn.add(score);
		EndPn.add(hp);
		EndPn.add(day);
		
		fm.getContentPane().add(EndPn, BorderLayout.CENTER);	
		
		fm.setResizable(false); // 사이즈 조정 불가능  
		fm.setDefaultCloseOperation(EXIT_ON_CLOSE); // 창 끄면 프로그램 종료하도록  
		fm.setSize(400, 200); // 사이즈 설정  
		fm.setLocationRelativeTo(null); // 창 가운로  
		fm.setVisible(true); // 창 보이도록 
		
	}
	
	class ButtonClickListener implements ActionListener {
		/* 식물 선택 버튼 이벤트  */
	}
	
}
