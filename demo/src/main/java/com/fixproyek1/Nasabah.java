package com.fixproyek1;

public class Nasabah extends User {

    private BankAkun bankAkun;

    public Nasabah(String nama, String username, String password, String nomorAkun, double saldo) {
        super(nama, username, password);
        this.bankAkun = new BankAkun(saldo, nomorAkun);
    }

    public BankAkun getBankAkun() {
        return bankAkun;
    }

    public void lihatRiwayatTransaksi(Bank bank) {
        bank.getRiwayatTransaksi().tampilTransaksi();
    }

    public void simpanUang(double jumlah, Bank bank) {
        double saldoSaatIni = this.getBankAkun().getSaldo();
        this.getBankAkun().setSaldo(saldoSaatIni + jumlah);

        Transaksi transaksi = new Transaksi(this, this, jumlah);
        bank.getRiwayatTransaksi().tambahTransaksi(transaksi);

        System.out.println("Simpan uang berhasil");
        System.out.println("\n");
    }

    @Override
    public String toString() {
        return "Customer [ nama = " + getNama() + ", Username = " + getUsername() + ", Bank Account = " + bankAkun
                + "]";
    }

    public void lihatProfil() {
        System.out.println("Profil Pelanggan:");
        System.out.println("Nama: " + getNama());
        System.out.println("Username: " + getUsername());
        System.out.println("Nomor Rekening: " + bankAkun.getNomorAkun());
        System.out.println("Saldo: " + bankAkun.getSaldo());
    }
}
