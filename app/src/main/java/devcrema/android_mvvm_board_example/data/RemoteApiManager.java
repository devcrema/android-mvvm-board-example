package devcrema.android_mvvm_board_example.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import devcrema.android_mvvm_board_example.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteApiManager {
    private static Retrofit retrofit = null;
    private static RemoteApiService remoteApiService = null;

    public static RemoteApiService getRemoteApiService(){
        if(retrofit == null){
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.URL_API_SERVER)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        if(remoteApiService == null){
            remoteApiService = retrofit.create(RemoteApiService.class);
        }

        return remoteApiService;
    }
}
