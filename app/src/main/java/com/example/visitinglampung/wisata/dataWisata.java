package com.example.visitinglampung.wisata;

public class dataWisata {
    private String nama, jam_buka, jam_tutup, rating, tiket;

    public dataWisata(String nama, String jamBuka, String jamTutup, String rating, String tiket) {
        this.nama = nama;
        this.jam_buka = jamBuka;
        this.jam_tutup = jamTutup;
        this.rating = rating;
        this.tiket = tiket;
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
        return tiket;
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
}
