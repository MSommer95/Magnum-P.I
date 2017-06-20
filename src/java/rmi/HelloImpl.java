package java.rmi;

import java.rmi.*;
import java.rmi.server.*;
public class HelloImpl
extends UnicastRemoteObject
implements Hello
{
	public String sayHello (String language) throws
RemoteException {	
		String lang = language.toLowerCase();
		switch (lang.charAt(0)) {
			case 'd': return "Hallo!";
			case 'f': return "Salut!";
			case 'i': return "Ciao!";
			default: return "Hi!";
		}
	}
	
}
