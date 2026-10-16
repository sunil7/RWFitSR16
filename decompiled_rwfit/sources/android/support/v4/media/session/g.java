package android.support.v4.media.session;

import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class g {
    static {
        Build.VERSION.CODENAME.equals("S");
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(g.class.getClassLoader());
        }
    }

    public static Bundle b(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        a(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }
}
