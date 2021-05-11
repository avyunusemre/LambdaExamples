package streamOrnekler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream03Integer {

    public static void main(String[] args) {

        List<Integer> liste = new ArrayList<>();
        liste.add(12);
        liste.add(9);
        liste.add(13);
        liste.add(4);
        liste.add(9);
        liste.add(4);
        liste.add(12);
        liste.add(15);
        liste.add(25);
        liste.add(-1);
        liste.add(1);
        liste.add(-2);

        System.out.println("En BÜYÜK DEĞER : " + buyukBul(liste));
        System.out.println("En BÜYÜK DEĞER : " + buyukBul1(liste));
        System.out.println("En BÜYÜK DEĞER : " + buyukBul2(liste));
        System.out.println("En KÜÇÜK DEĞER : " + kucukBul(liste));
        System.out.println("ÇARPIM : " + carpma(liste));
        System.out.println("DOKUZ SAY : " + dokuzSay(liste));
        System.out.println("NEGATIF LIST : " + negativeList(liste));
        System.out.println("TEK SAYILARIN KARELERİNİN LİSTESİ : " + tekKareSiraliList(liste));
        System.out.println("TEK SAYILARIN KARELERİNİN TERS SIRALI LİSTESİ : " + tekKareTersSiraliList(liste));
    }

    public static int buyukBul(List<Integer> list) {
        return list.stream().reduce(0,(x,y) -> x > y ? x : y);
    }

    public static int buyukBul1(List<Integer> list) {
        return list.stream().reduce(0,Math::max);
    }

    public static int buyukBul2(List<Integer> list) {
        return list.stream().sorted().reduce(0,(x,y)->y);
    }

    public static int kucukBul(List<Integer> list) {
        return list.stream().reduce(Integer.MAX_VALUE,(x,y) -> x < y ? x : y);
    }

    public static int carpma(List<Integer> list) {
        return list.stream().reduce(1,(x,y) -> x*y);
    }

    public static int dokuzSay(List<Integer> list) {
        return (int) list.stream().filter(x -> x == 9).count();
    }

    public static List<Integer> negativeList(List<Integer> list) {
        return list.stream().filter(x -> x < 0).collect(Collectors.toList());
    }

    //listedeki tek elemanların karelerini sıralı ve tekrarsız bir sekilde
    //listeye kaydeden metodu yazınız
    public static List<Integer> tekKareSiraliList(List<Integer> list) {
        return list
                .stream()
                .filter(Metotlar::tekMi)
                .map(x -> x*x)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    //listedeki tek elemanların karelerini ters sıralı ve tekrarsız bir sekilde
    //listeye kaydeden metodu yazınız
    public static List<Integer> tekKareTersSiraliList(List<Integer> list) {
        return list
                .stream()
                .filter(Metotlar::tekMi)
                .map(x -> (int)Math.pow(x,2))
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
