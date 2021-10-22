package com.example.myapplication;

public class user {
        String login, password;
        public static String lastuser;
        public user(String log, String pass)
        {
            login = log;
            password = pass;
        }
        public String getLogin(){
            return login;
        }
        public String getPassword(){
            return password;
        }
    }
