package ClassLoad;

public class ClassLoad {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        loader.loadClass("ClassLoad.student");
    }
}

class student{
    static {
        System.out.println("student类初始化");
    }
}
