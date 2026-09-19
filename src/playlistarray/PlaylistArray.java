package playlistarray;

public class PlaylistArray {
    public static void main(String[] args) {
        Playlist p = new Playlist();
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
}