package hastane;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HastaneIslemler {

    public static void hastaneMenusu(){

        Scanner input=new Scanner(System.in);

        System.out.println("==============HASTANE MENUSU==============");

        System.out.println("-Doktor menusu icin 1'e    \n" +
                           "-Hasta menusu icin 2'e\n" +
                           "-Cikis icin 0'a basin   ");
        int secim= 0;

        try {
            secim = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Gecersiz karakter girdiniz.Yeniden deneyin...");
            hastaneMenusu();
        }

        switch (secim){
            case 1:
                DoktorIslemler.doktorMenu();
                break;
            case 2:
                HastaIslemler.hastaMenu();
                break;
            case 0:
                System.out.println("Sistemden cikis yapildi...");
                break;
            default:
                System.out.println("Gecerli bir deger giriniz...");
                hastaneMenusu();

        }

    }
}
