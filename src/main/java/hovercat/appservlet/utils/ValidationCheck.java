package hovercat.appservlet.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationCheck {

    public static final Pattern MAIL
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean mailValidate(String emailStr) {
        Matcher matcher = MAIL.matcher(emailStr);
        return matcher.find();
    }

    public static final Pattern PASSWORD
            = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");

    public static boolean passwordValidate(String passStr) {
        Matcher matcher = PASSWORD.matcher(passStr);
        return matcher.find();
    }

    public static final Pattern LOGIN
            = Pattern.compile("([a-zA-Z0-9]{3,10})+"); //TODO

    public static boolean loginValidate(String loginStr) {
        Matcher matcher = LOGIN.matcher(loginStr);
        return matcher.find();
    }

    public static final Pattern NAME
            = Pattern.compile("([a-zA-Z]{3,10})+"); //TODO

    public static boolean nameValidate(String nameStr) {
        Matcher matcher = NAME.matcher(nameStr);
        return matcher.find();
    }
}
