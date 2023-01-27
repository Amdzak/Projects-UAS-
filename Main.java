/**
 *
 * @author Amdzak
 */

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static String name[] = new String[1];
    static String NIK[] = new String[1];
    static String pass[] = new String[1];
    static double setor[] = new double[100];
    static int tarik[] = new int[100];
    static int BCA[] = new int[100];
    static int BNI[] = new int[100];
    static int BRI[] = new int[100];
    static int Mandiri[] = new int[100];
    static int saldo = 1000000, nilai = 0,nilai1 = 0,bca=0,bni=0,bri=0,mandiri=0;
    
    public static void main(String[] args) {
        regristasi();
        login();
        ulang();
    }    

    private static String ulang(){
        int pilih;
        menu();     
        pilih = input.nextInt(); 
        pilihan(pilih); 
        return ulang(); 
    }
    
    private static void regristasi(){
        System.out.println("=== ATM SEDERHANA ===");
//      TIPE DATA
        String nama,nik,password;
        boolean kondisi = true; 
        while(kondisi){ 
//          REGRISTASI
            System.out.println("\n=== REGRISTASI MENU ===");
            System.out.print("Masukan nama: ");
            nama = input.nextLine(); 
            System.out.print("Masukan NIK: ");
            nik = input.nextLine(); 
            System.out.print("Masukan password: ");
            password = input.nextLine(); 
            if(nama.equals("") || nik.equals("")|| password.equals("")){ 
                System.out.println("SEMUA FORM HARUS DI ISI");
            }else{ 
                System.out.println("PENDAFTARAN BERHASIL");
                name[0] = nama;     
                NIK[0] = nik;       
                pass[0] = password; 
                kondisi = false;
            }
        }
    }
    
    private static void login(){
//      TIPE DATA
        String nik,password;
        boolean kondisi = true; 
        while(kondisi){ 
            System.out.println("\n=== LOGIN MENU ===");
            System.out.print("Masukan NIK :");
            nik = input.nextLine(); 
            System.out.print("Masukan Password :");
            password = input.nextLine(); 
            if(nik.equals(NIK[0]) && password.equals(pass[0])){ 
                System.out.println("NIK DAN PASSWORD BENAR");  
                kondisi = false; 
            } else {   
                System.out.println("Login gagal cek kembali NIK dan password");
            }
        }
    }   
    
    private static void menu(){
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("Selamat Datang " + name[0]);
        System.out.println("Silahkan pilih menu dibawah");
        System.out.println(" 1. Info Saldo");
        System.out.println(" 2. Setor ");
        System.out.println(" 3. Tarik ");
        System.out.println(" 4. Transfer ");
        System.out.println(" 5. Cetak Transaksi ");
        System.out.println(" 6. Keluar ");
        System.out.print("Pilih menu (1/2/3/4/5/6): ");
    }
    
    private static void pilihan(int pilih){
        switch(pilih){
            case 1 :
                info();
                break;
            case 2 :
                setor();
                break;
            case 3 :
                tarik();
                break;
            case 4 :
                transfer();
                break;
            case 5 :
                cetak(); 
                break;
            case 6 :
                System.exit(0);
                break;
            default :  
                System.out.print("\n"); 
        }
    }
    
    private static void info(){
        System.out.println("\n\t===== Saldo anda adalah =====");
        System.out.println("\t===== \tRp " + saldo + "\t=====");
    }
    
    private static void setor(){
//      TIPE DATA
        double uang,total,bunga;

        System.out.println("Masukan jumlah uang yang ingin ditambahkan");
        System.out.print("Rp ");
        uang = input.nextInt();
        if(uang >= 15000000){ 
            bunga = uang * 0.03; 
            total = uang + bunga; 
            System.out.println("\t Anda dikenakan bunga sebanyak 3% \n\tTotal uang yang masuk sebanyak Rp " + (int)total);
            setor[nilai] = total;
            nilai++; 
            saldo += total; 
        } else if(uang >= 8000000){ 
            bunga = uang * 0.025;
            total = uang + bunga; 
            System.out.println("\t Anda dikenakan bunga sebanyak 2.5% \n\tTotal uang yang masuk sebanyak Rp " + (int)total);
            setor[nilai] = total; 
            nilai++; 
            saldo += total; 
        } else if (uang >= 2000000){ 
            bunga = uang * 0.02; 
            total = uang + bunga; 
            System.out.println("\t Anda dikenakan bunga sebanyak 2% \n\tTotal uang yang masuk sebanyak Rp " + (int)total);
            setor[nilai] = total; 
            nilai++; 
            saldo += total; 
        } else{    
            setor[nilai] = uang;
            nilai++;
            saldo += uang; 
        }
    }

    private static void tarik(){
//      TIPE DATA
        int ambil,total,pil,sisa;
        boolean kondisi = true; 
        boolean henti = true; 
        while(kondisi){ 
            System.out.print("\nMasukan jumlah uang yang ingin anda tarik \n Rp ");
            ambil = input.nextInt(); 
            if(ambil < saldo){ 
                sisa = saldo - ambil; 
                
                if (sisa < 50000){ 
                     do{
                            System.out.println("\nMinimal sisa saldo di atm sebanyak Rp 50.000");

                            System.out.print("1. Kembali\n2. Lanjut\n pilih (1/2)");
                            pil = input.nextInt();

                            if(pil == 1){       
                                henti = false;
                                kondisi = false; 
                            } else if(pil == 2){
                                henti = false;
                            } else{ 
                                System.out.print("Pilih menu (1/2)");
                            }
                        } while (henti);
                } else { 
                    if(ambil >= 15000000){ 
                        do{
                            System.out.println("Mohon maaf anda melebihi batas nimonal penarikan \n");

                            System.out.print("1. Kembali\n2. Lanjut\n pilih (1/2)");
                            pil = input.nextInt();

                            if(pil == 1){
                                henti = false;
                                kondisi = false;
                            } else if(pil == 2){
                                henti = false;
                            } else{
                                System.out.print("Pilih menu (1/2)");
                            }
                        } while (henti);
                    } else if (ambil >= 2000000){ 
                        total = ambil - 8000;
                        System.out.println("Anda terkena biaya admin Sebanyak Rp 8000");
                        System.out.println("Total saldo yang masuk sebesar Rp " + total);                    
                        tarik[nilai1] = total; 
                        nilai1++; 
                        saldo -= total; 
                        kondisi = false;
                    } else if (ambil < 50000) { 
                        do{
                            System.out.println("Minimal penarikan Rp 50000\n");

                            System.out.print("1. Kembali\n2. Lanjut\n pilih (1/2)");
                            pil = input.nextInt();

                            if(pil == 1){
                                henti = false;
                                kondisi = false;
                            } else if(pil == 2){
                                henti = false;
                            } else{
                                System.out.print("Pilih menu (1/2)");
                            }
                        } while (henti);
                    } else { 
                        System.out.println("\n\tPenarikan anda sebanyak " + ambil);
                        tarik[nilai1] = ambil; 
                        nilai1++; 
                        saldo -= ambil; 
                        kondisi = false;
                    }
                }
            } else { 
                do{
                    System.out.println("Saldo tidak mencukupi \n");
                
                    System.out.print("1. Kembali\n2. Lanjut\n pilih (1/2)");
                    pil = input.nextInt();
                    
                    if(pil == 1){
                        henti = false;
                        kondisi = false;
                    } else if(pil == 2){
                        henti = false;
                    } else{
                        System.out.print("Pilih menu (1/2)");
                    }
                } while (henti);
            }
        }
    }

    private static void transfer(){
        //TIPE DATA
        int pilihan;
        boolean kondisi = true;
        
        do { 
            System.out.println("\nPilihan Bank \n 1.BCA\n 2.BRI \n 3.BNI \n 4.Mandiri \n 5.Kembali ke Menu");
            System.out.print("Pilih menu (1/2/3/4/5): ");
            pilihan = input.nextInt(); 
            
            switch (pilihan){
                case 1 : 
                    bca(); 
                    break; 
                case 2 : 
                    bri(); 
                    break;
                case 3 : 
                    bni(); 
                    break; 
                case 4 : 
                    mandiri(); 
                    break;
                case 5 : 
                    kondisi = false; 
                    break;
                default : 
                    System.out.println("\nSilahkan Pilih Menu yang tersedia\n"); 
            }
        } while(kondisi);
    }

    private static void bca(){
        //TIPE DATA
        int nilai,total,sisa;

        System.out.println("Transfer ke BCA (Bank Central Asia)");
        System.out.println("Biaya admin sebesar Rp 6000");
        System.out.print("Masukan nominal transfer \n Rp ");
        nilai = input.nextInt();
        
        if(nilai < saldo){ 
            sisa = saldo - nilai;
            if(sisa < 50000){ 
                System.out.println("Sisa saldo di ATM minimal Rp 50000");
            } else {
                if(nilai < 20000){ 
                    System.out.println("Minimal transfer Rp 20000");
                } else {
                    total = nilai - 6000; 
                    
                    System.out.println("\n\t === Total transfer anda ===\n\t === Rp " + total + " ===");

                    BCA[bca] = total; 
                    bca++;
                    saldo -= total; 
                }
            }
        } else {
            System.out.println("Saldo anda tidak mencukupi");
        }
    }

    private static void bri(){
        int nilai,total,sisa;
        
        System.out.println("Transfer ke BRI (Bank Rakyat Indonesia)");
        System.out.println("Biaya admin sebesar Rp 0");
        System.out.print("Masukan nominal transfer \n Rp ");
        nilai = input.nextInt();
        
        if(nilai < saldo){
            sisa = saldo - nilai;
            
            if(sisa < 50000){
                System.out.println("Sisa saldo di ATM minimal Rp 50000");
            } else {
                if(nilai < 20000){
                    System.out.println("Minimal transfer Rp 20000");
                } else {
                    total = nilai - 0;

                    System.out.println("\n\t === Total transfer anda ===\n\t === Rp " + total + " ===");

                    BRI[bri] = total; 
                    bri++; 
                    saldo -= total; 
                }
            }
        } else {
            System.out.println("Saldo anda tidak mencukupi");
        }
    }

    private static void bni(){
        int nilai,total,sisa;
        
        System.out.println("Transfer ke BNI(Bank Negara Indonesia)");
        System.out.println("Biaya admin sebesar Rp 5000");
        System.out.print("Masukan nominal transfer \n Rp ");
        nilai = input.nextInt();
        
        if(nilai < saldo){
            sisa = saldo - nilai;
            
            if(sisa < 50000){
                System.out.println("Sisa saldo di ATM minimal Rp 50000");
            } else {
                if(nilai < 20000){
                    System.out.println("Minimal transfer Rp 20000");
                } else {
                    total = nilai - 5000;

                    System.out.println("\n\t === Total transfer anda ===\n\t === Rp " + total + " ===");

                    BNI[bni] = total; 
                    bni++; 
                    saldo -= total; 
                }
            }
        } else {
            System.out.println("Saldo anda tidak mencukupi");
        }
    }

    private static void mandiri(){
        int nilai,total,sisa;
        
        System.out.println("Transfer ke Bank Mandiri");
        System.out.println("Biaya admin sebesar Rp 5000");
        System.out.print("Masukan nominal transfer \n Rp ");
        nilai = input.nextInt();
        
        if(nilai < saldo){
            sisa = saldo - nilai;
            
            if(sisa < 50000){
                System.out.println("Sisa saldo di ATM minimal Rp 50000");
            } else {
                if(nilai < 20000){
                    System.out.println("Minimal transfer Rp 20000");
                } else {
                    total = nilai - 5000;

                    System.out.println("\n\t === Total transfer anda ===\n\t === Rp " + total + " ===");

                    Mandiri[mandiri] = total;
                    mandiri++; 
                    saldo -= total;
                }
            }
        } else {
            System.out.println("Saldo anda tidak mencukupi");
        }
    }

    private static void cetak(){
        
            System.out.println("\n ===== Riwayat Setor =====");
            if(nilai > 0){ 
                for(int i=0;i<nilai;i++){ 
                    System.out.println("\t" + (i+1) + ". " + (int)setor[i]); 
                }
            } else {
                System.out.println("\tBelum ada Transaksi");
            }
            
            System.out.println("\n ===== Riwayat Penarikan =====");
            if(nilai1 > 0){
                for(int i=0;i<nilai1;i++){
                    System.out.println("\t" + (i+1) + ". " + (int)tarik[i]);
                }
            } else {
                System.out.println("\tBelum ada Transaksi");
            }
            
            System.out.println("\n ===== Riwayat Transfer =====");
            System.out.println("\t BCA");
            if(bca > 0){
                for(int i=0;i<bca;i++){
                    System.out.println("\t" + (i+1) + ". " + BCA[i]);
                }
            } else {
                System.out.println("\tBelum ada Transaksi");
            }
            
            System.out.println("\t BRI");
            if(bri > 0){
                for(int i=0;i<bri;i++){
                    System.out.println("\t" + (i+1) + ". " + BRI[i]);
                }
            } else {
                System.out.println("\tBelum ada Transaksi");
            }
            
            System.out.println("\t BNI");
            if(bri > 0){
                for(int i=0;i<bri;i++){
                    System.out.println("\t" + (i+1) + ". " + BRI[i]);
                }
            } else {
                System.out.println("\tBelum ada Transaksi");
            }
            
            System.out.println("\t Mandiri");
            if(mandiri > 0){
                for(int i=0;i<mandiri;i++){
                    System.out.println("\t" + (i+1) + ". " + Mandiri[i]);
                }
            } else {
                System.out.println("\tBelum ada Transaksi");
            }
    }
}
