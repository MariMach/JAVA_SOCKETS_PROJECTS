package cours;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//cd C:\Users\Meriem\Desktop\javas\tpSocket\bin
//java cours.Portecoute

public class Portecoute {
	
	public static void main(String[] args) {
		String host = "localhost";
		try {
			InetAddress adr = InetAddress.getByName(host);
			for(int i = 1; i < 1024; i++) {
				try {
					Socket socket = new Socket(adr, i);
					System.out.println("Il y a un serveur sur le port " + i + " de "+ host);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
