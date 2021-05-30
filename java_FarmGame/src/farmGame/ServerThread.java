package farmGame;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JOptionPane;

/* 서버 쓰레드 */
public class ServerThread extends Thread {
		
	Socket socket; // 소켓 선언  
	BufferedReader br;// 소켓에서 값 받아오기
	int num = 0; // 기록용 
	String ID = ""; // 사용자 이름 
	String s_score = ""; // 사용자 점수 ( 문자열 )
	int score = 0; // 사용자 점수 ( 슷자  )
	ArrayObject[] result = new ArrayObject[10]; // 저장용 배열  
	
	// 클라이언트와 연결하기  
	ServerThread(Socket s) {
		this.socket = s;

	}
	
	public void run() {
		save();
		JOptionPane.showMessageDialog(null, result, "Final Score",  JOptionPane.INFORMATION_MESSAGE); // 결과판 보여주기  
		
	}
	
	/* 오브젝트 배열 선언  */
	public class ArrayObject implements Comparable<ArrayObject>{
		String ID;
		int score;
		
		ArrayObject(String ID, int score){
			this.ID = ID;
			this.score = score;
		}

		@Override
		public int compareTo(ArrayObject o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public void save() {
		while(true) { 
			try {
				br = new BufferedReader(new InputStreamReader(this.socket.getInputStream())); // 소켓에서 값 받아오기  
				ID  = br.readLine(); // 소켓에서 id 받아오
				s_score = br.readLine(); // 소켓에서 점수 받아오기  			
				score = Integer.parseInt(s_score); // string -> int 	
			
				result[num] =new ArrayObject(ID, score); // 배열에 넣기  
				Arrays.sort(result, Comparator.reverseOrder()); // 올림차순으로 정렬  
			
				 ++num;
			} catch (Exception e) {}
		}
	}
	
}
