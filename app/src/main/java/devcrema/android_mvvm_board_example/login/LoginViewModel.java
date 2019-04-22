package devcrema.android_mvvm_board_example.login;

import android.app.Activity;
import android.widget.Toast;

import devcrema.android_mvvm_board_example.BaseViewModel;
import devcrema.android_mvvm_board_example.BoardApplication;
import devcrema.android_mvvm_board_example.data.user.UserDataSource;
import devcrema.android_mvvm_board_example.data.user.UserRepository;
import lombok.Setter;

public class LoginViewModel extends BaseViewModel {

    @Setter
    private LoginNavigator loginNavigator;

    public LoginViewModel(Activity activity, String title) {
        super(activity, title);
    }

    public void loginClicked(String email, String password){
        UserRepository.getInstance().login(email, password, new UserDataSource.LoginCallback() {
            @Override
            public void onSuccess() {
                loginNavigator.openBoardList();
            }

            @Override
            public void onLoginFailed() {
                Toast.makeText(BoardApplication.getContext(), "로그인에 실패하였습니다. 아이디와 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailed(String reason) {
                Toast.makeText(BoardApplication.getContext(), "로그인에 실패하였습니다. 사유:"+reason, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
