package Serialize;

import java.io.*;
import java.util.Base64;

public class proto {
    public static void main(String[] args) throws IOException {
        student_person pysnow = new student_person(20,"pysnow",20210102);

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bytes);
        System.out.println("序列化");
        out.writeObject(pysnow);

        System.out.println(Base64.getEncoder().encodeToString(bytes.toByteArray()));
        for (byte b : bytes.toByteArray()){
            System.out.print(byteToHexString(b));
        }
    }
    private static String byteToHexString(byte b) {
        String hexString = Integer.toHexString(b & 0xFF);
        if (hexString.length() < 2) {
            hexString = "0" + hexString;
        }
        return "\\x" + hexString;
    }
}
class student_person implements Serializable{
    int age;
    String name;
    int id;

    public student_person(int age, String name, int id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }
}