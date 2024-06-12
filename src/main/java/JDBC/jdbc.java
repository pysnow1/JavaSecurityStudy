package JDBC;

import java.sql.*;

public class jdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String Driver = "com.mysql.cj.jdbc.Driver"; // 从 mysql-connector-java 6开始
        // String Driver = "com.mysql.jdbc.Driver"; // mysql-connector-java 5
        String DB_URL = "jdbc:mysql://127.0.0.1:3309/test?autoDeserialize=true&queryInterceptors=com.mysql.cj.jdbc.interceptors.ServerStatusDiffInterceptor&user=deser_CUSTOM";
        // 1.加载启动
        Class.forName(Driver);
        // 2.建立连接
        Connection conn = DriverManager.getConnection(DB_URL, "root", "pysnow");
        // 3.操作数据库，实现增删改查
        // Statement stmt = conn.createStatement();
        // ResultSet rs = stmt.executeQuery("select * from users");
        // // 如果有数据，rs.next()返回true
        // while (rs.next()) {
        //     System.out.println(rs.getString("id") + " : " + rs.getString("username"));
        // }
    }
}