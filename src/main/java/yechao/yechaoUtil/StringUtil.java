package yechao.yechaoUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static boolean isNumberic (String str){
        Pattern pattern=Pattern.compile("[0-9]*");
        Matcher matcher=pattern.matcher(str);
        if(!matcher.matches()){
            return false;
        }
        return true;

    }
}
