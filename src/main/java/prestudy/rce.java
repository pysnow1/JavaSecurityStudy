package prestudy;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.Scanner;

public class rce {
    public static void main(String[] args) throws Exception {
        Constructor proc = Class.forName("java.lang.ProcessImpl").getDeclaredConstructor(String[].class, String.class, String.class, long[].class, boolean.class);
        proc.setAccessible(true);
        Process process =(Process) proc.newInstance(new String[]{"cmd.exe", "/c", "whoami"}, null, null, new long[]{-1L, -1L, -1L}, false);
        InputStream in = process.getInputStream();

        Scanner scanner = new Scanner(in).useDelimiter("\\A");
        String out = scanner.hasNext() ? scanner.next() : "";
        System.out.println(out);

    }
}
