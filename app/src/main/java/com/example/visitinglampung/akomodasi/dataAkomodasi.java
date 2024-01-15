package com.example.visitinglampung.akomodasi;

public class dataAkomodasi {

    private String nama;
    private String rating;
    private String deskripsi;
    private String telepon;
    private String website;
    private String instagram;
    private String alamat;
    private String image;
    private String maps_link;

    public dataAkomodasi(String nama, String rating, String deskripsi, String telepon, String website, String instagram, String alamat, String image, String maps_link) {
        this.nama = nama;
        this.rating = rating;
        this.deskripsi = deskripsi;
        this.telepon = telepon;
        this.website = website;
        this.instagram = instagram;
        this.alamat = alamat;
        this.image = image;
        this.maps_link = maps_link;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMaps_link() {
        return maps_link;
    }

    public void setMaps_link(String maps_link) {
        this.maps_link = maps_link;
    }
}
