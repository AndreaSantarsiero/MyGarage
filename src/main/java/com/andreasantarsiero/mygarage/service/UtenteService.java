package com.andreasantarsiero.mygarage.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class UtenteService{
    public static boolean isValidEmail(String email){
        String emailRegEx = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zAZ]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegEx);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
