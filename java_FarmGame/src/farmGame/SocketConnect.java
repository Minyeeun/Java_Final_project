package farmGame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/* FarmPanel 에서 최종점수 받아오는 + 최종 점수판 보여주는 클라이언트 소켓 */
public class SocketConnect implements Runnable{
	DataOutputStream toServer = null; // 서버에 전달  
	DataInputStream fromServer = null;  // 서버에서 받음  
	
	/* 쓰레드 */
	public void run() {
		try {
			Socket socket = new Socket("localhost", 8000);
			toServer = new DataOutputStream(socket.getOutputStream());
			fromServer = new DataInputStream(socket.getInputStream());
			
			/***************************************************/
			int score = result; // FarmPanel 에서 받아온 최종점수 
			toServer.writeInt(score); // 서버로 점수 전달   
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
