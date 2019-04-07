package devcrema.android_mvvm_board_example.splash;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity implements SplashNavigator {

    private SplashViewModel splashViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashViewModel = new SplashViewModel();
        splashViewModel.setSplashNavigator(this);
        splashViewModel.start();
    }

    @Override
    public void openLogin() {
        //TODO 로그인 화면 이동
    }

    @Override
    public void openMain() {
        //TODO 메인화면 이동 (게시판 리스트)
    }
}
