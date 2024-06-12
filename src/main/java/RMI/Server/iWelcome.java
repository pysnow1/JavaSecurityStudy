package RMI.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iWelcome extends Remote {

    String welcome(Object person) throws RemoteException;
}
