package devcrema.android_mvvm_board_example.util;

import android.util.Base64;

public class AuthUtil {

    private static final String CLIENT_ID = "";
    private static final String CLIENT_SECRET = "";

    private static final String OAUTH_CONTENT_TYPE = "application/x-www-form-urlencoded; charset=UTF-8";

    public static String createOauth2ClientAuthHeader(){
        String rawString = CLIENT_ID + ":" + CLIENT_SECRET;

        return "Basic " + Base64.encodeToString(rawString.getBytes(), Base64.NO_WRAP);
    }

    public static String getOauth2ContentType(){
        return OAUTH_CONTENT_TYPE;
    }

    public static String getOauth2GrantType(){
        return "password";
    }

}
