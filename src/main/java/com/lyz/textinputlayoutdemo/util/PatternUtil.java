package com.lyz.textinputlayoutdemo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author： bwl on 2016-05-31.
 * email: bxl049@163.com
 */
public class PatternUtil {

    public static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";


    /**
     * 验证密码
     * @param pwd
     * @return
     */
    public static boolean validatePassword(String pwd) {
        if (null == pwd) {
            return false;
        }
        return pwd.length() > 5;
    }

    /**
     * 验证用户邮箱
     * @param email
     * @return
     */
    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
