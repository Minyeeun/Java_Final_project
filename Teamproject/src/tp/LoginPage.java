package tp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage extends JFrame implements MouseListener{
	
	/*닉네임 설정 페이지 */
	
	/* 가본 세팅 */
	JFrame fm;
	JPanel loginPn; 
	JTextField Ntext;
	JButton loginBtn;
	
	LoginPage(){
		
		fm = new JFrame("Plant Game");
		loginPn = new JPanel();// 패널
		Ntext = new JTextField(); // 사용자가 닉네임 입력하는 공간  
		loginBtn = new JButton("Click"); // 로그인 버튼  
		
		loginBtn.setPreferredSize(new Dimension(50, 50)); // 버튼 사이즈 조정  
		Ntext.setPreferredSize(new Dimension(180, 50)); // 입력창 사이즈 조정  
		loginPn.add(new JLabel("Nickname"));		
		loginPn.add(Ntext);
		loginPn.add(loginBtn);
		
		fm.getContentPane().add(loginPn, BorderLayout.CENTER);	
		
		fm.setResizable(false); // 사이즈 조정 불가능  
		fm.setDefaultCloseOperation(EXIT_ON_CLOSE); // 창 끄면 프로그램 종료하도록  
		fm.setSize(400, 150); // 사이즈 설정  
		fm.setLocationRelativeTo(null); // 창 가운로  
		fm.setVisible(true); // 창 보이도록 
		
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
}
