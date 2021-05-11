package streamOrnekler;

import java.util.ArrayList;
import java.util.List;

public class Stream02Integer {

    public static void main(String[] args) {

        List<Integer> liste = new ArrayList<>();
        liste.add(12);
        liste.add(9);
        liste.add(13);
        liste.add(4);
        liste.add(9);
        liste.add(2);
        liste.add(4);
        liste.add(12);
        liste.add(15);

        tekKareYazdir(liste);

        System.out.println("\nTOPLAM = " + tekKupToplami(liste));
    }

    public static void tekKareYazdir(List<Integer> l) {
        l.stream().filter(Stream01Integer::tekMi).distinct().map(x -> x*x).forEach(Stream01Integer::yazdir);
    }

    public static int tekKupToplami(List<Integer> l) {
        return l.stream().filter(Stream01Integer::tekMi).map(x -> x*x*x).reduce(0, Integer::sum);
    }

}
