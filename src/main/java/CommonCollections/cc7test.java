package CommonCollections;

import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.map.LazyMap;

import java.util.HashMap;
import java.util.Map;

public class cc7test {
    public static void main(String[] args) {
        Map innerMap1 = new HashMap();
        innerMap1.put("123", 1);
        Map innerMap2 = new HashMap();
        innerMap2.put("y0", 1);

        ConstantTransformer transformer = new ConstantTransformer(1);
        Map Lazymap = LazyMap.decorate(innerMap1, transformer);
        System.out.println(Lazymap.hashCode());
    }
}