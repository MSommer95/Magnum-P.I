package MastermindMitRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
//Das Interface kümmert sich um die Daten, die der Codierer zum Ratenden sendet
public interface ClientCallbackInterface extends Remote {
	public boolean clientData(int richtigP, int richtigC, int runde) throws RemoteException;
}
