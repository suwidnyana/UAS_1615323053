package com.example.uas_1615323053;

public class User {

        String nama;
        String tgl;
        String alamat;
        String email;
        String username;
        String password;

        public User(String nama, String tgl, String alamat, String email, String username, String password) {
            this.nama = nama;
            this.tgl = tgl;
            this.alamat = alamat;
            this.email = email;
            this.username = username;
            this.password = password;
        }

        public String getUsername() { return username; }

        public String getPassword() {
            return password;
        }
    }

