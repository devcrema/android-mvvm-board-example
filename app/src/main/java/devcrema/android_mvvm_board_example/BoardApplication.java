package devcrema.android_mvvm_board_example;

import android.app.Application;
import android.content.Context;

public class BoardApplication extends Application {
    private static BoardApplication boardApplication;

    public enum ProductConfig {
        LOCAL,
        REMOTE
    }

    @Override
    public void onCreate() {
        super.onCreate();

        boardApplication = this;
    }

    public static Context getContext() {
        return boardApplication;
    }

}
