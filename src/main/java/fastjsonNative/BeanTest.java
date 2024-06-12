package fastjsonNative;

import com.alibaba.fastjson.JSON;

public class BeanTest {

    public static void main(String[] args) throws Exception {
        Person person = new Person();
        person.setName("pysnow");
        String JSON_Serialize = JSON.toJSONString(person);
        System.out.println(JSON_Serialize);
    }
}