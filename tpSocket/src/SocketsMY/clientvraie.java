package SocketsMY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//cd C:\Users\Meriem\Desktop\javas\tpSocket\bin
//java SocketsMY.clientvraie


public class clientvraie {
	
public static void main(String[] args) throws IOException, UnknownHostException {
		
		Socket socket = new Socket("localhost", 9798);
		
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os, true);

		
		while(true) {
			
			String rep=br.readLine();
			System.out.println("Server vous dit : " +rep);
			
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Votre message :  ");
			String message = sc.nextLine();
			pw.println(message);
			
		
		}
		
		//socket.close();
	}

	
}
