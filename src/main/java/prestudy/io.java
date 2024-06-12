package prestudy;

import java.io.*;

class student implements Serializable {
    public String name;
    public int age;

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class io {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 新建对象
        student std = new student();
        std.name = "pysnow";
        std.age = 20;

        // 输出
        FileOutputStream out = new FileOutputStream("pysnow-std");
        ObjectOutputStream oss = new ObjectOutputStream(out);
        oss.writeObject(std);

        // 输入
        FileInputStream in = new FileInputStream("pysnow-std");
        ObjectInputStream inn = new ObjectInputStream(in);
        student stdd = (student) inn.readObject();

        System.out.println(stdd.toString());
    }
}
