package farmGame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/*심을 농작물을 화면에 표시하고 FarmPanel과 연동하는 클래스 CropPanel
 * JFrame 클래스 상속, ActionListener, Runnable 인터페이스 구현
 */
public class CropPanel extends JFrame implements ActionListener, Runnable {
	private JButton btnz[];					//심을 농작물 버튼 배열
	private boolean crop[];					//어떤 농작물을 클릭했는지 여부를 true, false로 저장하는 배열

	private Timer timer;					//농작물 인스턴스의 시간을 재는 Timer 인스턴스
	private Thread th2;						//timer의 쓰레드
	
	private String cropName;				//농작물의 이름을 저장하는 변수
	
	public boolean flag = false;
	
	//CropPanel Class의 생성자
	public CropPanel(){
		btnz = new JButton[3];						//농작물 버튼 배열 인스턴스 생성(3종류)
		crop = new boolean[3];						//농작물 클릭여부를 저장하는 배열 생성
		
		timer = new Timer();						//Timer인스턴스 생성
		
		setLayout(new GridLayout(3, 1));			//3x1 Grid Layout으로 set
		
		//3종류의 농작물 이미지를 Icon 인스턴스를 생성해 저장
		Icon ic1 = new ImageIcon("apple.png");
		Icon ic2 = new ImageIcon("sweetpotato.png");
		Icon ic3 = new ImageIcon("tomato.png");
		
		//각 버튼배열 요소에 대해 이름과 이미지를 붙여 버튼 생성
		btnz[0] = new JButton("사과",ic1);
		btnz[1] = new JButton("고구마",ic2);
		btnz[2] = new JButton("토마토",ic3);
		
		
		for(int i=0;i<btnz.length;i++)
		{
			add(btnz[i]);						//각 버튼을 화면에 추가
			btnz[i].addActionListener(this);	//각 버튼을 액션리스너에 추가
		}
	}
	
	//crop배열의 값을 set하는 메소드
	public void setCrop(String cropName)
	{
		//cropName 파라미터를 통해 어느 index를 true로해야할지 판단
		if(cropName.equals("사과"))
			crop[0] = true;
		else if(cropName.equals("고구마"))
			crop[1] = true;
		else if(cropName.equals("토마토"))
			crop[2] = true;
	}
	
	//crop배열의 값을 get하는 메소드
	public boolean getCrop(int i)
	{
		return crop[i];	//i 파라미터를 index로 해서 해당 index의 crop을 리턴
	}
	
	//농작물의 이름을 get하는 메소드
	public String getCropName()
	{
		return cropName;
	}
	
	//timer인스턴스를 get하는 메소드
	public Timer getTimer()
	{
		return timer;
	}
	
	//액션리스너 구현부분
	public void actionPerformed(ActionEvent e){
		for(int i=0;i<btnz.length;i++){
			if(e.getSource() == btnz[i])
			{
				//버튼을 클릭했을 때, 어떤 농작물을 심는지 메시지를 출력하고 해당 작물의 이름을 통해 crop배열과 cropName을 set
				JOptionPane.showMessageDialog(btnz[i], String.format("%s를 심습니다.", e.getActionCommand()));
				setCrop(btnz[i].getText());
				cropName = btnz[i].getText();
				
				/*해당 버튼에 대한 timer 스레드 생성.
				 *  CropPanel 클래스의 인스턴스는 FarmPanel 클래스에서 생성.
				 *  최종적으로는 FarmPanel의 심어지는 작물에 대한 timer 스레드
				 */
				th2 = new Thread(timer);
				th2.start();
				
				this.setVisible(false);	//액션이 완료되면 창을 닫음
				break;
			}
		}
	}
	
	//스레드 시작시 실행되는 메소드
	public void run(){
		this.setTitle("Crop Panel");
		this.setVisible(true);
		this.setSize(200,600);
	}
}
