package ServeurDeChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ChatClientServeur implements Runnable{
	
	private Socket socket;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private Thread th3;
	private String messagec1 = null;
	

	public ChatClientServeur(Socket so) {
		socket = so;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
			//Lire
			 th3 = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					while(true) {
						try {
							messagec1 = in.readLine();
							System.out.println(messagec1);
							out.println(messagec1);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}
				
			});
			th3.start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Un Client s'est deconnecte");
		}

	}

}
