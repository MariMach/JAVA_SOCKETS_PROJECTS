package tp3ex2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class httpClient {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("localhost",8000);			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			
			BufferedReader br = new BufferedReader(isr);
			String s = br.readLine();
			
			System.out.println("Serveur HTTP "+s);
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}