package hastane;

import java.util.*;

public class HastaIslemler extends VeriBankasi{

    public static int hastaID=107;

    static Scanner input=new Scanner(System.in);

    static List<Hasta> hastaListesi = new ArrayList<>();

    public static void hastaMenu(){

        System.out.println("==============HASTA MENUSU==============");
        System.out.println("1-Hasta Ekle\n" +
                "2-Hasta Listesi\n" +
                "3-Hasta Durumu Listesi\n" +
                "4-Hasta Silme\n" +
                "5-Hasta Bulma\n" +
                "6-Verileri Yukle\n" +
                "7-Ana Menu\n" +
                "8-Cikis ");


        String secim= "";

            secim = input.next();



        switch (secim) {
            case "1":
                hastaEkle();
                hastaMenu();
                break;
            case "2":
                hastaListesi();
                hastaMenu();
                break;
            case "3":
                hastaDurumuListesi();
                hastaMenu();
                break;
            case "4":
                hastaSil();
                hastaMenu();
                break;
            case "5":
                hastaBul();
                hastaMenu();
                break;
            case "6":
                veriBankasiHastalariEkle();
                hastaMenu();
                break;
            case "7":
                HastaneIslemler.hastaneMenusu();
                break;
            case "8":
                System.out.println("Sistemden cikis yapiliyor...");
                break;
            default:
                System.out.println("Gecerli bir deger giriniz...");
                hastaMenu();
                break;

        }
    }


    private static void hastaEkle() {

        System.out.println("Hasta adi giriniz: ");
        input.nextLine();
        String isim= input.nextLine();
        System.out.println("Hasta soyadi giriniz: ");
        String soyIsim=input.nextLine();
        System.out.println("Hasta durumu giriniz: ");
        String hastaDurum=input.nextLine().toLowerCase();

        boolean aciliyet=false;

        if (hastaDurum.contains("kalp")){
            aciliyet=true;
        }

        Durum durum=new Durum(hastaDurum,aciliyet);

        Hasta hasta=new Hasta(isim,soyIsim,hastaID,durum);
        hastaListesi.add(hasta);
        hastaID++;
    }

    private static void hastaListesi() {

        for (Hasta w : hastaListesi) {
            System.out.println(w.getHastaID()+" "+w.getIsim()+" "+w.getSoyIsim());
        }

    }

    private static void hastaDurumuListesi() {
        for (Hasta w : hastaListesi) {
            System.out.println(w);
        }
    }

    private static void hastaSil() {
        System.out.println("Silmek istediginiz hastanin ID'sini giriniz: ");
        int ID=input.nextInt();

        boolean flag=true;

        try {
            for (Hasta w : hastaListesi) {
                if (w.getHastaID()==ID){
                    hastaListesi.remove(w);
                    flag=false;

                    for (Hasta s : hastaListesi) {
                        System.out.println(s.getHastaID()+" "+s.getIsim()+" "+s.getSoyIsim());
                    }
                }
            }
        } catch (Exception e) {

        }

        if (flag){
            System.out.println("Aradiginiz ID'ye ait hasta bulunmamaktadir...");
        }
    }

    private static void hastaBul() {

        System.out.println("Bulmak istediginiz hastanin ID'sini giriniz: ");
        int ID=input.nextInt();

        boolean flag=true;

        for (Hasta w : hastaListesi) {
            if (w.getHastaID()==ID){
                System.out.println(w);
                flag=false;
            }
        }

        if (flag){
            System.out.println("Aradiginiz ID'ye ait hasta bulunmamaktadir...");
        }

    }

    private static void veriBankasiHastalariEkle() {


        for (int i = 0; i < hastaIDleri.length; i++) {
            boolean aciliyet=false;
            if (durumlar[i].contains("Kalp")) {
                aciliyet=true;
            }
            Durum durum=new Durum(durumlar[i],aciliyet);
            Hasta hasta=new Hasta(hastaIsimleri[i],hastaSoyIsimleri[i],hastaIDleri[i],durum);
            hastaListesi.add(hasta);
        }

    }

}
