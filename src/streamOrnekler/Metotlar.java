package streamOrnekler;

import java.util.List;

public class Metotlar {
    public static void ciftleriYazdir(List<Integer> liste) {
        liste.stream().filter(Stream01Integer::ciftMi).forEach(Stream01Integer::yazdir);
    }

    public static boolean tekMi(int x) {
        return x % 2 != 0;
    }

    public static boolean ciftMi(int x) {
        return x % 2 == 0;
    }

    public static void yazdir(int x) {
        System.out.print(x + " ");
    }
}
