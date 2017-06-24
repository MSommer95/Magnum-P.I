package MastermindMitRMI;

import java.rmi.*;

//Das Interface kümmert sich um die Daten, die der Ratende an den Codierer sendet
public interface SpielInterface extends Remote {
	public boolean starteSpiel(int starter) throws RemoteException;

	public boolean spielzug(int f1, int f2, int f3, int f4) throws RemoteException;
}