package cours;

import java.awt.List;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class InterfacesAddress {
	
	public static void main(String args[]) throws SocketException {
		
		
		Enumeration<NetworkInterface> lesInterfaces = NetworkInterface.getNetworkInterfaces();
		
		while(lesInterfaces.hasMoreElements()) {
			
			NetworkInterface interfaces = lesInterfaces.nextElement();
			Enumeration<InetAddress> lesAddresses =  (Enumeration<InetAddress>) interfaces.getInetAddresses();
			
			while(lesAddresses.hasMoreElements()) {
				InetAddress address = lesAddresses.nextElement();
				System.out.println(address.getHostAddress());
			}
		}
	}

}
