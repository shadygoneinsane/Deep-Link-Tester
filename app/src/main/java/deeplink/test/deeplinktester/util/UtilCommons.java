package deeplink.test.deeplinktester.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

public class UtilCommons {

    public static boolean StartDeepLink(String deepLink, Context mContext) {
        if (isProperUri(deepLink)) {
            Intent intent = createDeepLinkIntent(deepLink);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ResolveInfo resolveInfo = getResolveInfo(mContext, intent);
            if (resolveInfo != null) {
                mContext.startActivity(intent);
                return true;
            } else {
                return false;
            }
        } else
            return false;
    }

    private static Intent createDeepLinkIntent(String deepLinkURI) {
        return new Intent(Intent.ACTION_VIEW, Uri.parse(deepLinkURI));
    }

    private static boolean isProperUri(String uriText) {
        Uri uri = Uri.parse(uriText);
        if (uri.getScheme() == null || uri.getScheme().length() == 0) {
            return false;
        } else if (uriText.contains("\n") || uriText.contains(" ")) {
            return false;
        } else {
            return true;
        }
    }

    private static ResolveInfo getResolveInfo(Context mContext, Intent intent) {
        return mContext.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
    }
}
