package com.example.visitinglampung.wisata;

public class dataWisata {
    String nama, alamat, maps, jam, image;
    Float tiket, rating;

    public dataWisata(String nama, String alamat, String maps, String jam, String image, Float tiket, Float rating) {
        this.nama = nama;
        this.alamat = alamat;
        this.maps = maps;
        this.jam = jam;
        this.image = image;
        this.tiket = tiket;
        this.rating = rating;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getMaps() {
        return maps;
    }

    public void setMaps(String mpas) {
        this.maps = maps;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Float getTiket() {
        return tiket;
    }

    public void setTiket(Float tiket) {
        this.tiket = tiket;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }


}
