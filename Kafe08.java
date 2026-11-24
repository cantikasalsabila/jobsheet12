import java.util.Scanner;

public class Kafe08 {

    public static void Menu(String namaPelanggan, boolean isMember, int jamKunjung) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");
        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }
        if (jamKunjung >= 14 && jamKunjung <= 16) {
            System.out.println("Happy Hour! Diskon 20% untuk semua minuman");
        }
        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("===========================");
        System.out.println("Silakan pilih menu yang Anda inginkan.");
    }

    public static int hitungTotalHarga08(int pilihanMenu, int banyakItem) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

        if (pilihanMenu < 1 || pilihanMenu > hargaItems.length) {
            return -1;
        }
        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
        return hargaTotal;
    }
    
    public static int hitungDiskon(int total, String kodePromo, boolean isMember) {
        int persen = 0;

        if (kodePromo.equalsIgnoreCase("DISKON50")) {
            persen = 50;
        } else if (kodePromo.equalsIgnoreCase("DISKON30")) {
            persen = 30;
        } else if (!kodePromo.isEmpty()) {
            System.out.println("Kode promo invalid");
        }

        if (isMember) {
            persen += 10; 
        }

        return total * persen / 100;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nama pelanggan: ");
        String nama = sc.nextLine();
        System.out.print("Member? (y/n): ");
        boolean member = sc.nextLine().trim().equalsIgnoreCase("y");
        System.out.print("Jam kunjung (0-23): ");
        int jam = sc.nextInt();

        Menu(nama, member, jam);

        int totalHarga = 0;
        while (true) {
            System.out.print("Masukkan nomor menu (0 = selesai): ");
            int pilihanMenu = sc.nextInt();
            if (pilihanMenu == 0) {
                break;
            }
            System.out.print("Masukkan jumlah item yang ingin dipesan: ");
            int banyakItem = sc.nextInt();

            int totalBayar = hitungTotalHarga08(pilihanMenu, banyakItem);
            if (totalBayar < 0) {
                System.out.println("Menu tidak tersedia");
            } else {
                System.out.println("Subtotal: Rp" + totalBayar);
                totalHarga += totalBayar;
            }
        }

        sc.nextLine(); 
        System.out.print("Kode promo (kosongkan jika tidak ada): ");
        String kode = sc.nextLine().trim();

        int diskon = hitungDiskon(totalHarga, kode, member);
        int harusDibayar = totalHarga - diskon;

        System.out.println("Total harga      : Rp" + totalHarga);
        System.out.println("Diskon           : Rp" + diskon);
        System.out.println("Total yang dibayar: Rp" + harusDibayar);

        sc.close();
    }
}