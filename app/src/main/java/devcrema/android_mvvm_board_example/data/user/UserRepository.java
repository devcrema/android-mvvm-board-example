package devcrema.android_mvvm_board_example.data.user;

import org.apache.commons.lang3.StringUtils;

import devcrema.android_mvvm_board_example.data.PreferenceManager;

public class UserRepository {

    private static UserRepository userRepository = null;

    public static UserRepository getInstance(){
        if(userRepository == null){
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    public boolean checkLogin(){
        return !StringUtils.isBlank(PreferenceManager.getInstance().getOauthHeader());
    }
}
