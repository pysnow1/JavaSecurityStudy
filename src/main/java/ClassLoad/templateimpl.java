package ClassLoad;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;

public class templateimpl {
    public static void main(String[] args) throws Exception {
        TemplatesImpl template = new TemplatesImpl();
        byte[] codes = Files.readAllBytes(Paths.get("D:\\java_project\\JavaSecurityStudy\\target\\classes\\ClassLoad\\TemplateCode.class"));
        setField(template,"_name","pysnow");
        setField(template,"_bytecodes",new byte[][] {codes});
        setField(template,"_tfactory",new TransformerFactoryImpl());
        template.newTransformer();
    }
    public static void setField(Object object,String name,Object value) throws Exception {
        Field field= object.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(object,value);
    }
}
