package deeplink.test.deeplinktester.util;


import android.support.design.widget.Snackbar;
import android.view.View;

public class UIUtils {

    public static void Snackbar(View view, String msg, String action) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
