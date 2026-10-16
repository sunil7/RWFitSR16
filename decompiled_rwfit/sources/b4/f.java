package b4;

import android.app.ActivityManager;
import android.content.Context;
import androidx.appcompat.app.t;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3154a;

    /* renamed from: b, reason: collision with root package name */
    public final ActivityManager f3155b;

    /* renamed from: c, reason: collision with root package name */
    public final t f3156c;

    /* renamed from: d, reason: collision with root package name */
    public final float f3157d;

    public f(Context context) {
        this.f3157d = 1;
        this.f3154a = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Const.STR_PROCESS_TAG);
        this.f3155b = activityManager;
        this.f3156c = new t(context.getResources().getDisplayMetrics(), 7);
        if (activityManager.isLowRamDevice()) {
            this.f3157d = 0.0f;
        }
    }
}
