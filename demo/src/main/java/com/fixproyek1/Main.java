package com.fixproyek1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Bank bank = new Bank();

        int pilihan;
        int subPilihan1;

        do {

            System.out.println("<====== Pilihan ======>");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Batal");

            System.out.println("Masukkan pilihan : ");

            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("Login");

                    User loginAdmin = login(scanner, bank);

                    if (loginAdmin != null) {

                        if (loginAdmin instanceof Admin) {
                            menuAdmin(scanner, bank);
                        } else {

                            System.err.println("Jenis pengguna tidak ada");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Registrasi");
                    tambahNasabah(scanner, bank);

                    do {

                        System.out.println("<====== Pilihan ======>");
                        System.out.println("1. Login");
                        System.out.println("2. Batal");

                        System.out.println("Masukkan pilihan : ");

                        subPilihan1 = scanner.nextInt();

                        switch (subPilihan1) {
                            case 1:
                                System.out.println("Login");
                                // login(scanner, bank);

                                User loginUser = login(scanner, bank);

                                if (loginUser != null) {
                                    if (loginUser instanceof Nasabah) {
                                        menuNasabah(scanner, bank);
                                    } else if (loginUser instanceof Admin) {
                                        menuAdmin(scanner, bank);
                                    } else {
                                        System.out.println("Jenis pengguna tidak valid.");
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Keluar");
                                break;

                            default:
                                System.out.println("Pilihan tidak terdaftar");
                                break;
                        }

                    } while (subPilihan1 != 2);
                    break;
                case 3:
                    System.out.println("keluar");
                    break;

                default:
                    System.out.println("Pilihan tidak terdaftar");
                    break;
            }

        } while (pilihan != 3);

        scanner.close();
    }

    private static void menuAdmin(Scanner scanner, Bank bank) {

        int subPilihan;

        do {
            System.out.println("============ Halaman Admin ============");
            System.out.println("<====== Pilihan ======>");
            System.out.println("1. Lihat Nasabah");
            System.out.println("2. Cari Nasabah");
            System.out.println("3. Ubah Saldo Pribadi");
            System.out.println("4. Keluar");

            System.out.println("Masukkan pilihan anda");

            subPilihan = scanner.nextInt();

            switch (subPilihan) {
                case 1:
                    System.out.println("Lihat Nasabah");
                    tampilkanNasabah(bank);
                    break;
                case 2:
                    System.out.println("Cari Nasabah");

                    System.out.print("Masukkan username nasabah : ");
                    String usernameNasabah = scanner.next();

                    Nasabah nasabah = cariNasabah(bank, usernameNasabah);

                    if (nasabah != null) {
                        System.out.println("Nasabah ditemukan:");
                        System.out.println("Nama: " + nasabah.getNama());
                        System.out.println("Username: " + nasabah.getUsername());
                        System.out.println("Nomor Rekening: " + nasabah.getBankAkun().getNomorAkun());
                        System.out.println("Saldo: " + nasabah.getBankAkun().getSaldo());
                    } else {
                        System.out.println("Nasabah Tidak ditemukan");
                    }
                    break;
                case 3:
                    System.out.println("Ubah Saldo Pribadi");
                    ubahSaldoCustomer(scanner, bank);
                    break;
                case 4:
                    System.out.println("keluar");
                    break;
                default:
                    System.out.println("Pilihan tidak ditemukan");
                    break;
            }
        } while (subPilihan != 4);
    }

    private static void menuNasabah(Scanner scanner, Bank bank) {

        int subPilihan;

        do {
            System.out.println("============ Halaman Nasabah ============");
            System.out.println("<====== Pilihan ======>");
            System.out.println("1. Lihat Profil");
            System.out.println("2. Simpan Uang");
            System.out.println("3. Lihat Riwayat Transaksi");
            System.out.println("4. Transfer Uang");
            System.out.println("5. Keluar");

            System.out.println("Masukkan pilihan anda");

            subPilihan = scanner.nextInt();

            switch (subPilihan) {
                case 1:
                    System.out.println("Lihat Profil");
                    menuLihatProfil(bank);
                    break;
                case 2:
                    System.out.println("Simpan Uang");
                    simpanUang(scanner, bank);
                    break;
                case 3:
                    System.out.println("Riwayat Transaksi");
                    lihatRiwayatTransaksi(bank);
                    break;
                case 4:
                    System.out.println("Transfer Uang");
                    transferUang(scanner, bank);
                    break;
                case 5:
                    System.out.println("Keluar");
                    break;
                default:
                    System.out.println("Pilihan tidak ditemukan");
                    break;
            }
        } while (subPilihan != 5);
    }

    private static void menuLihatProfil(Bank bank) {
        User loginUser = bank.getLoginUser();

        if (loginUser instanceof Nasabah) {
            Nasabah nasabah = (Nasabah) loginUser;
            nasabah.lihatProfil();

            // Panggil simpanUang dengan memberikan parameter bank
            // nasabah.simpanUang(100.0, bank);
        } else {
            System.out.println("Anda bukan pelanggan. Lihat profil hanya untuk pelanggan.");
        }
    }

    private static void tampilkanNasabah(Bank bank) {
        System.out.println("Daftar Nasabah:");
        for (Nasabah nasabah : bank.getNasabah()) {
            System.out.println(nasabah);
        }
    }

    private static void tambahNasabah(Scanner scanner, Bank bank) {

        System.out.println("masukkan nama : ");
        String nama = scanner.next();
        System.out.println("masukkan username : ");
        String username = scanner.next();
        System.out.println("masukkan password : ");
        String password = scanner.next();
        System.out.println("masukkan Nomor Akun : ");
        String nomorAkun = scanner.next();
        System.out.println("masukkan saldo awal : ");
        double saldoAwal = scanner.nextDouble();

        Nasabah nasabahBaru = new Nasabah(nama, username, password, nomorAkun, saldoAwal);
        bank.tambahNasabah(nasabahBaru);

        System.out.println("Customer baru berhasil ditambahkan");
    }

    private static void simpanUang(Scanner scanner, Bank bank) {
        if (bank.getLoginUser() instanceof Nasabah) {
            Nasabah nasabah = (Nasabah) bank.getLoginUser();
            System.out.print("Masukkan jumlah uang yang ingin disimpan: ");
            double jumlahUang = scanner.nextDouble();
            nasabah.simpanUang(jumlahUang, bank);
        } else {
            System.out.println("Anda bukan pelanggan. Simpan uang hanya untuk pelanggan.");
        }
    }

    private static void lihatRiwayatTransaksi(Bank bank) {
        RiwayatTransaksi riwayatTransaksi = bank.getRiwayatTransaksi();
        if (riwayatTransaksi.getTransaksi().isEmpty()) {
            System.out.println("Tidak ada transaksi yang dilakukan.");
        } else {
            System.out.println("Riwayat Transaksi:");
            riwayatTransaksi.tampilTransaksi();
        }
    }

    private static Nasabah cariNasabah(Bank bank, String username) {
        for (Nasabah nasabah : bank.getNasabah()) {
            if (nasabah.getUsername().equals(username)) {
                return nasabah;
            }
        }
        return null;
    }

    private static void ubahSaldoCustomer(Scanner scanner, Bank bank) {
        System.out.print("Masukkan username Nasabah: ");
        String username = scanner.next();
        System.out.print("Masukkan jumlah saldo baru: ");
        double newSaldo = scanner.nextDouble();

        Nasabah nasabah = cariNasabah(bank, username);

        if (nasabah != null) {
            BankAdmin bankAdmin = new BankAdmin("admin1", "admin1", "admin1");
            bankAdmin.ubahSaldo(nasabah, newSaldo);
            System.out.println("Saldo berhasil diubah.");
        } else {
            System.out.println("nasabah tidak ditemukan.");
        }
    }

    private static void transferUang(Scanner scanner, Bank bank) {
        System.out.print("Masukkan username pengirim: ");
        String usernamePengirim = scanner.next();
        System.out.print("Masukkan username penerima: ");
        String usernamePenerima = scanner.next();
        System.out.print("Masukkan jumlah yang akan ditransfer: ");
        double jumlahTransfer = scanner.nextDouble();

        // Cari pelanggan pengirim dan penerima
        Nasabah pengirim = null;
        Nasabah penerima = null;

        for (Nasabah nasabah : bank.getNasabah()) {
            if (nasabah.getUsername().equals(usernamePengirim)) {
                pengirim = nasabah;
            } else if (nasabah.getUsername().equals(usernamePenerima)) {
                penerima = nasabah;
            }
        }

        // Lakukan transfer jika pengirim dan penerima ditemukan
        if (pengirim != null && penerima != null) {
            bank.TambahTransaksii(pengirim, penerima, jumlahTransfer);
        } else {
            System.out.println("Pengirim atau penerima tidak ditemukan.");
        }
    }

    private static User login(Scanner scanner, Bank bank) {
        System.out.print("Masukkan username: ");
        String username = scanner.next();
        System.out.print("Masukkan password: ");
        String password = scanner.next();

        User loginUser = bank.login(username, password);

        if (loginUser != null) {
            System.out.println("Login berhasil sebagai " + loginUser.getNama());
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }

        return loginUser;
    }

}