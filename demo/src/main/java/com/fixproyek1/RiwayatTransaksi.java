package com.fixproyek1;

import java.util.ArrayList;

public class RiwayatTransaksi {

    private ArrayList<Transaksi> transaksis;

    public RiwayatTransaksi() {
        this.transaksis = new ArrayList<>();
    }

    public void tambahTransaksi(Transaksi transaksi) {
        transaksis.add(transaksi);
    }

    public void tampilTransaksi() {
        for (Transaksi transaksi : transaksis) {
            System.out.println("===================Detail Transaksi===================");
            System.out.println("Transaksi: " + transaksi.getJumlah() + " dari " +
                    transaksi.getPengirim().getNama() + " ke " + transaksi.getPenerima().getNama());
            System.out.println("=======================================");
        }
    }

    public ArrayList<Transaksi> getTransaksi() {
        return transaksis;
    }
}
