package MastermindMitRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

public class Server
{
  public static void main( String[] args ) throws RemoteException
  {
    
    try {
		
		LocateRegistry.createRegistry(1090);
	    
		Menue spiel = new Menue();
	   	
		
		SpielInterface stub = (SpielInterface) UnicastRemoteObject.exportObject( spiel, 0 );
		
	    RemoteServer.setLog( System.out );
	    Naming.rebind("rmi://localhost:1090/stub", stub);
	    System.out.println( "Server gestartet." );
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  }
}

