package r2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import o2.m;
import p2.l;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f18019a = m.i("Alarms");

    public static void a(Context context, int i3, String str) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i3, b.b(context, str), 603979776);
        if (service == null || alarmManager == null) {
            return;
        }
        m.g().d(f18019a, "Cancelling existing alarm with (workSpecId, systemId) (" + str + ", " + i3 + ")", new Throwable[0]);
        alarmManager.cancel(service);
    }

    public static void b(Context context, l lVar, String str, long j4) {
        int intValue;
        WorkDatabase workDatabase = lVar.f17427c;
        n.l k10 = workDatabase.k();
        x2.d j10 = k10.j(str);
        if (j10 != null) {
            a(context, j10.f19742b, str);
            int i3 = j10.f19742b;
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            PendingIntent service = PendingIntent.getService(context, i3, b.b(context, str), 201326592);
            if (alarmManager != null) {
                alarmManager.setExact(0, j4, service);
                return;
            }
            return;
        }
        synchronized (y2.f.class) {
            workDatabase.c();
            try {
                Long e = workDatabase.j().e("next_alarm_manager_id");
                intValue = e != null ? e.intValue() : 0;
                workDatabase.j().h(new x2.c("next_alarm_manager_id", intValue == Integer.MAX_VALUE ? 0 : intValue + 1));
                workDatabase.h();
                workDatabase.f();
            } catch (Throwable th2) {
                workDatabase.f();
                throw th2;
            }
        }
        k10.l(new x2.d(str, intValue));
        AlarmManager alarmManager2 = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service2 = PendingIntent.getService(context, intValue, b.b(context, str), 201326592);
        if (alarmManager2 != null) {
            alarmManager2.setExact(0, j4, service2);
        }
    }
}
