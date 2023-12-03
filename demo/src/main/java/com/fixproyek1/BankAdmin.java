package com.fixproyek1;

public class BankAdmin extends Admin {

    public BankAdmin(String username, String password, String nama) {
        super(nama, username, password);
    }

    public void ubahSaldo(Nasabah nasabah, double newSaldo) {
        nasabah.getBankAkun().setSaldo(newSaldo);
    }
}
