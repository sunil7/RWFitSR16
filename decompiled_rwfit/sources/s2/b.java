package s2;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.impl.background.systemjob.SystemJobService;
import o2.m;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final String f18157b = m.i("SystemJobInfoConverter");

    /* renamed from: a, reason: collision with root package name */
    public final ComponentName f18158a;

    public b(Context context) {
        this.f18158a = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }
}
