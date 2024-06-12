package rome;

import com.sun.syndication.feed.impl.ToStringBean;

public class toStringBeanTest {
    public static void main(String[] args) {
        ToStringBean toStringBean = new ToStringBean(Student.class,new Student("pysnow",20));
        System.out.println(toStringBean.toString());
    }
}

class Student{
    public String name;
    public int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}