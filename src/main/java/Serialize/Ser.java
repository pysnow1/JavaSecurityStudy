package Serialize;

import java.io.*;

class Person {

    public Person() {
        System.out.println("父类无参数构造器");
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    private String name;
    public int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person implements Serializable {
    private int grade;
    public String school_name;

    public Student(String name, int age, int grade, String school_name) {
        super(name, age);
        this.grade = grade;
        this.school_name = school_name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade=" + grade +
                ", school_name='" + school_name + '\'' +
                '}';
    }
}

public class Ser {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student std = new Student("pysnow", 20,3,"SWPU");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bytes);
        System.out.println("序列化");
        out.writeObject(std);

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()));
        System.out.println("反序列化");
        Student stdd = (Student) in.readObject();


        System.out.println(stdd.toString());
    }
}
