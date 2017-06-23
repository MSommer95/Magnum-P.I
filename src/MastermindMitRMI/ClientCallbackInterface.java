package MastermindMitRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
//Das Interface kümmert sich um die Daten, die der Codierer zum Ratenden sendet
public interface ClientCallbackInterface extends Remote {
	public boolean clientData(int richtigP, int richtigC, int runde) throws RemoteException;
	public boolean clientFarbData(int f1, int f2, int f3, int f4) throws RemoteException;
}