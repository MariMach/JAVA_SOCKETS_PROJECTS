package ServerMT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//tester avec telnet
//telnet localhost 234
//cd C:\Users\Meriem\Desktop\javas\tpSocket\bin

public class Servermt extends Thread{
	int nbClients;
	public void run() {
		
		try {
			ServerSocket serversocket= new ServerSocket(234);
			while(true) {
				Socket socket = serversocket.accept();
				++nbClients;
				new Conversation(socket,nbClients).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	class Conversation extends Thread{
		private Socket socket;
		private int numClients;
		
		Conversation(Socket socket, int numClients){
			super();
			this.socket = socket;
			this.numClients = numClients;
		}
		public void run() {
			try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is); //lire des caracetres
				BufferedReader br = new BufferedReader(isr); //lire des chaines de caracteres
			
				OutputStream os = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(os, true);
				
				String IP = socket.getRemoteSocketAddress().toString();
				
				System.out.println("Connexion du client numero "+ numClients + "IP = "+IP);
					
				pw.println("Bienvenue, vous etes le client numero " + numClients);
				
				while(true) {
					String req = br.readLine();
					System.out.println(IP + " a envpye " + req);
					if(req != null ) {
						String rep = "Size = " + req.length();
						pw.println(rep);
					}	
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Servermt().start();	
	}
}







