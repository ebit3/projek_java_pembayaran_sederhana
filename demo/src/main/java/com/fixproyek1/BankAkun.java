package com.fixproyek1;

public class BankAkun {

    private double saldo;
    private String nomorAkun;

    public BankAkun(double saldo, String nomorAkun) {
        this.nomorAkun = nomorAkun;
        this.saldo = saldo;
    }

    public void setSaldo(double newSaldo) {
        this.saldo = newSaldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNomorAkun() {
        return nomorAkun;
    }

    @Override
    public String toString() {
        return "Akun Bank [Saldo = " + saldo + ", Nomor Akun = " + nomorAkun + "]";
    }
}
