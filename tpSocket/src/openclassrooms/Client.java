package openclassrooms;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//Client
//Socket socket = new Socket(adresse_distante, port_distant)
//Socket socket = new Socket(adresse_distante, port_distant, adress_locale, port_locale);

//cd C:\Users\Meriem\Desktop\javas\tpSocket\bin
//java openclassrooms.Client

public class Client {
		public static void main(String[] args) throws UnknownHostException, IOException {
			
			Socket socket = new Socket(InetAddress.getLocalHost(),2009);
			socket.close();
		}


}
