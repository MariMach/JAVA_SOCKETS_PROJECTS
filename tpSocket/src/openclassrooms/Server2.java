package openclassrooms;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//getInputStrem(); gerer les flux entrant

//getOutputStrem(); gerer les flux sortant

//BufferedReader et InputStreamReader pour la lecture
//PrintWriter pour l'écriture

//InputStreamReader : convertit un flux binaire en flux de caractères :
//elle convertit un objet de type InputStream en objet de type Reader ;

//BufferedReader : cette classe permet de lire des caractères à partir 
//d'un flux tamponné, afin de faire des lectures plus rapides ;

//on utilise flush pour vider le buffer tout simplement

public class Server2 {
	public static void main(String[] zero) throws IOException {
		
		ServerSocket serversocket = new ServerSocket(2009);
		System.out.println("Le serveur est a l'ecoute du port " + serversocket.getLocalPort());
		Socket socket = serversocket.accept();
		
		System.out.println("Un zero s'est connecte");
		
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		pw.println("Vous etes connecte zero !  \n hhhhh \n ligne 3");
		pw.flush();
		
		socket.close();
		serversocket.close();
/*
 * When you write data to a stream, it is not written immediately, and it is buffered.
 *  So use flush() when you need to be sure that all your data from buffer is written.
 */	
	}
}
