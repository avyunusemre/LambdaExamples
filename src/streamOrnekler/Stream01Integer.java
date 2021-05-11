package streamOrnekler;

import java.util.ArrayList;
import java.util.List;

public class Stream01Integer {

    public static void main(String[] args) {
        List<Integer> rakamlar = new ArrayList<>();
        rakamlar.add(5);
        rakamlar.add(5);
        rakamlar.add(7);
        rakamlar.add(7);
        rakamlar.add(9);
        rakamlar.add(-1);
        rakamlar.add(2);
        rakamlar.add(4);
        rakamlar.add(-1000);
        rakamlar.add(4);

        rakamlar.stream().filter(f -> f % 2 != 0).forEach(System.out::println);

        System.out.println("==================================");

        rakamlar.stream().filter(f -> f % 2 == 0).forEach(Stream01Integer::yazdir);

        System.out.println("\n==================================");

        rakamlar.stream().filter(Stream01Integer::tekMi).forEach(Stream01Integer::yazdir);

        System.out.println("\n==================================");

        ciftleriYazdir(rakamlar);
    }

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
