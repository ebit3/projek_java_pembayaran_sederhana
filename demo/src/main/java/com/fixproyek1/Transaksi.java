package com.fixproyek1;

public class Transaksi {

    private Nasabah pengirim;
    private Nasabah penerima;
    private double jumlah;

    public Transaksi(Nasabah pengirim, Nasabah penerima, double jumlah) {
        this.pengirim = pengirim;
        this.penerima = penerima;
        this.jumlah = jumlah;
    }

    public double getJumlah() {
        return jumlah;
    }

    public Nasabah getPengirim() {

        return pengirim;
    }

    public Nasabah getPenerima() {

        return penerima;
    }

    @Override
    public String toString() {
        return "Transaction [pengirim = " + pengirim + ", penerima = " + penerima + ", jumlah = " + jumlah + "]";
    }
}
