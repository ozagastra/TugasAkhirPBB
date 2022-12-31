package com.example.Laundry13451;

public class modelproduk {
    String kodeProduk,nama,satuan;
    int harga,jumlah,gambar;

    public modelproduk(String kode, String nama, String satuan,int harga, int jumlah, int gambar) {
        this.kodeProduk = kode;
        this.nama = nama;
        this.satuan = satuan;
        this.harga = harga;
        this.jumlah = jumlah;
        this.gambar = gambar;
    }

    public String getKodeProduk(){
        return kodeProduk;
    }public void setKodeProduk(String kodeProduk) {
        this.kodeProduk = kodeProduk;
    }

    public String getNama() {
        return nama;
    }public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlah() {
        return jumlah;
    }public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getHarga() {
        return harga;
    }public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getSatuan() {
        return satuan;
    }public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
