package MastermindMitRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallbackInterface extends Remote {
	public boolean clientData(int richtigP, int richtigC, int runde) throws RemoteException;
}
