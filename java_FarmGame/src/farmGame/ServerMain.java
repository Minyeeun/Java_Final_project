package farmGame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Date;

/* ServerThread 실행하는 클래스  */
public class ServerMain {
	
	public void go() throws IOException {
	
		ServerSocket ss = null;
		Socket s = null;
		
		try {
			ss = new ServerSocket(8000); // 서버 소켓 선언 
			
			while (true) {
				
				s = ss.accept(); // 클라이언트 소켓 생성 
				ServerThread st = new ServerThread(s); // 클라이언트 소켓으로 쓰레드  실행 
				st.start();
				
			}
		} finally {
			try {
				if (s != null)  s.close();
				if (ss != null) ss.close();
			} catch (Exception e) {e.printStackTrace();}
		}
	}
	
	
	public static void main(String[] args) {
		ServerMain sm = new ServerMain();
		
		try {
			sm.go();
		} catch (IOException e) {e.printStackTrace();}
		
	}
}
