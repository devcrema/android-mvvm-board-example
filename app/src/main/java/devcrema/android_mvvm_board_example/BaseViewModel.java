package devcrema.android_mvvm_board_example;

import android.app.Activity;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;

import org.apache.commons.lang3.StringUtils;

public class BaseViewModel extends BaseObservable {

    public final ObservableField<String> title = new ObservableField<>();

    private final Activity activity;

    public BaseViewModel(Activity activity, String title){
        this.activity = activity;
        if(StringUtils.isBlank(title)){
            this.title.set("Board");
        } else {
            this.title.set(title);
        }
    }
}
