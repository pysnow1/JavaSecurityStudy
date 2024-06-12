package prestudy;

import java.io.Serializable;

class Person implements Serializable {
    public String name;
    public int age;
}

public class getclass {
    public static void main(String[] args) throws ClassNotFoundException {

        Class claz = ClassLoader.getSystemClassLoader().loadClass("prestudy.Person");

    }
}
