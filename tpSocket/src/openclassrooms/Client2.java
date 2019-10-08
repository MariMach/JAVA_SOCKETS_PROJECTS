package openclassrooms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


//readInt() permettant de lire un entier
//readLine() nous permet de lire une chaîne de caractères
//readDouble() permettant de lire un nombre de type double

//mais si l'on veut que plus que deux puissent communiquer 
//entre eux à la fois, comment faire ? D'où la nécessité d'utiliser les Threads.
public class Client2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		Socket socket = new Socket(InetAddress.getLocalHost(),2009);
		System.out.println("Demande de connexion");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		String message_distant;
		while((message_distant = in.readLine()) != null) {
			System.out.println(message_distant);
		}
			
		socket.close();
	}

}
 