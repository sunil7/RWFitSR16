package y2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.text.TextUtils;
import androidx.work.impl.utils.ForceStopRunnable$BroadcastReceiver;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.google.android.gms.internal.mlkit_vision_barcode.ic;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    public static final String f19948d = o2.m.i("ForceStopRunnable");
    public static final long e = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: a, reason: collision with root package name */
    public final Context f19949a;

    /* renamed from: b, reason: collision with root package name */
    public final p2.l f19950b;

    /* renamed from: c, reason: collision with root package name */
    public int f19951c = 0;

    public e(Context context, p2.l lVar) {
        this.f19949a = context.getApplicationContext();
        this.f19950b = lVar;
    }

    public static void c(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        int i3 = ic.a() ? 167772160 : AMapEngineUtils.HALF_MAX_P20_WIDTH;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) ForceStopRunnable$BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, i3);
        long currentTimeMillis = System.currentTimeMillis() + e;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, broadcast);
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 591
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.e.a():void");
    }

    public final boolean b() {
        o2.b bVar = this.f19950b.f17426b;
        bVar.getClass();
        boolean isEmpty = TextUtils.isEmpty(null);
        String str = f19948d;
        if (isEmpty) {
            o2.m.g().d(str, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean a3 = h.a(this.f19949a, bVar);
        o2.m.g().d(str, r5.a.d("Is default app process = ", a3), new Throwable[0]);
        return a3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = f19948d;
        p2.l lVar = this.f19950b;
        try {
            if (!b()) {
                return;
            }
            while (true) {
                p2.k.a(this.f19949a);
                o2.m.g().d(str, "Performing cleanup operations.", new Throwable[0]);
                try {
                    a();
                    return;
                } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e10) {
                    int i3 = this.f19951c + 1;
                    this.f19951c = i3;
                    if (i3 >= 3) {
                        o2.m.g().f(str, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e10);
                        IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e10);
                        lVar.f17426b.getClass();
                        throw illegalStateException;
                    }
                    o2.m.g().d(str, "Retrying after " + (i3 * 300), e10);
                    try {
                        Thread.sleep(this.f19951c * 300);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } finally {
            lVar.b();
        }
    }
}
