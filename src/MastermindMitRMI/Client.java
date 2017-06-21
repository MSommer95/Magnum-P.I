package MastermindMitRMI;
import java.rmi.Naming;
import java.util.Scanner;
import java.rmi.NotBoundException;

import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
	SpielInterface myClient;
	public static void main(String[] args) throws RemoteException, NotBoundException {
		try {
			Ratende ratender = new Ratende();
			SpielInterface clientRatende = (SpielInterface) Naming.lookup("rmi://192.168.178.20:1090/stub");
			
			clientRatende.starteSpiel(1);
			while(clientRatende.starteSpiel(1)){
				//Tippe 1 in die Console damit das Array übermittelt wird
				int s = new Scanner(System.in).nextInt();
				if(s == 1){
				ratender.setRunde(ratender.getRunde()+1);
				clientRatende.spielzug(ratender.getRcolor()[0],ratender.getRcolor()[1],ratender.getRcolor()[2],ratender.getRcolor()[3], ratender.getRunde());
			    System.out.println("Done");
			    ratender.getRundeAnzeige().setText(ratender.getRundeAnzeigeText()[ratender.getRunde()]);
				}
		}
		}
		 catch (Exception e) {
			System.out.println("HelloClient exception: " + e);
		}
	}
}