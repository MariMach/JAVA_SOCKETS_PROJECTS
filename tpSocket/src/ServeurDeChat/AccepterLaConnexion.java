package ServeurDeChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class AccepterLaConnexion implements Runnable{
	
	private ServerSocket serversocket = null;
	private Socket socket = null;
	public Thread th1;
	public static int nbClients = 0;

	
	public AccepterLaConnexion(ServerSocket ss) {
		 serversocket = ss;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				nbClients++;
				socket = serversocket.accept();
				System.out.println("Le Client Numero " +  nbClients +" est connecte");
				th1 = new Thread(new ChatClientServeur(socket));
				th1.start();
			}
			
		}catch (IOException e) {
			System.out.println("Erreur Serveur");
		}
	}
	

}
