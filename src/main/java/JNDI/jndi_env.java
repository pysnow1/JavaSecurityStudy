package JNDI;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class jndi_env {
    public static void main(String[] args) throws NamingException {
        // Hashtable env = new Hashtable();
        // env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.rmi.registry.RegistryContextFactory");
        // env.put(Context.PROVIDER_URL,"rmi://127.0.0.1:1099/pysnow");
        // Context context = new InitialContext(env);

        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.SECURITY_AUTHENTICATION,"simple");
        env.put(Context.SECURITY_PRINCIPAL,"dc=example,dc=com");
        env.put(Context.SECURITY_CREDENTIALS, "123456");
        env.put(Context.PROVIDER_URL,"ldap://127.0.0.1:1389");
        Context context = new InitialContext();
        context.lookup("ldap://127.0.0.1:1389/pysnow");
    }
}
