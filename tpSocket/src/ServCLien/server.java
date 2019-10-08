package najlae;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

	public static void main(String[] args) throws IOException {
		ServerSocket serv = new ServerSocket(4234);
		System.out.println("hhh s");
		Socket s = null;
		while(true) {
			s = serv.accept();
			Thread th = new Thread(new clientHandler(s));
			th.start();
		}
	
			
	}		
		//serv.close();
}

class clientHandler implements Runnable{
	private Socket s;
	public clientHandler(Socket s){
		this.s = s;
	}		
		public void run() {	
			
				try {	
					PrintWriter writer = new PrintWriter(s.getOutputStream());
					writer.println("maryam is beaurifaul !! \n najlae zwina \n salma n3assa ");
					writer.flush();	
					s.close();
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
			
}


