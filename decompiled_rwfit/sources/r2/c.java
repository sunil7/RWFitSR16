package r2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import o2.m;

/* loaded from: classes.dex */
public abstract class c extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f18024a = m.i("ConstraintProxy");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        m.g().d(f18024a, String.format("onReceive : %s", intent), new Throwable[0]);
        String str = b.f18020d;
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_CONSTRAINTS_CHANGED");
        context.startService(intent2);
    }
}
