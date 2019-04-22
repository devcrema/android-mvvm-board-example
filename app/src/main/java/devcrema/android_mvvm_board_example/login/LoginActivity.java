package devcrema.android_mvvm_board_example.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import devcrema.android_mvvm_board_example.R;
import devcrema.android_mvvm_board_example.databinding.LoginActivityBinding;

public class LoginActivity extends AppCompatActivity implements LoginNavigator {

    private LoginViewModel loginViewModel;
    private LoginActivityBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.login_activity);
        loginViewModel = new LoginViewModel(this, "Login");
        loginViewModel.setLoginNavigator(this);
        binding.setViewModel(loginViewModel);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void openBoardList() {
        //TODO 게시판 리스트로 이동
    }
}
