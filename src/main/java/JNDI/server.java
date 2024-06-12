package JNDI;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class server {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(2333);
        tachi tachi = new tachi();
        tachi.setDamage(80);
        tachi.setSkill("bailiezhan");

        registry.bind("tachi", tachi);

        tachi sword = (tachi) registry.lookup("tachi");
        System.out.println(sword.toString());


    }
}
class tachi implements Serializable, Remote {
    private String skill;
    private int damage;

    @Override
    public String toString() {
        return "tachi{" +
                "skill='" + skill + '\'' +
                ", damage=" + damage +
                '}';
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
