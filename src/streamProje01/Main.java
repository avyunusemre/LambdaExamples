package streamProje01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static List<Ogrenci> ogrList = new ArrayList<>();

    public static void main(String[] args) {

        testOgrenciOlustur();
        ismeGoreListele("ahmet");
        ismeGoreListele("ayşe");
        ismeGoreListele("john");
    }

    private static void ismeGoreListele(String isim) {

        if(ogrList.stream().noneMatch(o -> o.getAd().equalsIgnoreCase(isim))) {
            System.out.println( isim + " isminde bir öğrenci bulunmamaktadır!");
        } else {
            ogrList.stream().filter(t -> t.getAd().equalsIgnoreCase(isim)).forEach(System.out::println);
        }

    }


    private static void testOgrenciOlustur() {
        ogrList.add(new Ogrenci("Ahmet","Can",30,88.4, "erkek"));
        ogrList.add(new Ogrenci("Ahmet","Baki",18,90.1, "erkek"));
        ogrList.add(new Ogrenci("Ayşe","Can",21,82.3, "kadın"));
        ogrList.add(new Ogrenci("Mustafa","Can",15,75.4, "erkek"));
        ogrList.add(new Ogrenci("Ayşe","Yılmaz",40,45, "kadın"));
        ogrList.add(new Ogrenci("Ali","Veli",80,35.5, "erkek"));
        ogrList.add(new Ogrenci("Veli","Öztürk",20,95.5, "erkek"));

    }


}
