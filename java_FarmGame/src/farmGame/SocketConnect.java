package farmGame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JOptionPane;

/* FarmPanel 에서 id 와 최종점수 받아오는 클래스 */
public class SocketConnect {
	Socket socket = null; // 소켓 선언  
	PrintWriter pw = null; // ServerThread 로 전달하기 위해  
	
	private static SocketConnect instance = new SocketConnect();
	
	public SocketConnect() {
		try {
			socket = new Socket(); 
			pw=new PrintWriter(socket.getOutputStream(), true);
		} catch (Exception e) {}
	}
	
	/* 인스턴트 받기 */
	public static SocketConnect getInstance() {
		return instance;
	}
	
	/* 최종 점수 저장하기 */
	public void SaveRank(int sc) throws IOException{
		
		String ID="";
		String score = "";
		
		while(true) {
			try {
				ID = (String)JOptionPane.showInputDialog("Input ID"); // 사용자에게 점수 받기  
				
				score = String.valueOf(sc);
				pw.println(ID); // 서버에 아이디 보내
				pw.println(score);	// 서버에 점수 보내기  
			} catch(NullPointerException e) { break; }

		}
	}
	
}
