package r2;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import o2.m;
import x2.h;
import y2.k;
import y2.q;

/* loaded from: classes.dex */
public final class e implements t2.b, p2.a, q {

    /* renamed from: j, reason: collision with root package name */
    public static final String f18029j = m.i("DelayMetCommandHandler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f18030a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18031b;

    /* renamed from: c, reason: collision with root package name */
    public final String f18032c;

    /* renamed from: d, reason: collision with root package name */
    public final g f18033d;
    public final t2.c e;

    /* renamed from: h, reason: collision with root package name */
    public PowerManager.WakeLock f18036h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f18037i = false;

    /* renamed from: g, reason: collision with root package name */
    public int f18035g = 0;

    /* renamed from: f, reason: collision with root package name */
    public final Object f18034f = new Object();

    public e(Context context, int i3, String str, g gVar) {
        this.f18030a = context;
        this.f18031b = i3;
        this.f18033d = gVar;
        this.f18032c = str;
        this.e = new t2.c(context, gVar.f18042b, this);
    }

    @Override // p2.a
    public final void a(String str, boolean z5) {
        m.g().d(f18029j, "onExecuted " + str + ", " + z5, new Throwable[0]);
        b();
        int i3 = this.f18031b;
        g gVar = this.f18033d;
        Context context = this.f18030a;
        if (z5) {
            gVar.e(new androidx.activity.f(gVar, b.c(context, this.f18032c), i3, 5));
        }
        if (this.f18037i) {
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_CONSTRAINTS_CHANGED");
            gVar.e(new androidx.activity.f(gVar, intent, i3, 5));
        }
    }

    public final void b() {
        synchronized (this.f18034f) {
            try {
                this.e.c();
                this.f18033d.f18043c.b(this.f18032c);
                PowerManager.WakeLock wakeLock = this.f18036h;
                if (wakeLock != null && wakeLock.isHeld()) {
                    m.g().d(f18029j, "Releasing wakelock " + this.f18036h + " for WorkSpec " + this.f18032c, new Throwable[0]);
                    this.f18036h.release();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // t2.b
    public final void c(ArrayList arrayList) {
        f();
    }

    public final void d() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.f18032c;
        sb2.append(str);
        sb2.append(" (");
        this.f18036h = k.a(this.f18030a, r5.a.e(sb2, this.f18031b, ")"));
        m g10 = m.g();
        PowerManager.WakeLock wakeLock = this.f18036h;
        String str2 = f18029j;
        g10.d(str2, "Acquiring wakelock " + wakeLock + " for WorkSpec " + str, new Throwable[0]);
        this.f18036h.acquire();
        h h4 = this.f18033d.e.f17427c.n().h(str);
        if (h4 == null) {
            f();
            return;
        }
        boolean b3 = h4.b();
        this.f18037i = b3;
        if (b3) {
            this.e.b(Collections.singletonList(h4));
        } else {
            m.g().d(str2, l0.n("No constraints for ", str), new Throwable[0]);
            e(Collections.singletonList(str));
        }
    }

    @Override // t2.b
    public final void e(List list) {
        if (list.contains(this.f18032c)) {
            synchronized (this.f18034f) {
                try {
                    if (this.f18035g == 0) {
                        this.f18035g = 1;
                        m.g().d(f18029j, "onAllConstraintsMet for " + this.f18032c, new Throwable[0]);
                        if (this.f18033d.f18044d.g(this.f18032c, null)) {
                            this.f18033d.f18043c.a(this.f18032c, this);
                        } else {
                            b();
                        }
                    } else {
                        m.g().d(f18029j, "Already started work for " + this.f18032c, new Throwable[0]);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final void f() {
        synchronized (this.f18034f) {
            try {
                if (this.f18035g < 2) {
                    this.f18035g = 2;
                    m g10 = m.g();
                    String str = f18029j;
                    g10.d(str, "Stopping work for WorkSpec " + this.f18032c, new Throwable[0]);
                    Context context = this.f18030a;
                    String str2 = this.f18032c;
                    Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
                    intent.setAction("ACTION_STOP_WORK");
                    intent.putExtra("KEY_WORKSPEC_ID", str2);
                    g gVar = this.f18033d;
                    gVar.e(new androidx.activity.f(gVar, intent, this.f18031b, 5));
                    if (this.f18033d.f18044d.d(this.f18032c)) {
                        m.g().d(str, "WorkSpec " + this.f18032c + " needs to be rescheduled", new Throwable[0]);
                        Intent c9 = b.c(this.f18030a, this.f18032c);
                        g gVar2 = this.f18033d;
                        gVar2.e(new androidx.activity.f(gVar2, c9, this.f18031b, 5));
                    } else {
                        m.g().d(str, "Processor does not have WorkSpec " + this.f18032c + ". No need to reschedule ", new Throwable[0]);
                    }
                } else {
                    m.g().d(f18029j, "Already stopped work for " + this.f18032c, new Throwable[0]);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
