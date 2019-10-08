package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur_Jouet {
	
	private static int nbLignes;
	private static Socket ma_connexion;
	private static ServerSocket gestionnaire_de_connexion;
	private final static int port = 12000;
	
	public static void main(String args[]) throws IOException {
		gestionnaire_de_connexion = new ServerSocket(port);
		System.out.println("Serveur Jouet est lance sur " + port);
		
		ma_connexion = gestionnaire_de_connexion.accept();
		
		OutputStream os = ma_connexion.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.println("Bienvenue");
		pw.flush();
		
		InputStreamReader osr = new InputStreamReader(ma_connexion.getInputStream());
		BufferedReader br = new BufferedReader(osr);
		
		String req;
		while((req = br.readLine()) != null) {
			nbLignes++;
			System.out.println(nbLignes + " " + req);
		}
		
	}

}
