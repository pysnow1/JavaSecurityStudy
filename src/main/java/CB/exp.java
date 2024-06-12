package CB;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

public class exp {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        student std = new student();
        std.setName("pysnow");
        std.setId(2021);

        System.out.println(PropertyUtils.getProperty(std, "name"));
    }
}

