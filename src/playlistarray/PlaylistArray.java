package playlistarray;
import java.util.Scanner;

public class PlaylistArray {
    public static void main(String[] args) {
        Playlist p = new Playlist();
        p.tambahLagu(); //testing insertion
        p.tampilkanSemuaLagu(); // testing sementara
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

class Playlist {
    private Lagu[] playlist;
    private int jumlahLagu;

    public Playlist() {
        playlist = new Lagu[10];
        jumlahLagu = 0;
    }

    public void tampilkanSemuaLagu() {
        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong.");
            return;
        }
        System.out.println("Daftar lagu saat ini:");
        for (int i = 0; i < jumlahLagu; i++) {
            System.out.println((i + 1) + ". " + playlist[i].getJudul()
                + " - " + playlist[i].getArtis()
                + " (" + playlist[i].getDurasi() + " menit)");
        }
    }

    // Menambahkan lagu baru ke playlist
    public void tambahLagu() {
        if (jumlahLagu >= playlist.length) {
            System.out.println("Playlist sudah penuh.");
            return;
        }

        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan judul lagu: ");
        String judul = input.nextLine();

        System.out.print("Masukkan artis: ");
        String artis = input.nextLine();

        System.out.print("Masukkan durasi (menit): ");
        double durasi = input.nextDouble();

        playlist[jumlahLagu] = new Lagu(judul, artis, durasi);
        jumlahLagu++;

        System.out.println("Lagu berhasil ditambahkan!");
    }
}
