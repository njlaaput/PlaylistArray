import java.util.Scanner;

public class PlaylistArray { //class menu playlist untuk memilih fungsi yang diinginkan
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Playlist p = new Playlist(input);

        int pilihan;
        do {
            System.out.println("\n=== MENU PLAYLIST ===");
            System.out.println("1. Tampilkan semua lagu");
            System.out.println("2. Tambah lagu baru");
            System.out.println("3. Hapus lagu berdasarkan judul");
            System.out.println("4. Cari lagu berdasarkan judul");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilihan = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                pilihan = -1;
            }

            System.out.println();
            switch (pilihan) {
                case 1: p.tampilkanSemuaLagu(); break;
                case 2: p.tambahLagu(); break;
                case 3: p.hapusLagu(); break;
                case 4: p.cariLagu(); break;
                case 5: System.out.println("Program selesai."); break;
                default: System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }
}

class Lagu {
    private String judul;
    private String artis;
    private double durasi;

    public Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getArtis() { return artis; }
    public void setArtis(String artis) { this.artis = artis; }

    public double getDurasi() { return durasi; }
    public void setDurasi(double durasi) { this.durasi = durasi; }

    public void tampilkanInfo() {
        System.out.println(judul + " - " + artis + " (" + durasi + " menit)");
    }
}

class Playlist { //membuat batas maksimal lagu pada playlist 
    private static final int MAKS = 10;
    private Lagu[] playlist = new Lagu[MAKS];
    private int jumlahLagu = 0;
    private Scanner input;

    public Playlist(Scanner input) {
        this.input = input;
    }

    
    private double bacaDurasi() { //membacar durasi agar durasi yang dimasukkan berupa angka
        while (true) {
            System.out.print("Masukkan durasi (menit): ");
            String teks = input.nextLine().trim().replace(',', '.');
            try {
                double d = Double.parseDouble(teks);
                if (d > 0) return d;
                System.out.println("Durasi harus lebih dari 0.");
            } catch (NumberFormatException e) {
                System.out.println("Durasi tidak valid, coba lagi.");
            }
        }
    }

    

    public void tampilkanSemuaLagu() { //menampilkan lagu yang sudah diisi dan jika kosong akan ada pesan khusus
        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong.");
            return;
        }
        System.out.println("Daftar lagu saat ini (" + jumlahLagu + "/" + MAKS + "):");
        for (int i = 0; i < jumlahLagu; i++) {
            System.out.print((i + 1) + ". ");
            playlist[i].tampilkanInfo();
        }
    }

    
    private int cariIndex(String judul) {
        for (int i = 0; i < jumlahLagu; i++) {
            if (playlist[i].getJudul().equalsIgnoreCase(judul)) {
                return i;
            }
        }
        return -1;
    }

    public void cariLagu() {//mencari lagu dalam playlist
        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong.");
            return;
        }
        System.out.print("Masukkan judul lagu yang dicari: ");
        String judul = input.nextLine().trim();

        int idx = cariIndex(judul);
        if (idx == -1) {
            System.out.println("Lagu \"" + judul + "\" tidak ditemukan.");
        } else {
            System.out.print("Ditemukan di posisi " + (idx + 1) + ": ");
            playlist[idx].tampilkanInfo();
        }
    }

    public void tambahLagu() {//membuat fungsi jika lagu pada playlkist sudah penuh, jika belum maka akan membaca class bacaLagu 
        if (jumlahLagu >= MAKS) {
            System.out.println("Playlist sudah penuh (maksimal " + MAKS + " lagu).");
            return;
        }
        playlist[jumlahLagu] = bacaLagu();
        jumlahLagu++;
        System.out.println("Lagu berhasil ditambahkan!");
    }

    private Lagu bacaLagu() { //menambahkan lagu dan membuat array
        System.out.print("Masukkan judul lagu: ");
        String judul = input.nextLine().trim();
        System.out.print("Masukkan artis: ");
        String artis = input.nextLine().trim();
        double durasi = bacaDurasi();
        return new Lagu(judul, artis, durasi);
    }

    public void hapusLagu() {//menghapus lagu pada playlist
        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong, tidak ada yang bisa dihapus.");
            return;
        }

        System.out.print("Masukkan judul lagu yang ingin dihapus: ");
        String judul = input.nextLine().trim();

        int idx = cariIndex(judul);
        if (idx == -1) {
            System.out.println("Lagu \"" + judul + "\" tidak ditemukan.");
            return;
        }

        // Geser elemen setelahnya ke kiri agar array tetap rapat
        for (int i = idx; i < jumlahLagu - 1; i++) {
            playlist[i] = playlist[i + 1];
        }
        playlist[jumlahLagu - 1] = null;
        jumlahLagu--;

        System.out.println("Lagu \"" + judul + "\" berhasil dihapus.");
    }
}
