package SocketsMY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class serverchat extends Thread{ 
	private int nbClients = 0;
	private List<Conversation> lconv =  new ArrayList<Conversation>();
	
	public void run() {
		try {
			ServerSocket serversocket = new ServerSocket(7000);
			
			while(true) {
				Socket socket = serversocket.accept();
				nbClients++;
				Conversation cn = new Conversation(socket, nbClients);
				cn.start();
				lconv.add(cn);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Broadcast(String message) throws IOException {
		for(Conversation conv: lconv) {
			PrintWriter pw = new PrintWriter(conv.getsocket().getOutputStream(), true);
			pw.println(message);
		}
	}
	
	class Conversation extends Thread{
		private Socket socket;
		private int nbClient;
		private String IP;
		
		public Conversation(Socket socket, int nbClient) {
			super();
			this.socket = socket;
			this.nbClient = nbClient;
		}
		
		public String getIP() {
			 IP = socket.getRemoteSocketAddress().toString();
			 return IP;
		}
		
		public Socket getsocket() {
			return this.socket;
		}
		
		public void run() {
			
			
			try {
				OutputStream is = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(is, true);
					
				InputStream os = socket.getInputStream();
				InputStreamReader osr = new InputStreamReader(os); 
				BufferedReader br = new BufferedReader(osr);
				
				pw.println("Bienvenue vous etes le client numero "+ nbClient);

				
				String req;
				while((req = br.readLine()) != null) {
					System.out.println(IP + " IP a envoye la requete "+ req);
					Broadcast(req);
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	public static void main(String[] args)  {
		new serverchat().start();
	}

}
