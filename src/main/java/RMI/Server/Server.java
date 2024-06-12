package RMI.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(1099);
        // 创建registry注册中心，只需要一行代码就可以搞定

        // Server服务端部分
        WelcomeImpl remoWelcome = new WelcomeImpl();
        // 创建远程对象
        Registry registry_get = LocateRegistry.getRegistry(1099);
        // 在本地上获取1099端口的注册中心
        registry_get.bind("welcome",remoWelcome);

        // 也可以用Naming.rebind这个静态方法想Registry绑定远程对象
        // Naming.rebind("rmi://localhost:1099/welcome",remoWelcome);

    }
}
