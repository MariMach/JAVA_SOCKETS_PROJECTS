package najlae;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class client {

	public static void main(String[] args) throws UnknownHostException, IOException {
	
		Socket client = new Socket(InetAddress.getLocalHost(),4234);
		InputStreamReader in = new InputStreamReader(client.getInputStream());
		BufferedReader reader = new BufferedReader(in);
		String str;
		while((str = reader.readLine()) != null) {
			System.out.println("iteration");
			System.out.println(str + "\n" + client.getPort() +' '+ client.getLocalPort());
		}
		System.out.println("fin");
		client.close();
		
	}
}
