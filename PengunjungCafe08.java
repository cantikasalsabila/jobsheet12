public class PengunjungCafe08 {
    static void daftarPengunjung(int nomorMeja, String... namaPengunjung) {
    System.out.println("Meja nomor " + nomorMeja);
    System.out.println("Daftar Nama Pengunjung:");
    for (String nama : namaPengunjung) {
        System.out.println("- " + nama);
    }
}

static int hitungTotalBelanja(int... harga) {
    int total = 0;
    for (int h : harga) {
        total += h;
    }
    return total;
}

    public static void main(String[] args) {
        daftarPengunjung(1, "Andi", "Budi", "Citra");
        System.out.println(hitungTotalBelanja(15000));                              
        System.out.println(hitungTotalBelanja(15000, 20000, 22000));                
        System.out.println(hitungTotalBelanja(15000, 20000, 22000, 12000, 10000));  
}
    }

