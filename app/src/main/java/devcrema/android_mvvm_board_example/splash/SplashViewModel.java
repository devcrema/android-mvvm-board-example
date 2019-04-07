package devcrema.android_mvvm_board_example.splash;

import androidx.annotation.Nullable;
import devcrema.android_mvvm_board_example.data.user.UserRepository;
import lombok.Setter;

public class SplashViewModel {

    @Nullable
    @Setter
    private SplashNavigator splashNavigator;

    public void start() {
        if(splashNavigator == null) return;

        if(UserRepository.getInstance().checkLogin()){
            splashNavigator.openMain();
        } else {
            splashNavigator.openLogin();
        }
    }

}
