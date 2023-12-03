package com.fixproyek1;

import java.util.ArrayList;

public class Admin extends User {

    public Admin(String nama, String username, String password) {
        super(nama, username, password);
    }

    public void displayCustomers(ArrayList<Nasabah> nasabahs) {
        for (Nasabah nasabah : nasabahs) {
            System.out.println("====================Detail Nasabah==================");
            System.out.println("Nama Nasabah: " + nasabah.getNama());
            System.out.println("Username Nasabah: " + nasabah.getUsername());
            System.out.println("Saldo Nasabah: " + nasabah.getBankAkun().getSaldo());
            System.out.println("=======================================");
        }
    }
}
