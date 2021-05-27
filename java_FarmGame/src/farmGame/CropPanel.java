package farmGame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/*���� ���۹��� ȭ�鿡 ǥ���ϰ� FarmPanel�� �����ϴ� Ŭ���� CropPanel
 * JFrame Ŭ���� ���, ActionListener, Runnable �������̽� ����
 */
public class CropPanel extends JFrame implements ActionListener, Runnable {
	private JButton btnz[];					//���� ���۹� ��ư �迭
	private boolean crop[];					//� ���۹��� Ŭ���ߴ��� ���θ� true, false�� �����ϴ� �迭

	private Timer timer;					//���۹� �ν��Ͻ��� �ð��� ��� Timer �ν��Ͻ�
	private Thread th2;						//timer�� ������
	
	private String cropName;				//���۹��� �̸��� �����ϴ� ����
	
	public boolean flag = false;
	
	//CropPanel Class�� ������
	public CropPanel(){
		btnz = new JButton[3];						//���۹� ��ư �迭 �ν��Ͻ� ����(3����)
		crop = new boolean[3];						//���۹� Ŭ�����θ� �����ϴ� �迭 ����
		
		timer = new Timer();						//Timer�ν��Ͻ� ����
		
		setLayout(new GridLayout(3, 1));			//3x1 Grid Layout���� set
		
		//3������ ���۹� �̹����� Icon �ν��Ͻ��� ������ ����
		Icon ic1 = new ImageIcon("apple.png");
		Icon ic2 = new ImageIcon("potato.png");
		Icon ic3 = new ImageIcon("tomato.png");
		
		//�� ��ư�迭 ��ҿ� ���� �̸��� �̹����� �ٿ� ��ư ����
		btnz[0] = new JButton("���",ic1);
		btnz[1] = new JButton("����",ic2);
		btnz[2] = new JButton("�丶��",ic3);
		
		
		for(int i=0;i<btnz.length;i++)
		{
			add(btnz[i]);						//�� ��ư�� ȭ�鿡 �߰�
			btnz[i].addActionListener(this);	//�� ��ư�� �׼Ǹ����ʿ� �߰�
		}
	}
	
	//crop�迭�� ���� set�ϴ� �޼ҵ�
	public void setCrop(String cropName)
	{
		//cropName �Ķ���͸� ���� ��� index�� true���ؾ����� �Ǵ�
		if(cropName.equals("���"))
			crop[0] = true;
		else if(cropName.equals("����"))
			crop[1] = true;
		else if(cropName.equals("�丶��"))
			crop[2] = true;
	}
	
	//crop�迭�� ���� get�ϴ� �޼ҵ�
	public boolean getCrop(int i)
	{
		return crop[i];	//i �Ķ���͸� index�� �ؼ� �ش� index�� crop�� ����
	}
	
	//���۹��� �̸��� get�ϴ� �޼ҵ�
	public String getCropName()
	{
		return cropName;
	}
	
	//timer�ν��Ͻ��� get�ϴ� �޼ҵ�
	public Timer getTimer()
	{
		return timer;
	}
	
	//�׼Ǹ����� �����κ�
	public void actionPerformed(ActionEvent e){
		for(int i=0;i<btnz.length;i++){
			if(e.getSource() == btnz[i])
			{
				//��ư�� Ŭ������ ��, � ���۹��� �ɴ��� �޽����� ����ϰ� �ش� �۹��� �̸��� ���� crop�迭�� cropName�� set
				JOptionPane.showMessageDialog(btnz[i], String.format("%s�� �ɽ��ϴ�.", e.getActionCommand()));
				setCrop(btnz[i].getText());
				cropName = btnz[i].getText();
				
				/*�ش� ��ư�� ���� timer ������ ����.
				 *  CropPanel Ŭ������ �ν��Ͻ��� FarmPanel Ŭ�������� ����.
				 *  ���������δ� FarmPanel�� �ɾ����� �۹��� ���� timer ������
				 */
				th2 = new Thread(timer);
				th2.start();
				
				this.setVisible(false);	//�׼��� �Ϸ�Ǹ� â�� ����
				break;
			}
		}
	}
	
	//������ ���۽� ����Ǵ� �޼ҵ�
	public void run(){
		this.setTitle("Crop Panel");
		this.setVisible(true);
		this.setSize(200,600);
	}
}
