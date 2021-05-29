package farmGame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Comparator;

/* 서버 쓰레드 */
public class ServerThread extends Thread {
		
	Socket socket; // 소켓 선언  
	DataInputStream fromClient;// 소켓에서 값 받아오기 
	Integer[] list; // 모든 클라이언트 점수 기록용 리스트 
	int num = 0; // 기록용 
	
	// 클라이언트와 연결하기  
	ServerThread(Socket s) {
		this.socket = s;
	}
	
	public void run() {
		try {
			read();
		} catch (IOException e) {}
	}
	
	
	private void read() throws IOException {
		
		while (true) {
			fromClient = new DataInputStream(this.socket.getInputStream()); // 클라이언트 소켓에서 값 받아오기  
			int score = fromClient.readInt(); 
		
			list[num] = score; // 리스트에 추가
			
			Arrays.sort(list, Comparator.reverseOrder()); // 올림차순으로 정렬  
				
		}
	}
}
