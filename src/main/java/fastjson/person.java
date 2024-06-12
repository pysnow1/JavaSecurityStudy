package fastjson;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        System.out.println("constructor");
    }

    public String getName() {
        System.out.println("getName");
        return this.name;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    public int getAge() {
        System.out.println("getAge");
        return this.age;
    }

    public void setAge(int age) {
        System.out.println("setAge");
        this.age = age;
    }
}

