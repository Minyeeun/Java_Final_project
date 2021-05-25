package tp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePage extends JFrame implements MouseListener{
	
	/* ���� ������ */
	
	/* ���� ���� */
	JFrame fm;
	JPanel infoPn, imagePn, playPn, entire; 
	JTextArea plantInfo, envirInfo; 
	JButton light, wind, water;

	GamePage(){
		
		fm = new JFrame("Plant Game");
		infoPn = new JPanel(new GridLayout(1,2)); // ���� �����ִ�  
		imagePn = new JPanel(); // �Ĺ� �׸� �����ִ�  
		playPn = new JPanel(); // Ŭ�� ��ư �̿��� �����ϴ�  
		entire = new JPanel(); // panel ����  
		plantInfo = new JTextArea(); // �Ĺ� ����  
		envirInfo = new JTextArea(); // ȯ�� ���� 
		light = new JButton("light"); // �� ��ư
		wind = new JButton("wind"); // ��ǳ�� ��ư   
		water = new JButton("water"); // �� ��ư   
		
		infoPn.setLayout(new BoxLayout(infoPn, BoxLayout.X_AXIS));
		infoPn.setPreferredSize(new Dimension(500, 200)); // ũŰ ����  
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
		
		fm.setResizable(false); // ������ ���� �Ұ���  
		fm.setDefaultCloseOperation(EXIT_ON_CLOSE); // â ���� ���α׷� �����ϵ���  
		fm.setSize(500, 800); // ������ ����  
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
