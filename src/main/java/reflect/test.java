package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class test {
    public static void main(String[] args) throws Exception {
        taidao taidao = new taidao();
        Field durable = taidao.getClass().getDeclaredField("durable");

//        System.out.println(durable.get(taidao));

        Field modify = durable.getClass().getDeclaredField("modifiers");
        modify.setAccessible(true);
        modify.setInt(durable, durable.getModifiers() & ~Modifier.FINAL);

        durable.set(taidao,"success");
        System.out.println(durable.get(taidao));

    }
}

class weapon {
    public String name = "pysnow";
}

class taidao extends weapon {
    public int damage;
    private String skill;
    public static final String durable = "blank";


    public taidao() {
    }

    public taidao(int damage, String skill) {
        this.damage = damage;
        this.skill = skill;
    }

}