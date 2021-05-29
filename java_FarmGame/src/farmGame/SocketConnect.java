package farmGame;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/* FarmPanel 에서 최종점수 받아오는 클래스 */
public class SocketConnect {
	Socket socket = null; // 소켓 선언  
	DataOutputStream toServer = null; // ServerThread 로 전달하기 위해  
	
	private static SocketConnect instance = new SocketConnect();
	
	public SocketConnect() {
		try {
			socket = new Socket(); 
		} catch (Exception e) {}
	}
	
	/* 인스턴트 받기 */
	public static SocketConnect getInstance() {
		return instance;
	}
	
	/* 최종 점수 저장하기 */
	public void SaveRank(int sc) throws IOException{
		toServer = new DataOutputStream(socket.getOutputStream());
		toServer.writeInt(sc); // 서버로 점수 보내기 
	}
}
