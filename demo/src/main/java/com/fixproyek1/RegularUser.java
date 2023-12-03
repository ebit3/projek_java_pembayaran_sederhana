package com.fixproyek1;

public class RegularUser extends Nasabah {

    public RegularUser(String nama, String username, String password, String nomorAkun, double saldo) {
        super(nama, username, password, nomorAkun, saldo);
    }

    public void lihatRiwayatTransaksi(Bank bank) {
        bank.getRiwayatTransaksi().tampilTransaksi();
    }
}
