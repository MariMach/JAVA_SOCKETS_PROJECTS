package ServeurDeChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//cd C:\Users\Meriem\Desktop\javas\tpSocket\bin
//java ServeurDeChat.Serveur


public class Serveur {
	

	public static Thread tserveur;
	public static ServerSocket ss = null;
	public static int nbClients = 0;
	private static Socket socket = null;
	public static Thread th1;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			ss = new ServerSocket(999);
			System.out.println("Le serveur est a l'ecoute du port ");
		
			tserveur = new Thread(new Runnable() {
				public void run() {
					// TODO Auto-generated method stub
					try {
						while(true) {
							nbClients++;
							socket = ss.accept();
							System.out.println("Le Client Numero " +  nbClients +" est connecte");
							th1 = new Thread(new ChatClientServeur(socket));
							th1.start();
						}
						
					}catch (IOException e) {
						System.out.println("Erreur Serveur");
					}
					
					
					
				}
				
			});
			tserveur.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Le port est deja utilise !");
		}
		

	}

}

