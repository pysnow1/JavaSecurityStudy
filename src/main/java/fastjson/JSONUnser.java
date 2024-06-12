package fastjson;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class JSONUnser {
    public static void main(String[] args) throws Exception {
        /*
            String s = "{\"param1\":\"aaa\",\"param2\":\"bbb\"}";
            String s = "{\"age\":18,\"name\":\"abc\"}";
        */
        String s = "{\"@type\":\"fastjson.Person\",\"age\":18,\"name\":\"abc\"}";

        JSONObject jsonObject = JSON.parseObject(s);

        System.out.println(jsonObject);
    }
}