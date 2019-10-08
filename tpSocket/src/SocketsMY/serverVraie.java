package SocketsMY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//cd C:\Users\Meriem\Desktop\javas\tpSocket\bin
//java SocketsMY.serverVraie



public class serverVraie extends Thread{
	int nbClients = 0;

	public void run(){
		try {
			ServerSocket serversocket = new ServerSocket(9798);
			
			while(true) {
				Socket socket = serversocket.accept();
				nbClients++;
				new Conversation(socket, nbClients).start();
			}
			
			//serversocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	class Conversation extends Thread{
		private Socket socket;
		private int nbc;
		public Conversation(Socket socket, int nbc) {
			this.socket = socket;
			this.nbc = nbc;
		}
		public void run(){
			try {
				InputStreamReader isr = new InputStreamReader(socket.getInputStream());
				BufferedReader br = new BufferedReader(isr);
				
				OutputStream os = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(os, true);
				
				String IP = socket.getRemoteSocketAddress().toString();
				
				System.out.println("Le client numero " + nbc + " s'est connecte");
				System.out.println("IP : " + IP);
				
				pw.println("Bienvenue vous etes le client numero "+ nbc);
				
				while(true) {
					String req;
					while((req= br.readLine()) != null) {
						System.out.println(IP + " IP a envoye la requete "+ req);
						String rep = "Size "+req.length();
						pw.println(rep);					
					}		
				}
				
				//socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args)  {
		new serverVraie().start();
	}
}
