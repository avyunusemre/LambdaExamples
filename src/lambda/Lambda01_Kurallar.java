package lambda;

import java.util.Arrays;
import java.util.List;

public class Lambda01_Kurallar {

    public static void main(String[] args) {

        List<Integer> liste = Arrays.asList(1, 2, 3, 4, 5);
        //Listenin elemanlarini yazdiralim
        liste.forEach(x -> System.out.println(x));

        System.out.println("===============");
        //Listenin elemanlarini 2'ser artirarak yazdiralim
        liste.forEach(x -> System.out.print(x + 2 + " "));

        System.out.println("\n===============");
        liste.forEach(x -> {
                int miktar = 3;
                System.out.print(x + miktar + " ");
        });


        System.out.println("\n=============");
        //Veri tipi kullanilirsa Explicit
        liste.forEach((Integer x) -> System.out.print(x*2 + " "));

        System.out.println("\n=============");
        //Bir dış degiske kullanalim
        int deger = 5; //ifade dısında tanımlanan degiskeni forEach icinde degistiremeyiz. Final gibi davranır
        liste.forEach(x -> System.out.print(x + deger + " "));

        System.out.println("\n=============");
        //Metod referansi ====> Class adı :: Method adı
        liste.forEach(System.out::println);

        System.out.println("\n=============");
        liste.forEach(Lambda01_Kurallar::yazdir);
    }

    public static void yazdir(int x) {
        System.out.print(x + " ");
    }
}
