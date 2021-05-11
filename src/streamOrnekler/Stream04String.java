package streamOrnekler;

import java.util.*;

public class Stream04String {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Ali");
        list.add("Mark");
        list.add("Jackson");
        list.add("Amanda");
        list.add("Mariano");
        list.add("alberto");
        list.add("Tucker");
        list.add("Christ");
        list.add("Yunus Emre");
        list.add("alonzo");
        list.add("Alfonso");

        AileBaslayanlar(list);
        System.out.println("==========");
        buyukHarfeCevir(list);
        System.out.println("===========");
        uzunlugaGoreSiralaKucult(list);
        System.out.println("===========");
        uzunlukFiltrele(list,5);
        System.out.println("===========");
        System.out.println(kucukMu(list,13));
        System.out.println("===========");
        System.out.println("BASLAYAN YOK MU : "+ baslamayanHarf(list,"T"));
        System.out.println("===========");
        System.out.println("ILE BITEN ELEMAN VAR MI : " + bitenElemanVarMi(list,"e"));
        System.out.println("===========");
        aIleBaslaOileBit(list);
        System.out.println("===========");
        karakterSayisi(list);
        System.out.println("\n===========");
        yazdir(list);

    }

    public static void AileBaslayanlar(List<String> list) {
        list.stream().filter(h -> h.startsWith("A")).forEach(System.out::println);
    }

    public static void buyukHarfeCevir(List<String> list) {
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    //Listedeki tüm elemanları uzunluklarına göre sıralayan ve küçük harfe ceviren kod
    public static void uzunlugaGoreSiralaKucult(List<String> list) {
        list.stream()
                .sorted(Comparator.comparing(String::length))
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }

    //Belirtilen uzunluktaki ve daha büyük elemanları yazdir.
    public static void uzunlukFiltrele(List<String> list,int uzunluk) {
        list.stream().filter(x -> x.length() >= uzunluk).forEach(System.out::println);
    }

    //Belirtilen uzunluktan kucukMu diye kontrol eden metod
    public static boolean kucukMu(List<String> list,int uzunluk) {
        return list.stream().allMatch(t -> t.length() < uzunluk);
    }

    //Belirtilen bir harfle başlamadığını kontrol eden metodu yazın
    public static boolean baslamayanHarf(List<String> list, String harf) {
        return list.stream().noneMatch(t -> t.startsWith(harf));
    }

    //Belirtilen harf ile biten eleman listede var mı
    public static boolean bitenElemanVarMi(List<String> list, String harf) {
        return list.stream().anyMatch(t -> t.endsWith(harf));
    }

    //A ile baslayan O ile biten elemanlari yazdir
    public static void aIleBaslaOileBit(List<String> list) {
        list.stream().filter(t -> t.startsWith("A") && t.endsWith("o")).forEach(System.out::println);
    }

    public static void karakterSayisi(List<String> list) {
        list.stream().sorted(Comparator.comparing(String::length))
                .map(t -> t + " : " + t.length() + "\t")
                .forEach(System.out::print);
    }

    public static void yazdir(List<String> list) {
        list.stream().
                map(String::toLowerCase).
                filter(t -> t.startsWith("a")).
                forEach(System.out::println);
    }

}
