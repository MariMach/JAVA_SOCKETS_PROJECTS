package tp3ex1;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

//cd C:\Users\Meriem\Desktop\javas\tpSocket\bin
//java tp3ex1.Server

//ThreadLocalRandom()
//Generate number between 0-9
//int index = ThreadLocalRandom.current().nextnt();


//Math.random()
//Generate number between 0-9
//int index = (int)(Math.random()*10);

//Random()
//Generate a number between 0-9
//Random random = new Random();
//int index = random.nextInt(10);

//list.get(int index);

public class Server {
	public static void main(String[] args) {
		
		ArrayList<String> proverbe = new ArrayList();
		proverbe.add("Avec du temps et de la patience, on vient a bout de tout.");
		proverbe.add("Plus on désire une chose, plus elle se fait attendre.");
		proverbe.add("Avec un peu de travail et beaucoup de persévérance une ambitieuse qui ne craint pas l'ennui arrive à tout. ");
		proverbe.add("La vie est merveilleuse, croquons-la à pleines dents");
		proverbe.add("Savoir donner, peu le savent, c'est le secret du bonheur.");
		proverbe.add("Il vaut mieux tomber une fois que toujours chanceler. ");
		proverbe.add(" La vanité, comme les insectes, se repaît de petits riens");
		
		try {
			ServerSocket serversocket = new ServerSocket(234);
			System.out.println("J'attends la connexion d'un client");
			
			Socket socket = serversocket.accept();
			System.out.println("Un client est connecte");
			
			
			
			 int index = (int)(Math. random()*(proverbe.size()));
			
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
			pw.println(proverbe.get(index));
			
			serversocket.close();
			socket.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
