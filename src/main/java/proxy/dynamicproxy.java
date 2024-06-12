package proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class dynamicproxy {

    public static void main(String[] args) {
        tachi tachi = new tachi();
        System.out.println("代理之前");
        tachi.attack();

        System.out.println("代理之后");
        ClassLoader classloader = tachi.getClass().getClassLoader();
        Class<?>[] interfaces = tachi.getClass().getInterfaces();
        InvocationHandler invocation = new swordagent(tachi);

        weapon proxy = (weapon) Proxy.newProxyInstance(classloader, interfaces, invocation);
        proxy.attack();
    }
}

class tachi implements weapon{ // 委托类


    public void attack() {
        System.out.println("Use taidao attack");
    }


}

class swordagent implements InvocationHandler { // 代理类
    private Object target;

    public swordagent(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Shift the tachi");
        return method.invoke(target, args);
    }
}