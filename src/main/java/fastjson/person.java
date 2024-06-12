package fastjson;

import java.io.IOException;
import java.util.Properties;

public class person {
    public int id;
    private String name;
    private int age;
    private int money;

    private Properties exp;

    public Properties getExp() throws IOException {
        System.out.println("getExp");
        Runtime.getRuntime().exec("calc");
        return exp;
    }

    public int getMoney() {
        System.out.println("getMoney");
        return money;
    }

    public void setName(String name) {
        System.out.println("nameSet");
        this.name = name;
    }

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                ", exp=" + exp +
                '}';
    }

    public person() {
    }

    public person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        System.out.println("IDget");
        return id;
    }

    public void setId(int id) {
        System.out.println("IDset");
        this.id = id;
    }

    public String getName() {
        System.out.println("nameGet");
        return name;
    }


    public int getAge() {
        System.out.println("getAge");
        return age;
    }

}
