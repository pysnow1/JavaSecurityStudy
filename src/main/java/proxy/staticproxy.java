package proxy;

public class staticproxy {
    public static void use(weapon weapon) {
        weapon.attack();
    }

    public static void main(String[] args) {
        weapon taidao = new taidao();
        System.out.println("代理之前");
        use(taidao);
        System.out.println("代理之前");
        use(new weaponagent(taidao));
    }
}

interface weapon { // 代理接口
    public void attack();

}

class taidao implements weapon { // 委托类


    @Override
    public void attack() {
        System.out.println("Use taidao attack");
    }
}

class weaponagent implements weapon { // 代理类
    private weapon target;

    public weaponagent(weapon target) {
        this.target = target;
    }

    @Override
    public void attack() {
        System.out.println("Shift the taidao");
        this.target.attack();
    }
}