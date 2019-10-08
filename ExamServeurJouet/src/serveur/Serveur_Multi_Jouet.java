package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur_Multi_Jouet {
	
	private  int nbLignes;
	private  Socket ma_connexion;
	private static  ServerSocket gestionnaire_de_connexion;
	private  int port;
	private final String finish = "quit";
		
		public Serveur_Multi_Jouet(int port){
			this.port = port;
		}
		
		public void run() throws IOException {
			while(true) {
				ma_connexion = gestionnaire_de_connexion.accept();
				service_client(ma_connexion);
			
			}
		}
		
		public void  service_client(Socket s) throws IOException {
			OutputStream os = s.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.println("Bienvenue");
			pw.flush();
			
			InputStreamReader osr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(osr);
			
			String req;
			while((req = br.readLine()) != null) {
				if(req.toLowerCase().contains(finish.toLowerCase()) == true) {
					s.close();
					pw.println("Bye Bye mon client");
					break;
				}
				nbLignes++;
				System.out.println(nbLignes + " " + req);
				
			}
		}


		public static void main(String args[]) throws IOException {
		
			String sport = args[0];
			int port = Integer.parseInt(sport);
			if(port >= 1024 && port <= 65535) {
				gestionnaire_de_connexion = new ServerSocket(port);
				System.out.println("Serveur Jouet est lance sur " + port);
				
				Serveur_Multi_Jouet smj = new Serveur_Multi_Jouet(port);
				smj.run();
				
			}else {
				System.out.println("Port fourni invalide "+ port + " Il doit etre entre 1024 et 65535");
			}
		
		}
	}

	


