package com.epam.rd.autotasks.validations;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    static List<String> emails = new ArrayList<>();

    public static boolean validateEpamEmail(String email) {
        if(email == null)
            return false;
        Pattern pattern = Pattern.compile("^[a-z]+_[a-z]+[0-9]*@epam.com$"
                , Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if(matcher.find()) {
            return true;
        } else {
            return false;
        }
    }
}





