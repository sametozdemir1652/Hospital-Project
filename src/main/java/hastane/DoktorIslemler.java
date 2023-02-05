package hastane;

import java.io.FilterOutputStream;
import java.util.*;

public class DoktorIslemler extends VeriBankasi{





    static List<Doktor> doktorList = new ArrayList<>();

    static Scanner input=new Scanner(System.in);
    public static void doktorMenu() {


        System.out.println("==============DOKTOR MENUSU==============");
        System.out.println("1-Doktor Ekle\n" +
                           "2-Doktor Listesi\n" +
                           "3-Doktor Bulma\n" +
                           "4-Doktor Silme\n" +
                           "5-Verileri Yukle\n" +
                           "6-Ana Menu\n" +
                           "7-Cikis ");

        String secim = input.next();

        switch (secim) {
            case "1":
                doktorEkle();
                doktorMenu();
                break;
            case "2":
                doktorListesi();
                doktorMenu();
                break;
            case "3":
                doktorBul();
                doktorMenu();
                break;
            case "4":
                doktorSil();
                doktorMenu();
                break;
            case "5":
                veriBankasiDoktorlariEkle();
                doktorMenu();
                break;
            case "6":
                HastaneIslemler.hastaneMenusu();
                break;
            case "7":
                System.out.println("Sistemden cikis yapiliyor...");
                break;
            default:
                System.out.println("Gecerli bir deger giriniz...");
                doktorMenu();
                break;

        }
    }

    private static void doktorEkle() {
        System.out.println("Doktor adini giriniz: ");
        input.nextLine(); //dummy scanner
        String isim=input.nextLine();
        System.out.println("Doktor soyadi giriniz: ");
        String soyIsim=input.nextLine();
        System.out.println("Doktor unvan giriniz: ");
        String unvan=input.nextLine().toLowerCase();


        Doktor doktor = new Doktor(isim,soyIsim,unvan);
        doktorList.add(doktor);

    }

    private static void doktorListesi() {


        for (Doktor w : doktorList) {
            System.out.println(w);
        }

    }

    private static void doktorBul() {
        System.out.println("Aradiginiz doktorun unvanini giriniz: ");
        input.nextLine();
        String unvan=input.nextLine();

        boolean flag=true;

        for (Doktor w : doktorList) {
            if (w.getUnvan().equalsIgnoreCase(unvan)){
                System.out.println(w);
                flag=false;
            }
        }
        if (flag){
            System.out.println("Aradiginiz unvanda doktor bulunamamistir...");
        }


    }

    private static void doktorSil (){


        System.out.println("Silmek istediginiz doktorun unvanini giriniz: ");
        input.nextLine();
        String unvan=input.nextLine();
        System.out.println("Silmek istediginiz doktorun adini giriniz: ");

        String isim=input.nextLine();
        System.out.println("Silmek istediginiz doktorun soyadini giriniz: ");
        String soyIsim=input.nextLine();

        boolean flag=true;

        try {
            for (Doktor w : doktorList) {
                if (w.getIsim().equalsIgnoreCase(isim)&&w.getSoyIsim().equalsIgnoreCase(soyIsim)&&w.getUnvan().equalsIgnoreCase(unvan)){
                    doktorList.remove(w);
                    for (Doktor doktor : doktorList) {
                        System.out.println(doktor);
                    }
                    flag=false;
                }

            }
        } catch (Exception e) {

        }

        if (flag){
            System.out.println("Silmek istediginiz bilgilerde doktor yoktur...");
        }
    }


    private static void veriBankasiDoktorlariEkle(){


        for (int i = 0; i < unvanlar.length; i++) {
           Doktor doktor=new Doktor(doctorIsimleri[i],doctorSoyIsimleri[i],unvanlar[i]);
           doktorList.add(doktor);
        }
    }
}
