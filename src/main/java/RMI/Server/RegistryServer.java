package RMI.Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegistryServer {
    public static void main(String[] args) throws RemoteException {
        LocateRegistry.createRegistry(1099);
        while (true){}
    }
}
