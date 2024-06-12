package ClassLoad;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.ProtectionDomain;

public class unsafe {
    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        byte[] code = Files.readAllBytes(Paths.get("D:\\java_project\\JavaSecurityStudy\\target\\classes\\ClassLoad\\evil.class"));
        Method defineUnsafe = Unsafe.class.getDeclaredMethod("defineClass", String.class, byte[].class, int.class, int.class, ClassLoader.class, ProtectionDomain.class);
        defineUnsafe.setAccessible(true);
        Class exp = (Class) defineUnsafe.invoke(unsafe,"ClassLoad.evil",code,0,code.length,ClassLoader.getSystemClassLoader(),null);
        exp.newInstance();

    }
}
