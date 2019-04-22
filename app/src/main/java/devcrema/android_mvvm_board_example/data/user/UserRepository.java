package devcrema.android_mvvm_board_example.data.user;

import org.apache.commons.lang3.StringUtils;

import devcrema.android_mvvm_board_example.BaseViewModel;
import devcrema.android_mvvm_board_example.data.PreferenceManager;
import devcrema.android_mvvm_board_example.data.user.remote.UserRemoteDataSource;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRepository implements UserDataSource {

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

    @Override
    public void login(String username, String password, LoginCallback callback) {
        UserRemoteDataSource.getInstance().login(callback, username, password);
    }

}
