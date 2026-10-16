package y0;

import android.app.Activity;
import android.app.SharedElementCallback;

/* loaded from: classes.dex */
public abstract class b {
    public static void a(Object obj) {
        ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
    }

    public static void b(Activity activity, String[] strArr, int i3) {
        activity.requestPermissions(strArr, i3);
    }

    public static boolean c(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
