package XMLDecoder;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        XMLDecoder d = new XMLDecoder(
                new BufferedInputStream(
                        new FileInputStream("Test.xml")));
        Object result = d.readObject();
        System.out.println(result);
        d.close();
    }
}