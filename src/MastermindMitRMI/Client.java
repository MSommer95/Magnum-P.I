package MastermindMitRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.util.Scanner;
import java.rmi.NotBoundException;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

//Klasse für den Client
public class Client {
	SpielInterface myClient;

	public static void main(String[] args) throws RemoteException, NotBoundException {
		Ratende ratender = new Ratende();
		// Legt eine Registry an und "startet" den Client Server
		try {

			LocateRegistry.createRegistry(1091);
			ClientCallbackInterface stubi = (ClientCallbackInterface) UnicastRemoteObject.exportObject(ratender, 0);
			RemoteServer.setLog(System.out);
			Naming.rebind("rmi://localhost:1091/stubi", stubi);
			System.out.println("Client gestartet.");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Ruft die Methode vom Codierer auf, um ihm die Daten zu senden
		try {

			SpielInterface clientRatende = (SpielInterface) Naming.lookup("rmi://192.168.178.20:1090/stub");
			clientRatende.starteSpiel(1);

			while (clientRatende.starteSpiel(1)) {
				// Tippe 1 in die Console damit das Array übermittelt wird
				int s = new Scanner(System.in).nextInt();
				if (s == 1) {
					ratender.setRunde(ratender.getRunde() + 1);
					clientRatende.spielzug(ratender.getRcolor()[0], ratender.getRcolor()[1], ratender.getRcolor()[2],
							ratender.getRcolor()[3]);
					System.out.println("Gesendet");

				}
				ratender.getLabelAktivitätR().setText("Warte auf die Daten vom Server.");
			}

		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e);
		}
	}
}