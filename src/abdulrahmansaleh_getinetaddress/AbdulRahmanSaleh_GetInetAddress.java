/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abdulrahmansaleh_getinetaddress;

import java.util.Scanner;
import java.net.InetAddress;

/**
 *
 * @author Abdul Rahman Saleh
 */
public class AbdulRahmanSaleh_GetInetAddress {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("================================================");
        System.out.println("                 Get IP Address");
        System.out.println("================================================");
        System.out.print("Masukkan nama domain    : ");
        String domain = sc.nextLine();
        System.out.println("------------------------------------------------");
        System.out.println();
        try {
            InetAddress inet1 = InetAddress.getByName(domain);
            String ip = inet1.getHostAddress();
            
            System.out.println("IP       : " + ip);
            System.out.print("IP Biner : " );
            
            //membagi IP menjadi 4 oktet
            String[] oktet = new String[4];
            oktet = ip.split("\\.");
            
            /* versi 1 */
            int[] ConvOktet = new int[4]; //untuk menampung nilai setiap oktet yang dikonversi ke tipe data integer
            String[] bin = new String[4]; //untuk menampung nilai setiap oktet yang dikonversi ke bilangan biner
            
            for(int i=0; i<oktet.length; i++){
                //mengubah nilai setiap oktet dari tipe data String ke Integer
                ConvOktet[i] = Integer.valueOf(oktet[i]);
                
                //mengonversi nilai setiap oktet ke bentuk biner
                bin[i] = Integer.toBinaryString(ConvOktet[i]);
                
                //memberi nol tambahan (agar hasil konversi nilai biner setiap oktet yang kurang dari 8 bit menjadi 8 bit)
                String nol = "00000000";
                bin[i] = nol.substring(bin[i].length()) + bin[i];
                
                /* MENAMPILKAN BINER */
                //ketika perulangan belum mencapai / bukan oktet ke 4
                if(i!=3){
                    // setelah angka biner tiap oktet ditambah "." sebagai pemisah dengan oktet setelahnya
                    System.out.print(bin[i] + "."); 
                }
                //setelah oktet 4 maka tidak ditambah "."
                else{
                    System.out.println(bin[i]);
                }
            }

            /* atau versi 2 yaitu tanpa melakukan perulangan (di inisialisasi satu per satu)
            
                // mengkonversi tiap oktet ke bentuk tipe data Integer
                int oktet1 = Integer.valueOf(oktet[0]);
                int oktet2 = Integer.valueOf(oktet[1]);
                int oktet3 = Integer.valueOf(oktet[2]);
                int oktet4 = Integer.valueOf(oktet[3]);

                // mengkonversi tiap oktet ke bentuk biner
                String bin1 = Integer.toBinaryString(oktet1);
                String bin2 = Integer.toBinaryString(oktet2);
                String bin3 = Integer.toBinaryString(oktet3);
                String bin4 = Integer.toBinaryString(oktet4);

                // memberi nol tambahan (agar hasil konversi nilai biner setiap oktet yang kurang dari 8 bit menjadi 8 bit)
                String nol = "00000000";
                bin1=nol.substring(bin1.length()) + bin1;
                bin2=nol.substring(bin2.length()) + bin2;
                bin3=nol.substring(bin3.length()) + bin3;
                bin4=nol.substring(bin4.length()) + bin4;

                System.out.println(bin1 + "." + bin2 + "." + bin3 + "." + bin4); 
            */
            System.out.println();
            System.out.println("================================================");
            System.out.println();
            System.out.println("©Abdul Rahman Saleh - 1931710038");
        } catch (Exception e) {
            
        }
    }
    
}
