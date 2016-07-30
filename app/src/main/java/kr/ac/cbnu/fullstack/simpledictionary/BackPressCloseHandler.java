package kr.ac.cbnu.fullstack.simpledictionary;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by JiyoungPark on 2016. 7. 30..
 */
public class BackPressCloseHandler {

    private long backKeyPressedTime = 0;
    private Toast toast;

    private Activity activity;

    public BackPressCloseHandler(Activity context) {
        this.activity = context;
    }


    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            showGuide();
            return;
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            activity.finish();
            toast.cancel();
        }
    }

    private void showGuide() {
        toast = Toast.makeText(activity, "\'뒤로\'버튼을 한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT);
        toast.show();
    }

}
