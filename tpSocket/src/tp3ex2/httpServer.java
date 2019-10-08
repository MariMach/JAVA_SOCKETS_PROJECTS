package tp3ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class httpServer  extends Thread{
	
	public static void main(String[] args){
		new httpServer().start();
	}
			
			public void run(){
				int port = 8000;
				try {
					ServerSocket serversocket = new ServerSocket(port);
					System.out.println("J'attends la connexion d'un client http");
					while(true) {	
							Socket clientsocket = serversocket.accept();
							System.out.println("Un client s'connecte sur le port " + port);
							new Cclient(clientsocket).start();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}


		class Cclient extends Thread{
			private Socket socket;
			
			
			Cclient(Socket socket){
				super();
				this.socket = socket;
			}
			
				public void run() {
					// TODO Auto-generated method stub
					try {
						OutputStream outs =  socket.getOutputStream();		
						PrintWriter pw = new PrintWriter(outs, true);
						
						try {
							Scanner sc = new Scanner(new File("C:\\Users\\Meriem\\Desktop\\javas\\tpSocket\\bin\\tp3ex2\\httpage.txt"));
							while(sc.hasNext()) {
								 pw.println(sc.nextLine());
							}	
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("Le fichier n'existe pas !");
						}
						
						socket.close();
						socket.close();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
		}
}

