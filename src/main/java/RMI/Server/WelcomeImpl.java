package RMI.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class WelcomeImpl extends UnicastRemoteObject implements iWelcome {

    protected WelcomeImpl() throws RemoteException {
    }

    @Override
    public String welcome(Object person) throws RemoteException {
        return "Welcome the user: " + person.toString() + " \nHave a good Day!";
    }
}
