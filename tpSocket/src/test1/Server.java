package test1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//Socket socket  = new Socket(hostadress, port);
//Socket socket  = new Socket("www.ensias.ma", 80);

//open cmd
//cd C:\Users\Meriem\Desktop\javas\tpSocket
//cd bin
//java Server ou bien java packagenom.classnom

//cls pour clear

//OutputStream is = socket.getOutputStream()
//InputStream os = socket.getInputStream()

//pour lire une chaine de caracteres envoyee au client
//InputStream is = socket.InputStream(); //transmettre octet par octet
//InputSreamReader isr = InputStreamReader(is); construit les caracteres
//BufferedReader br = new BufferedReader(isr); readline 4 octets sont envoyes vers BufferedReader
//String s = br.readLine();


//pour envoyer une chaine de caracteres au client
//OutputStream os = socket.getOutputStream();
//PrintWriter pw = new PrintWriter(os, true);
//pw.println("Chaine de caracteres");
//communication ligne par ligne


/* Serializable implements Serializable
Serialization is a mechanism of converting the state of an object into a byte stream 
The byte stream creaded 

pour serialiser un objet envoyer un objet vers le client 
OutputStream os = socket.getOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(os);
Voiture v = new Voiture("v212",50);
oos.writeObject(v);

pour lire un objet envoye par le client (deserialisation)
InputStream is = socket.getInputStrem();
ObjectInputStream ois = new ObjestInputStream();
Voiture v = (Voiture) ois.readObject();
*/

//Le serveur puisse attendre une connexion a tout moment.

//Pour chaque connexion, il faut creer un nouveau thread associe a la socket
//du client connecte, ouis attendre a nouveau une nouvelle connexion. 

//Le thread cree doit s'occuper des operations d'entrees sorties (read/write)
//pour communiquer avec le client independamment des autres activites  du serveur


//ServerSocket objet serversocket 
//Thread gerer la boucle infinie pour connecter les clients
//Socket creer une socket
//thread qui se charge de write() et read() 
//
//

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serversocket = new ServerSocket(1234);
			System.out.println("J'attends la connexion d'un client");
			
			Socket socket = serversocket.accept();
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			System.out.println("J'attends un nombre");
			
			int nb = is.read();
			int rep = nb*8;
			
			System.out.println("J'envoie la reponse");
			
			os.write(rep);
			
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
