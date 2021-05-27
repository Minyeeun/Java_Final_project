package farmGame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Main extends JFrame {
	public static void main(String[] args)  {
		FarmPanel fp = new FarmPanel();	//FarmPanel인스턴스 생성
		Thread th1 = new Thread(fp);	//FarmPanel인스턴스에 대한 스레드 생성
		th1.start();					//스레드 시작
	}
}