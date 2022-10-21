package com.example.materiai_ui;

public class Item {
    private int Hinh;
    private String tieuDe, moTa, gia;

    public Item(int hinh, String tieuDe, String moTa, String gia) {
        Hinh = hinh;
        this.tieuDe = tieuDe;
        this.moTa = moTa;
        this.gia = gia;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
