package SocketsMY;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

// read() peremt de recevoir un entier
// write() permet d envoyer un entier

//cd C:\Users\Meriem\Desktop\javas\tpSocket\bin
//java SocketsMY.Client

public class Client {
	
	public static void main(String[] args) throws IOException, UnknownHostException {
		
		Socket socket = new Socket("localhost", 9999);
		
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Donner un nombre :  ");
		int nb = sc.nextInt();
		os.write(nb);
		int rep=is.read();
		System.out.println("Resultat est : " +rep);
		
		socket.close();
	}

}
