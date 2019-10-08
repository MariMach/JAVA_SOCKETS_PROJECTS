package test1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//IOException input output exception
//UnknownHostException 


//open cmd
//cd C:\Users\Meriem\Desktop\javas\tpSocket
//cd bin
//java Server ou bien java packagenom.classnom


//InputStream is = s.getInputStream();
//OutputStream os = s.getOutputStream();

//cls pour clear

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Socket socket = new Socket("localhost",1234);
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Donner un nombre :");
			int nb = scanner.nextInt();
			
			os.write(nb);
			int rep = is.read();	
			System.out.println("Resultat = "+rep);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
