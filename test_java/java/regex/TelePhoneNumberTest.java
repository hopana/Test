package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelePhoneNumberTest {
    public static void main(String[] args) {
        String s = "0211234567";
        Pattern p = Pattern.compile("^[0-9]{3,4}[0-9]{7,8}$");
        Matcher m = p.matcher(s);
        System.out.println(m.matches());
    }
}
