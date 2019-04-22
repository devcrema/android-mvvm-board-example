package devcrema.android_mvvm_board_example.splash;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devcrema.android_mvvm_board_example.login.LoginActivity;

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
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void openMain() {
        //TODO 메인화면 이동 (게시판 리스트)
    }
}
