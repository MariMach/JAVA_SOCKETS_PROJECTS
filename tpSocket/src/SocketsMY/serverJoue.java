package SocketsMY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

//cd C:\Users\Meriem\Desktop\javas\tpSocket\bin
//java SocketsMY.serverJoue


public class serverJoue extends Thread{
	
	private int nbClients = 0;
	private int pickedNumber;
	private boolean fin = false;
	private String winner;
	private Random rand = new Random();
	
	
	public void run() {
		try {
			ServerSocket serversocket = new ServerSocket(8000);
			pickedNumber =  rand.nextInt(1000) + 1;
			
			while(true) {
				Socket socket = serversocket.accept();
				nbClients++;
				Conversation cn = new Conversation(socket, nbClients);
				cn.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

	class Conversation extends Thread{
		
		private Socket socket;
		private int nbc;
		
		public Conversation(Socket socket, int nbc) {
			super();
			this.socket = socket;
			this.nbc = nbc;
		}
		
		public void run() {
			
			try {
				
				InputStream is = socket.getInputStream();
				InputStreamReader osr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(osr);
				
				OutputStream os = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(os, true);
				
				
				pw.println("Bienveue vous etes le client numero " + nbc);
				pw.println("Devinez le nombre secret entre 1 et 1000");
				
				while(true) {
					String IP = socket.getLocalSocketAddress().toString();
					System.out.println("Connexion du client N : "+ nbc + " "+IP);

					String req;
					while((req=br.readLine()) != null) {
						System.out.println(IP + " a envoye "+ req);
						int nb = Integer.parseInt(req);
						if(fin == false){
							if(nb < pickedNumber) {
								pw.println("Votre nombre est plus petit");
							}else if(nb > pickedNumber) {
								pw.println("Votre nombre est plus grand");

							}else {
								fin = true;
								pw.println("Bravo, Vous avez gagne ...");
								winner = IP;
								System.out.println("Bravo "+ IP);
							}
							
						}else {
							pw.println("Le jeu est termine, le ganant est " + winner);
						}
						
					}
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
		
	}
	
	
	public static void main(String[] args){
		serverJoue sj = new serverJoue();
		sj.start();
	}
}


