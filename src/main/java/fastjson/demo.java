package fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class demo {
    public static void main(String[] args) {
        // ser();
        unser();
    }

    public static void ser() {
        // 创建对象
        person pysnow = new person(1, "pysnow", 20);

        // JSON序列化对象
        String jsonString = JSON.toJSONString(pysnow, SerializerFeature.WriteClassName);
        System.out.println(jsonString);
    }

    public static void unser() {
        String payload = "{\"@type\":\"fastjson.person\",\"age\":20,\"id\":1,\"name\":\"pysnow\",\"money\":200,\"exp\":{}}";
        Object pysnow = JSON.parseObject(payload,Object.class);
        System.out.println(pysnow.toString());
        System.out.println(pysnow.getClass().getName());
    }
}

