package cours;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//cd C:\Users\Meriem\Desktop\javas\cours\bin
//java cours.indexjspEnsias

public class indexjspEnsias {
	
	public static void main(String[] args) {		
		try {
			int nbBitsR;
			byte[] b = new byte[1000];
			
			String g = "GET / HTTP/1.1\n" + "Host: www.ensias.ma\n\n";
			Socket socket =  new Socket("www.ensias.ma", 80);
			
			OutputStream out = socket.getOutputStream();
			out.write(g.getBytes());
			
			InputStream in = socket.getInputStream();
			nbBitsR = in.read(b);
			
			if(nbBitsR > 0) {
				System.out.println( nbBitsR+" bits recus.");
				System.out.println("Recu :"+ new String(b, 0, nbBitsR));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
}
