package tp;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoicePage extends JFrame implements MouseListener{
	
	/* 식물종 선택 페이지 */
	
	/* 가본 세팅 */
	JFrame fm; 
	JLabel label;
	JPanel ChoicePn;
	JButton appletree, option2, option3, option4;
	
	ChoicePage(){
		
		fm = new JFrame("Plant Game");
		ChoicePn = new JPanel(); // 패널
		label = new JLabel("Choose your plant!");
		appletree = new JButton("appletree");
		option2 = new JButton("option2");  
		option3 = new JButton("option3");  
		option4 = new JButton("option4"); 
		
		// 버튼 사이즈 조정   
		appletree.setPreferredSize(new Dimension(80, 80));  
		option2.setPreferredSize(new Dimension(80, 80)); 
		option3.setPreferredSize(new Dimension(80, 80));
		option4.setPreferredSize(new Dimension(80, 80));
		
		ChoicePn.add(appletree);
		ChoicePn.add(option2);
		ChoicePn.add(option3);
		ChoicePn.add(option4);
		
		fm.getContentPane().add(ChoicePn);
		
		fm.setResizable(false); // 사이즈 조정 불가능  
		fm.setDefaultCloseOperation(EXIT_ON_CLOSE); // 창 끄면 프로그램 종료하도록  
		fm.setSize(400, 150); // 사이즈 설정  
		fm.setLocationRelativeTo(null); // 창 가운로  
		fm.setVisible(true); // 창 보이도록 
		
		
		appletree.addMouseListener((MouseListener) appletree);
		
		
		

	
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/* class ButtonClickListener implements ActionListener {
		식물 선택 버튼 이벤트 
	} */
	
}
