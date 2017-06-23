package MastermindMitRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

//Klasse für den Server
public class Server {
	public static void main(String[] args) throws RemoteException {
		Menue spiel = new Menue();
		// Legt eine Registry an und "startet" den Server
		try {

			LocateRegistry.createRegistry(1090);
			SpielInterface stub = (SpielInterface) UnicastRemoteObject.exportObject(spiel, 0);
			RemoteServer.setLog(System.out);
			Naming.rebind("rmi://localhost:1090/stub", stub);
			System.out.println("Server gestartet.");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Gebe 1 ein, wenn der Client gestartet wurde! ");
		int c = new Scanner(System.in).nextInt();
		if (c == 1) {
			// Ruft die Methode vom Ratenden auf, um ihm die Daten zu senden
			try {

				ClientCallbackInterface callbackClient = (ClientCallbackInterface) Naming
						.lookup("rmi://192.168.178.20:1091/stubi");
				System.out.println("Server-Client bereit!");
				callbackClient.clientFarbData(spiel.getCode().getCcolor()[0].getRGB(),
						spiel.getCode().getCcolor()[1].getRGB(), spiel.getCode().getCcolor()[2].getRGB(),
						spiel.getCode().getCcolor()[3].getRGB());
				int i = 1;
				while (i == 1) {
					// Tippe 1 in die Console damit das Array übermittelt wird
					System.out.println("Gebe 1 ein, um dem Client Daten zu senden! ");
					int s = new Scanner(System.in).nextInt();
					if (s == 1) {
						callbackClient.clientData(spiel.getRightp(), spiel.getRightc(), spiel.getRunde());
						spiel.getCode().getRundeAnzeige()
								.setText(spiel.getCode().getRundeAnzeigeText()[spiel.getRunde()]);

						
						System.out.println("Gesendet");
					}
				}
				
			} catch (Exception e) {
				System.out.println("HelloClient exception: " + e);
			}
		}
	}
}