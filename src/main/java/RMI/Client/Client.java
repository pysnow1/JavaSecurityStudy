package RMI.Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import RMI.Server.iWelcome;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1",1099);
        iWelcome RemoteWelcome = (iWelcome) registry.lookup("welcome");
        // 同样可以使用Naming.lookup获取
        // iWelcome RemoteWelcome = (iWelcome) Naming.lookup("rmi://localhost:1099/welcome");

        String result = RemoteWelcome.welcome("pysnow");

//        System.out.println(result);
    }
}
