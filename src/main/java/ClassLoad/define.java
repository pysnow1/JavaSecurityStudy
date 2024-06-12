package ClassLoad;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class define {
    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Method method = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, int.class, int.class);
        method.setAccessible(true);
        byte[] code = Files.readAllBytes(Paths.get("D:\\java_project\\JavaSecurityStudy\\target\\classes\\ClassLoad\\evil.class")); // 字节码的数组
        Class c = (Class) method.invoke(classLoader, "ClassLoad.evil", code, 0, code.length);
        c.newInstance();
    }
}
