package devcrema.android_mvvm_board_example.data.user.remote;

import androidx.annotation.NonNull;

import devcrema.android_mvvm_board_example.data.PreferenceManager;
import devcrema.android_mvvm_board_example.data.RemoteApiManager;
import devcrema.android_mvvm_board_example.data.user.UserDataSource;
import devcrema.android_mvvm_board_example.util.AuthUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRemoteDataSource implements UserDataSource {
    private static UserRemoteDataSource userRemoteDataSource = null;

    public static UserRemoteDataSource getInstance(){
        if(userRemoteDataSource == null){
            userRemoteDataSource = new UserRemoteDataSource();
        }
        return userRemoteDataSource;
    }


    @Override
    public void login(final LoginCallback callback, String username, String password) {
        RemoteApiManager.getRemoteApiService().getUserAccessToken(
                AuthUtil.createOauth2ClientAuthHeader(),
                AuthUtil.getOauth2ContentType(),
                AuthUtil.getOauth2GrantType(),
                username,
                password).enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(@NonNull Call<TokenResponse> call, @NonNull Response<TokenResponse> response) {
                if (response.code() == 400) {
                    callback.onLoginFailed();
                } else if (response.code() == 200 && response.body() != null) {
                    PreferenceManager.getInstance().saveAccessToken(response.body().getAccess_token());
                    callback.onSuccess();
                } else {
                    callback.onFailed(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<TokenResponse> call, @NonNull Throwable t) {
                callback.onFailed(t.getMessage());
            }
        });
    }
}
