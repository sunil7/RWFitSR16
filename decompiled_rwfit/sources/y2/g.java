package y2;

import android.content.ComponentName;
import android.content.Context;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f19954a = o2.m.i("PackageManagerHelper");

    public static void a(Context context, Class cls, boolean z5) {
        String str = f19954a;
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z5 ? 1 : 2, 1);
            o2.m.g().d(str, cls.getName() + " " + (z5 ? "enabled" : "disabled"), new Throwable[0]);
        } catch (Exception e) {
            o2.m.g().d(str, r5.a.c(cls.getName(), " could not be ", z5 ? "enabled" : "disabled"), e);
        }
    }
}
