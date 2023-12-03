package com.fixproyek1;

public class User {

    private String nama;
    private String username;
    private String password;

    public User(String nama, String username, String password) {
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    @Override
    public String toString() {
        return "User [ nama = " + nama + ", Username = " + username + "]";
    }
}
