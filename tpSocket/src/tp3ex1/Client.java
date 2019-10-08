package tp3ex1;

import java.io.BufferedReader;

//Ecrire une application qui permet au serveur d’envoyer un proverbe (parmi une liste existante) au client, chaque fois que celui-ci s’y connecte.

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

//cd C:\Users\Meriem\Desktop\javas\tpSocket\bin
//java tp3ex1.Client

public class Client {
	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("localhost",234);			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			
			BufferedReader br = new BufferedReader(isr);
			String s = br.readLine();
			
			System.out.println("Votre Proverbe "+s);
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
