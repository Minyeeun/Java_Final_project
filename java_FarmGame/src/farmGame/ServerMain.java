package farmGame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/* 소켓통신을 이용하여 각 클라이언트로부터 점수 받아오는 클래스 */
public class ServerMain {
	
	public static void main(String[] args) {
		
		int allScore[] = null;
		int num = 0;
		
		try {
			new Thread(new SocketConnect()).start(); // SocketConnect 쓰레드 시작   
			ServerSocket serverSocket = new ServerSocket(8000); // 서버 소켓 생성   
			
			Socket serversocket = serverSocket.accept(); // SocketConnect 소켓 받기  
			
			DataInputStream in = new DataInputStream(serversocket.getInputStream()); // 클라이언트에서 받음  
			DataOutputStream out = new DataOutputStream(serversocket.getOutputStream()); // 클라이언트에 전달   
			// 인원 정해지면 범위 바꾸기  
			while(true) {
				
				allScore[num] = in.readInt(); // 클라이언트 score 값 저장   
				++num;
				
			}
			
			// 점수판 띄우고 클라이언트에 보내기   
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
