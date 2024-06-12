package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class order {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        person.getName();
        Field name = person.class.getDeclaredField("name");
        Field modname = name.getClass().getDeclaredField("modifiers");
        modname.setAccessible(true);
        modname.set(name,name.getModifiers() & ~Modifier.FINAL);
        name.setAccessible(true);
        name.set(null, "pysnow");
        person.getName();

    }
}

class person {
    private final static String name = (null == null ? "no" : "pysnow");

    public static void getName() {
        System.out.println(name);
    }
}