package y0;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.provider.Settings;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: c, reason: collision with root package name */
    public static String f19910c;

    /* renamed from: f, reason: collision with root package name */
    public static q f19912f;

    /* renamed from: a, reason: collision with root package name */
    public final NotificationManager f19913a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f19909b = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static HashSet f19911d = new HashSet();
    public static final Object e = new Object();

    public r(Context context) {
        this.f19913a = (NotificationManager) context.getSystemService("notification");
    }

    public static Set a(Context context) {
        HashSet hashSet;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f19909b) {
            if (string != null) {
                try {
                    if (!string.equals(f19910c)) {
                        String[] split = string.split(":", -1);
                        HashSet hashSet2 = new HashSet(split.length);
                        for (String str : split) {
                            ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                            if (unflattenFromString != null) {
                                hashSet2.add(unflattenFromString.getPackageName());
                            }
                        }
                        f19911d = hashSet2;
                        f19910c = string;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            hashSet = f19911d;
        }
        return hashSet;
    }
}
