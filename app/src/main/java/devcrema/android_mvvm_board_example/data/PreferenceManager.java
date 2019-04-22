package devcrema.android_mvvm_board_example.data;

import android.content.Context;
import android.content.SharedPreferences;

import org.apache.commons.lang3.StringUtils;

import devcrema.android_mvvm_board_example.BoardApplication;

public class PreferenceManager {

    private static PreferenceManager preferenceManager = null;

    private static final String PREFERENCE_NAME = "EXAMPLE_PREFERENCE";

    private SharedPreferences sharedPreferences;

    private enum Key {
        ACCESS_TOKEN
    }

    private PreferenceManager() {
        sharedPreferences = BoardApplication.getContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public static PreferenceManager getInstance(){
        if(preferenceManager == null){
            preferenceManager = new PreferenceManager();
        }
        return preferenceManager;
    }

    public void saveAccessToken(String accessToken){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Key.ACCESS_TOKEN.name(), accessToken);
        editor.apply();
    }

    /**
     * @return if AccessToken is Blank, return "" or return "bearer" + token
     */
    public String getOauthHeader(){
        if(StringUtils.isBlank(sharedPreferences.getString(Key.ACCESS_TOKEN.name(), ""))){
            return "";
        }
        return "Bearer " + sharedPreferences.getString(Key.ACCESS_TOKEN.name(), "");
    }

}
