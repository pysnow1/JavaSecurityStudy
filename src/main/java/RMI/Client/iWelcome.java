package RMI.Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iWelcome extends Remote {
    public String welcome(Object person) throws RemoteException;
}
