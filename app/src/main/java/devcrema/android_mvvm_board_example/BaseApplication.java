package devcrema.android_mvvm_board_example;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {
    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        baseApplication = this;
    }

    public static Context getContext(){
        return baseApplication;
    }

}
