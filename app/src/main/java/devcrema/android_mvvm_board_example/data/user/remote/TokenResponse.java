package devcrema.android_mvvm_board_example.data.user.remote;

import lombok.Data;

@Data
public class TokenResponse {
    String access_token;
    String token_type;
    String scope;
}
