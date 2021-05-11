package streamOrnekler;

import java.util.List;
import java.util.stream.*;

public class Stream05Digerleri {

    public static void main(String[] args) {

        System.out.println("TOPLAM : " + topla(4) );
        topla1(4);
        System.out.println("=======");
        tekTopla(1,7);
        System.out.println("=======");
        System.out.println("Faktoryel : " +faktoryel(5));
        System.out.println("=======");
        System.out.println("FaktoryelInt : " +faktoryel(15));
        System.out.println("=======");
        System.out.println("FaktoryelLong : " +faktoryel1(20));
        System.out.println("=======");
        System.out.println("FaktoryelDouble : " +faktoryel2(34));
        System.out.println("=======");
        System.out.println(doubleDiziCevir());
    }

    public static int topla(int deger) {
        return IntStream.range(1,deger+1).sum();
    }

    public static void topla1(int deger) {
        IntStream.rangeClosed(1,deger).forEach(System.out::println);
    }

    //belirtilen aralıktaki tek sayıların toplamını yazdıran metodu tanımlayınız
    public static void tekTopla(int alt,int ust) {
        int sum = IntStream.rangeClosed(alt,ust).filter(Metotlar::tekMi).sum();
        System.out.println(sum);
    }

    //belirtilen bir sayının faktoryelini hesaplayan metodu tanımlayınız
    public static Integer faktoryel(int n) {
        return IntStream.rangeClosed(1,n).reduce(1, (x,y) -> x*y);
    }

    public static Long faktoryel1(long n) {
        return LongStream.rangeClosed(1,n).reduce(1, (x, y) -> x*y);
    }

    public static Double faktoryel2(int n) {
        return DoubleStream.iterate(1, x -> x+1).limit(n).reduce(1, (x, y) -> x*y);
    }

    //double bir diziyi Stream nesnesine dönusturun
    //50'den buyuk olan sayıları ayrı bir dizi yap ve yazdır
    public static List<Double> doubleDiziCevir() {
        Double[] notlar = {88.5, 52.3, 88.9, 100.0, 99.6, 42.0, 10.0};
        Stream<Double> streamNotlar = Stream.of(notlar);
        return streamNotlar.filter(x -> x > 50).collect(Collectors.toList());
    }

}
