package ClassLoad;

import com.sun.org.apache.bcel.internal.Repository;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import com.sun.org.apache.bcel.internal.classfile.Utility;

public class BCEL {
    public static void main(String[] args) throws Exception {
        Class evil = Class.forName("ClassLoad.evil");
        JavaClass bcel = Repository.lookupClass(evil);
        String encoded = Utility.encode(bcel.getBytes(),true);
        System.out.println(encoded);
    }
}
