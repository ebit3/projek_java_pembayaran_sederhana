package com.fixproyek1;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Nasabah> nasabahs;
    private RiwayatTransaksi riwayatTransaksi;
    private User loginUser;
    private Admin admin;

    public Bank() {
        this.nasabahs = new ArrayList<>();
        this.riwayatTransaksi = new RiwayatTransaksi();
        this.admin = new Admin("admin", "admin", "admin");
    }

    public User getLoginUser() {
        return loginUser;
    }

    public void tambahNasabah(Nasabah nasabah) {
        nasabahs.add(nasabah);
    }

    public void TambahTransaksii(Nasabah pengirim, Nasabah penerima, double jumlah) {
        // Pengecekan saldo cukup atau tidak
        if (pengirim.getBankAkun().getSaldo() >= jumlah) {
            // Saldo pengirim cukup
            pengirim.getBankAkun().setSaldo(pengirim.getBankAkun().getSaldo() - jumlah);
            penerima.getBankAkun().setSaldo(penerima.getBankAkun().getSaldo() + jumlah);

            // Pencatatan transaksi
            Transaksi transaksi = new Transaksi(pengirim, penerima, jumlah);
            riwayatTransaksi.tambahTransaksi(transaksi);

            System.out.println("Transaksi berhasil.");
        } else {
            // Saldo pengirim tidak cukup
            System.out.println("Transaksi gagal. Saldo tidak mencukupi.");
        }
    }

    public ArrayList<Nasabah> getNasabah() {
        return nasabahs;
    }

    public RiwayatTransaksi getRiwayatTransaksi() {
        return riwayatTransaksi;
    }

    public User login(String inputUsername, String inputPassword) {
        for (Nasabah nasabah : nasabahs) {
            if (nasabah.login(inputUsername, inputPassword)) {
                loginUser = nasabah;
                return loginUser;
            }
        }

        if (admin.login(inputUsername, inputPassword)) {
            loginUser = admin;
            return loginUser;
        }

        return null;
    }
}
