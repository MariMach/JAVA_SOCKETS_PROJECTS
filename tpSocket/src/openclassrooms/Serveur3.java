package openclassrooms;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//toujours on lance dabors le serveur ouis les clients

//cd C:\Users\Meriem\Desktop\javas\tpSocket\bin
//java openclassrooms.Serveur3

//telent localhost 2009

public class Serveur3 {
	
	public static void main(String[] args) {
		
		ServerSocket socket;
		
		try {
			socket = new ServerSocket(2009);
			Thread t = new Thread(new Accepter_clients(socket));
			t.start();
			System.out.println("Mes employeurs sont prets");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}


class Accepter_clients implements Runnable{
	
	private ServerSocket serversocket;
	private Socket socket;
	private int nbrClient = 1;
	
	public Accepter_clients(ServerSocket s) {
		serversocket = s;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				socket = serversocket.accept();// un client se connecte on l'accepte
				System.out.println("Le client numero "+nbrClient+" est connecte !");
				nbrClient++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}
	
	
}