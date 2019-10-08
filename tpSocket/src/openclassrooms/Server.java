package openclassrooms;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//Serveur
//ServerSocket socketserver = new ServerSocket(numero_port);
//ServerSocket socketserver = new ServerSocket(numero_port,nbr_max);  
//nbr_max est le nombre total de connexion simultanees acceptees
//ServerSocket socketserver = new ServerSocket(numero_port, nbr_max, adresse_locale);
//Socket socketduserveur = socketserver.accept();


//Client
//Socket socket = new Socket(adresse_distante, port_distant)
//Socket socket = new Socket(adresse_distante, port_distant, adress_locale, port_locale);

//cd C:\Users\Meriem\Desktop\javas\tpSocket\bin
//java openclassrooms.Server

public class Server {
	public static void main(String[] args) throws IOException {
		
		ServerSocket serversocket = new ServerSocket(2009);
		Socket socketduserveur = serversocket.accept();
		
		System.out.println("Un zero s'est connecte !");	
		serversocket.close();
		socketduserveur.close();
	}

}
