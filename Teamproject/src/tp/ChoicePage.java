package tp;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoicePage extends JFrame implements MouseListener{
	
	/* �Ĺ��� ���� ������ */
	
	/* ���� ���� */
	JFrame fm; 
	JLabel label;
	JPanel ChoicePn;
	JButton appletree, option2, option3, option4;
	
	ChoicePage(){
		
		fm = new JFrame("Plant Game");
		ChoicePn = new JPanel(); // �г�
		label = new JLabel("Choose your plant!");
		appletree = new JButton("appletree");
		option2 = new JButton("option2");  
		option3 = new JButton("option3");  
		option4 = new JButton("option4"); 
		
		// ��ư ������ ����   
		appletree.setPreferredSize(new Dimension(80, 80));  
		option2.setPreferredSize(new Dimension(80, 80)); 
		option3.setPreferredSize(new Dimension(80, 80));
		option4.setPreferredSize(new Dimension(80, 80));
		
		ChoicePn.add(appletree);
		ChoicePn.add(option2);
		ChoicePn.add(option3);
		ChoicePn.add(option4);
		
		fm.getContentPane().add(ChoicePn);
		
		fm.setResizable(false); // ������ ���� �Ұ���  
		fm.setDefaultCloseOperation(EXIT_ON_CLOSE); // â ���� ���α׷� �����ϵ���  
		fm.setSize(400, 150); // ������ ����  
		fm.setLocationRelativeTo(null); // â �����  
		fm.setVisible(true); // â ���̵��� 
		
		
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
		�Ĺ� ���� ��ư �̺�Ʈ 
	} */
	
}
