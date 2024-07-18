package reflect;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class bean {
    public static void main(String[] args){
        try {
            // 获取 Person 类的 BeanInfo
            BeanInfo beanInfo = Introspector.getBeanInfo(aPerson.class);

            // 获取所有属性描述符
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            // 遍历属性描述符，获取 getter 和 setter 方法
            for (PropertyDescriptor pd : propertyDescriptors) {
                String propertyName = pd.getName();
                if (!"class".equals(propertyName)) { // 排除 getClass 方法
                    System.out.println("Property: " + propertyName);
                    System.out.println("Getter: " + pd.getReadMethod());
                    System.out.println("Setter: " + pd.getWriteMethod());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class aPerson{
    private String name;
    private int age;
    public aPerson(String name, int age){
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