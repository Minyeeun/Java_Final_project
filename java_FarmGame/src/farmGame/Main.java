package farmGame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Main extends JFrame {
	public static void main(String[] args)  {
		FarmPanel fp = new FarmPanel();	//FarmPanel�ν��Ͻ� ����
		Thread th1 = new Thread(fp);	//FarmPanel�ν��Ͻ��� ���� ������ ����
		th1.start();					//������ ����
	}
}