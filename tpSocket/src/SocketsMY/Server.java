package SocketsMY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// read() peremt de recevoir un entier
// write() permet d envoyer un entier

//cd C:\Users\Meriem\Desktop\javas\tpSocket\bin
//java SocketsMY.Server

// Recevoir 
// Classes
//InputStream/getInputStream()  inputStreamReader  BufferedReader 
// methodes 
//read():int(octet)    read():int(octet)       readInt():int readLine():String readDouble():double 

// Envoyer
//Classes
//OuptStream/getOutputStream()   PrintWritrt
// methods
// write(int c):void    println(String s):void print(String s);

/* Recevoir
InputStream is = socket.getInputStream();
InputStreamReader in = new InputStreamReader(is));
BufferedReader reader = new BufferedReader(in);
String str = reader.readLine();

ou bien

InputStreamReader in = new InputStreamReader(socket.getInputStream());
BufferedReader reader = new BufferedReader(in);
String str = reader.readLine();

 */

/* Envoyer
 OutputStream os = socket.getOutputStream();
 PrintWriter pw = new PrintWriter(os, true); 
 true means communication ligne par ligne cad j'envoye au client ligne par ligne
 pw.println(String s);
 
 OutputStream os = socket.getOutputStream();
 PrintWriter pw = new PrintWriter(os); 
 par defaut false means je stocke mes ensemble de ligne dans un duffer
 apres je fais un flush
 pw.println(String s);
 pw.flush();
 
 
 PrintWriter pw = new PrintWriter(socket.getOutputStream()); 
 par defaut false means je stocke mes ensemble de ligne dans un duffer
 apres je fais un flush
 pw.println(String s);
 pw.flush();	
  
*/

/*  Echanger des odjets Serialisation = l'objet est transformer en un tableau binaire
 			//Envoyer un objet
 Objet implments l'interface serializable
 Serializer un objet et l'envoyer 
 Voiture la classe implements interface serialiszable 
 
 OutputStream os = socket.getOutputStream();
 ObjectOutputstream oos = new ObjectOutputStream(os);
 Voiture v1 = new Voiture("v212", 50)
 oos.writeObject();
 
 
 			//Recevoir un objet deserialisation
 
InputStream is = socket.getInputStream();
ObjectInputStream oin = new ObjectInputStream(is));
Voiture v = (Voiture) ois.readObject();

 */

/*
 Serveur Multi-Threads 
 Pour qu'un serveur puisse communiquer avec plusieurs client en meme temps,
 il faut que:
 
 -- Le serveur puisse attendre une connexion a tout moment 
 	while(true){
		socket = serversocket.accept();
		  // autre tritemenr
	}
	
 -- Pour chaque connexion il faut creer 
 un nouveau thread associe a la socket du client connecte, 
 puis attendre a nouveau une nouvelle connexion.
 
 -- Le thread cree dpoit s'occuper des operations
  d'entrees-sorties(read/write) pour communiquer avec le client 
  independament des autres activites du serveur
 
 
 */



public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket serversocket = new ServerSocket(9999);
		
		System.out.println("Attend la onnexion d'un client");
		while(true) {
			Socket socket = serversocket.accept();
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			System.out.println("J'attend un nombre");
			int nb = is.read();
			int rep = nb*8;
			System.out.println("J'envoie la reponse");
			os.write(rep);
			
			socket.close();
		}
		//serversocket.close();
	}
	
}
