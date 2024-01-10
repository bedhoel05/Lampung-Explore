package com.example.visitinglampung.wisata;

public class dataWisata {
    private String nama;
    private String jam_buka;
    private String jam_tutup;
    private String rating;
    private String tiket;
    private String image;
    private String maps_link;
    private String deskripsi;
    private String alamat;
    private String telepon;

    public dataWisata(String nama, String jam_buka, String jam_tutup, String rating, String tiket, String image, String mapsLink, String alamat, String deskripsi, String telepon) {
        this.nama = nama;
        this.jam_buka = jam_buka;
        this.jam_tutup = jam_tutup;
        this.rating = rating;
        this.tiket = tiket;
        this.image = image;
        this.maps_link = mapsLink;
        this.deskripsi = deskripsi;
        this.alamat = alamat;
        this.telepon = telepon;

    }


    // Metode getter dan setter untuk atribut image

    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return image;
    }

    public String getNama() {
        return nama;
    }
    public String getJam_buka() {
        return "Buka "+jam_buka;
    }

    public String getJam_tutup() {
        return "Tutup "+jam_tutup;
    }

    public String getRating() {
        return rating;
    }

    public String getTiket() {
        return "Rp. "+tiket+"/Orang";
    }

    public String getAlamat() {
        return alamat;
    }

    public String getMaps_link() {
        return maps_link;
    }

    public String getTelepon() {
        return telepon;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJam_buka(String jam_buka) {
        this.jam_buka = jam_buka;
    }

    public void setJam_tutup(String jam_tutup) {
        this.jam_tutup = jam_tutup;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setTiket(String tiket) {
        this.tiket = tiket;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public void setMaps_link(String maps_link) {
        this.maps_link = maps_link;
    }
}
