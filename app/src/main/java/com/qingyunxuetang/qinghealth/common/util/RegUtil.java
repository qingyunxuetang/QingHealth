package com.qingyunxuetang.qinghealth.common.util;

public class RegUtil {
    public static boolean isPassword(String password){
        boolean numberAndLetter = password.matches("\\S*[A-Za-z]\\S*[0-9]\\S*|\\S*[0-9]\\S*[A-Za-z]\\S*");
        boolean size6_16 = password.matches("^.{6,16}");
        return numberAndLetter && size6_16;
    }
}
