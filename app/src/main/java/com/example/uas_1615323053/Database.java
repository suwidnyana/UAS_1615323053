package com.example.uas_1615323053;

import android.util.Log;
import java.util.ArrayList;

public class Database {

    ArrayList<User> users;
    private static Database instance = null;

    private static User authenticated = null;
    private static User checkForPassword = null;

    private Database() {
        users = new ArrayList<User>();
    }

    public static Database getInstance() {
        if(instance == null) {
            instance = new Database();
        }

        return instance;
    }

    public void add(String nama, String tgl, String alamat, String email, String username, String password) {
        users.add(new User(nama, tgl, alamat, email, username, password));
    }

    public boolean checkUsername(String username) {
        for(User user: users) {
            if(user.getUsername().compareTo(username) == 0) {
                checkForPassword = user;
                return true;
            }
        }

        return false;
    }

    public boolean checkPassword(String password) {
        if(checkForPassword != null) {
            if(checkForPassword.getPassword().compareTo(password) == 0) {
                authenticated = checkForPassword;
                checkForPassword = null;
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    public boolean isAuthenticated() {
        if(authenticated != null) {
            return true;
        }

        return false;
    }


}
