package tp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage extends JFrame implements MouseListener{
	
	/*�г��� ���� ������ */
	
	/* ���� ���� */
	JFrame fm;
	JPanel loginPn; 
	JTextField Ntext;
	JButton loginBtn;
	
	LoginPage(){
		
		fm = new JFrame("Plant Game");
		loginPn = new JPanel();// �г�
		Ntext = new JTextField(); // ����ڰ� �г��� �Է��ϴ� ����  
		loginBtn = new JButton("Click"); // �α��� ��ư  
		
		loginBtn.setPreferredSize(new Dimension(50, 50)); // ��ư ������ ����  
		Ntext.setPreferredSize(new Dimension(180, 50)); // �Է�â ������ ����  
		loginPn.add(new JLabel("Nickname"));		
		loginPn.add(Ntext);
		loginPn.add(loginBtn);
		
		fm.getContentPane().add(loginPn, BorderLayout.CENTER);	
		
		fm.setResizable(false); // ������ ���� �Ұ���  
		fm.setDefaultCloseOperation(EXIT_ON_CLOSE); // â ���� ���α׷� �����ϵ���  
		fm.setSize(400, 150); // ������ ����  
		fm.setLocationRelativeTo(null); // â �����  
		fm.setVisible(true); // â ���̵��� 
		
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
