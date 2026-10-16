package y0;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

/* loaded from: classes.dex */
public abstract class a {
    public static void a(Activity activity) {
        activity.finishAffinity();
    }

    public static void b(Activity activity, Intent intent, int i3, Bundle bundle) {
        activity.startActivityForResult(intent, i3, bundle);
    }

    public static void c(Activity activity, IntentSender intentSender, int i3, Intent intent, int i10, int i11, int i12, Bundle bundle) throws IntentSender.SendIntentException {
        activity.startIntentSenderForResult(intentSender, i3, intent, i10, i11, i12, bundle);
    }
}
