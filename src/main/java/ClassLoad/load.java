package ClassLoad;

public class load {
    public static void main(String[] args) throws ClassNotFoundException {
        Class roleclass = Class.forName("ClassLoad.Role");
        System.out.println("------------------");
        Class role2 = Class.forName("ClassLoad.Role",false,ClassLoader.getSystemClassLoader());

    }
}

class Role{
    public static String name;
    static {
        System.out.println("静态代码块执行");
    }
    {
        System.out.println("构造代码块执行");
    }

    public Role() {
        System.out.println("无参构造器执行");
    }

    public Role(String name) {
        this.name = name;
        System.out.println("有参构造器执行");
    }
}