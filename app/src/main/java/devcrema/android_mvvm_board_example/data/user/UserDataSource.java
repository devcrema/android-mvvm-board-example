package devcrema.android_mvvm_board_example.data.user;

public interface UserDataSource {

    interface LoginCallback {
        void onSuccess();
        void onLoginFailed();
        void onFailed(String reason);
    }

    void login(String username, String password, LoginCallback callback);

}
