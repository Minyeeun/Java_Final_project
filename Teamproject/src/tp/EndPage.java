package tp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EndPage extends JFrame implements MouseListener{
	
	/* ���� ���� ������ */
	
	/* ���� ���� */
	JFrame fm;
	JPanel EndPn;
	JTextArea score, hp, day;
	
	EndPage(){
		
		fm = new JFrame("Plant Game");
		EndPn = new JPanel(new GridLayout(3,2)); // �г�
		score = new JTextArea();
		hp = new JTextArea();
		day = new JTextArea();
		
		EndPn.setLayout(new BoxLayout(EndPn, BoxLayout.X_AXIS));
		EndPn.add(score);
		EndPn.add(hp);
		EndPn.add(day);
		
		fm.getContentPane().add(EndPn, BorderLayout.CENTER);	
		
		fm.setResizable(false); // ������ ���� �Ұ���  
		fm.setDefaultCloseOperation(EXIT_ON_CLOSE); // â ���� ���α׷� �����ϵ���  
		fm.setSize(400, 200); // ������ ����  
		fm.setLocationRelativeTo(null); // â �����  
		fm.setVisible(true); // â ���̵��� 
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/* class ButtonClickListener implements ActionListener {
	�Ĺ� ���� ��ư �̺�Ʈ 
} */

}
