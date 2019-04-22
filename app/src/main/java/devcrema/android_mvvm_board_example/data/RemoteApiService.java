package devcrema.android_mvvm_board_example.data;

import devcrema.android_mvvm_board_example.data.user.remote.TokenResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RemoteApiService {
    //get user oauth2 access token
    @FormUrlEncoded
    @POST("oauth/token")
    Call<TokenResponse> getUserAccessToken(@Header("Authorization") String encryptedClient,
                                           @Header("Content-Type") String contentType,
                                           @Field("grant_type") String grantType,
                                           @Field("username") String username,
                                           @Field("password") String password
    );
}
