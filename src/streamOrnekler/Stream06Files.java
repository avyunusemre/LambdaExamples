package streamOrnekler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Stream06Files {

    public static void main(String[] args) throws IOException {

        String path = "src/streamOrnekler/mars.txt";
        Stream<String> satirlar = Files.lines(Path.of(path));
        satirlar.forEach(System.out::println);
        System.out.println("================================================");

        //Dosyadan okunan satırları buyuk harf olarak konsola yazdıralım
        Files.lines(Paths.get(path)).map(String::toUpperCase).forEach(System.out::println);

        System.out.println("================================================");
        //Dosyadan okunan ilk satırı buyuk harf olarak konsola yazdıralım
        Files.lines(Path.of(path)).limit(1).map(String::toUpperCase).forEach(System.out::println);

        System.out.println("================================================");
        //3 ve 4. satırı secmek istiyorum
        Files.lines(Path.of(path)).map(String::toUpperCase).skip(2).limit(2).forEach(System.out::println);

        System.out.println("================================================");
        //Kac tane "bu" kelimesi geciyor
        System.out.println(Files.lines(Path.of(path)).
                            map(t -> t.toLowerCase().split(" ")).
                            flatMap(Arrays::stream).
                            filter(t -> t.equals("bu")).count());

        System.out.println("================================================");
        //dosyadaki tumkelimeleri alt alta yazalim
        Files.lines(Path.of(path))
                .map(t->t.toLowerCase().split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);

        System.out.println("================================================");
        //Kelimeler icerisinde M ve ya m harfi olanların sayısını yazdır
        System.out.println(Files.lines(Path.of(path)).map(t -> t.toLowerCase().split(""))
                            .flatMap(Arrays::stream)
                            .filter(t -> t.equals("m"))
                            .count());

        System.out.println("================================================");
        //Bosluk ve noktalama isaretleri haric kac karakter kullanıldıgını
        //hesaplayarak sonucu yazdıran uygulamayı yazalım
        //\\W "a-z" U "A-Z" U "0-9" U "_" haric tum karakterler demektir.
        System.out.println(Files.lines(Path.of(path))
                                    .map(t -> t.replaceAll("\\W","").split(""))
                                    .flatMap(Arrays::stream)
                                    .count());
    }

}
