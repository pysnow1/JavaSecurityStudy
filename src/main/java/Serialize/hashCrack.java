package Serialize;

public class hashCrack {
    public static void main(String[] args) {
        String a = "bb";
        String b = "cC";
        int code_a = a.hashCode();
        int code_b = b.hashCode();
        System.out.println(a+": "+code_a+" "+b+": "+code_b);
    }
}
