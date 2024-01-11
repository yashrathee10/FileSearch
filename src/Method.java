import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Method {
    static int count=0;
    public static boolean match(String input, String str){
        Pattern pattern = Pattern.compile("\"message\":\".*?"+input+".*?\"");
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
                count++;
                return true;
//            }

        }
        return false;
    }
}