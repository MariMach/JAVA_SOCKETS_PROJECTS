package openclassrooms;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//cd C:\Users\Meriem\Desktop\javas\tpSocket\bin
//java openclassrooms.Client3

public class Client3 {
	public static void main(String[] args) {
		
		Socket socket;
		
		try {
			socket = new Socket("localhost", 2009);
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
