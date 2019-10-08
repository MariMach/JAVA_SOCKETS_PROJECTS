package ServeurDeChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//cd C:\Users\Meriem\Desktop\javas\tpSocket\bin
//java ServeurDeChat.Client

public class Client {
	
	public static  Socket socket = null;
	public static Thread tclient;
	private static PrintWriter outc = null;
	private static BufferedReader inc = null;
	private static Thread tclient3;
	private static Thread tclient4;
	private static String messages1 = null;
	private static String messages2 = null;
	private static Scanner sc = null;
	
	public static void main(String[] args) {
		
		
		
		try {
			System.out.println("Demande de connexion");
			socket = new Socket("127.0.0.1", 999);
			System.out.println("Connexion etablie avec le serveur");
			//le message s'affiche je suis connecte
			
			inc = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outc = new PrintWriter(socket.getOutputStream());
			
			tclient3 = new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					sc = new Scanner(System.in);
					
					while(true) {
						System.out.println("Client Votre message :" );
						messages1 = sc.nextLine();
						outc.println(messages1);
						outc.flush();
					}
					
				}
				
			});
			tclient3.start();
			
			tclient4 = new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					while(true) {
						try {
							messages2 = inc.readLine();
							System.out.println(messages2);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}
				
			});
			tclient4.start();
			
		} catch (UnknownHostException e) {
			  System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Aucun serveur a l'ecoute du port " + socket.getLocalPort());	
		}
	}
	
}
