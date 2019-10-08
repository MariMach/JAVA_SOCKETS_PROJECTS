package openclassrooms;

import java.net.InetAddress;
import java.net.UnknownHostException;

//getLocalHost(); return the IP local address
//getByName(String nom_de_la_machine); address ip du nom
//getAllByName(String nomdelamachine); l'ensemble des address ip du nom
//getHostName() return nom de la machine
//getAddress() return the IP address sous forme d'un tableau de 4octets 
//toString() elle retourne un String qui correspond au nom de la machine et son address


public class test2 {

	

	public static void main(String[] args) throws UnknownHostException {
		InetAddress LocaleAddress;
		InetAddress[] ServeurAddress;
		
		
		LocaleAddress = InetAddress.getLocalHost();
		System.out.println("L'adresse locale est : " + LocaleAddress.getHostName());
		
		ServeurAddress = InetAddress.getAllByName("www.youtube.com");
		for(InetAddress inet : ServeurAddress){	
			System.out.println("L'adresse du serveur  du site du google est : " + inet);
		}
		
	}
}
