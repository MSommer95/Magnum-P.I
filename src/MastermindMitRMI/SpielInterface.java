package MastermindMitRMI;

import java.rmi.*;

public interface SpielInterface extends Remote{
	public boolean starteSpiel(int starter) throws RemoteException;
	public boolean spielzug(int f1, int f2, int f3, int f4, int runde) throws RemoteException;
	}
	

