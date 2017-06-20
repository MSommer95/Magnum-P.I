package java.rmi;

import java.rmi.*;

public interface Hello extends Remote {
	public String sayHello (String language) throws RemoteException;
	
}
