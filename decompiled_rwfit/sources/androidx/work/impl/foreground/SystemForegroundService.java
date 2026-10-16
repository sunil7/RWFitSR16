package androidx.work.impl.foreground;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleService;
import java.util.UUID;
import o2.m;
import p2.l;
import w2.a;

/* loaded from: classes.dex */
public class SystemForegroundService extends LifecycleService {

    /* renamed from: f, reason: collision with root package name */
    public static final String f3023f = m.i("SystemFgService");

    /* renamed from: b, reason: collision with root package name */
    public Handler f3024b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3025c;

    /* renamed from: d, reason: collision with root package name */
    public a f3026d;
    public NotificationManager e;

    public final void a() {
        this.f3024b = new Handler(Looper.getMainLooper());
        this.e = (NotificationManager) getApplicationContext().getSystemService("notification");
        a aVar = new a(getApplicationContext());
        this.f3026d = aVar;
        if (aVar.f19475i == null) {
            aVar.f19475i = this;
        } else {
            m.g().f(a.f19467j, "A callback already exists.", new Throwable[0]);
        }
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onCreate() {
        super.onCreate();
        a();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f3026d.g();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i10) {
        super.onStartCommand(intent, i3, i10);
        boolean z5 = this.f3025c;
        String str = f3023f;
        if (z5) {
            m.g().h(str, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.f3026d.g();
            a();
            this.f3025c = false;
        }
        if (intent == null) {
            return 3;
        }
        a aVar = this.f3026d;
        aVar.getClass();
        String action = intent.getAction();
        boolean equals = "ACTION_START_FOREGROUND".equals(action);
        String str2 = a.f19467j;
        l lVar = aVar.f19468a;
        if (equals) {
            m.g().h(str2, String.format("Started foreground service %s", intent), new Throwable[0]);
            aVar.f19469b.p(new e8.a(aVar, lVar.f17427c, intent.getStringExtra("KEY_WORKSPEC_ID"), 10, false));
            aVar.f(intent);
            return 3;
        }
        if ("ACTION_NOTIFY".equals(action)) {
            aVar.f(intent);
            return 3;
        }
        if ("ACTION_CANCEL_WORK".equals(action)) {
            m.g().h(str2, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
            String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
            if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
                return 3;
            }
            UUID fromString = UUID.fromString(stringExtra);
            lVar.getClass();
            lVar.f17428d.p(new y2.a(lVar, fromString));
            return 3;
        }
        if (!"ACTION_STOP_FOREGROUND".equals(action)) {
            return 3;
        }
        m.g().h(str2, "Stopping foreground service", new Throwable[0]);
        SystemForegroundService systemForegroundService = aVar.f19475i;
        if (systemForegroundService == null) {
            return 3;
        }
        systemForegroundService.f3025c = true;
        m.g().d(str, "All commands completed.", new Throwable[0]);
        systemForegroundService.stopForeground(true);
        systemForegroundService.stopSelf();
        return 3;
    }
}
