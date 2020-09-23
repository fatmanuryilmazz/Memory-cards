/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorycards;

import java.util.Scanner;

/**
 *
 * @author Pc
 */
public class Memorycards {

   private static kart[][] kartlar = new kart[4][4];
    public static void main(String[] args) {
        // TODO code application logic here
        kartlar[0][0]= new kart('E');
        kartlar[0][1]= new kart('A');
        kartlar[0][2]= new kart('B');
        kartlar[0][3]= new kart('F');
        kartlar[1][0]= new kart('G');
        kartlar[1][1]= new kart('A');
        kartlar[1][2]= new kart('D');
        kartlar[1][3]= new kart('F');
        kartlar[2][0]= new kart('C');
        kartlar[2][1]= new kart('C');
        kartlar[2][2]= new kart('D');
        kartlar[2][3]= new kart('H');
        kartlar[3][0]= new kart('E');
        kartlar[3][1]= new kart('G');
        kartlar[3][2]= new kart('B');
        kartlar[3][3]= new kart('H');
        

        while(oyunBittimi()==false) {

            tahminEt();
        }
        System.out.println("Tebrikler.Oyunu başarıyla tamamladınız...");
    }
    public static void oyunTahtası(){

    System.out.println();
    System.out.println(" ------------------");
    for(int i = 0; i < 4 ; i++){

        for(int j = 0 ; j < 4 ; j++){

            if (kartlar[i][j].getTahmin()){

                System.out.print(" |"+ kartlar[i][j].getDeger()+"| ");

            }else{

                System.out.print(" | | ");

            }
        }
        System.out.println();
        System.out.println(" ------------------");
    }
}
    public static void tahminEt(){

    while(true) {

        oyunTahtası();

        Scanner sc = new Scanner(System.in);

        System.out.println("Birinci tahmininizin satırını giriniz :");

        int i1 = sc.nextInt() - 1;

        if (sayiKontrol(i1)) {

            System.out.println("Birinci tahmininizin sütununu giriniz :");

            int j1 = sc.nextInt() - 1;

            if(sayiKontrol(j1)) {

                kartlar[i1][j1].setTahmin(true);

                oyunTahtası();

                System.out.println("İkinci tahmininizin satırını giriniz :");

                int i2 = sc.nextInt() - 1;

                if (sayiKontrol(i2)) {

                    System.out.println("İkinci tahmininizin sütununu giriniz :");

                    int j2 = sc.nextInt() - 1;

                    if(sayiKontrol(j2)) {

                        if (kartlar[i1][j1].getDeger() == kartlar[i2][j2].getDeger()) {

                            System.out.println("Doğru Tahmin");
                            kartlar[i2][j2].setTahmin(true);
                            break;
                        } else {

                            System.out.println("Yanlış tahmin");
                            kartlar[i1][j1].setTahmin(false);
                            break;
                        }
                    }
                }}}}}
    public static boolean sayiKontrol(int sayi){

    if(0 <= sayi && sayi < 4 ){

        return true;
    }else {
        System.out.println("Lütfen satır,sütun değerlerinin dışında sayı girmeyiniz...");
        return false;
    }
}
    public static boolean oyunBittimi() {

    for (int i = 0; i < 4; i++) {

        for (int j = 0; j < 4; j++) {

            if (kartlar[i][j].getTahmin() == false) {
                return false;
            }
        }

    }
    return true;
}
}
