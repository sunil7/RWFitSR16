package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import android.os.PowerManager;
import androidx.lifecycle.LifecycleService;
import java.util.HashMap;
import java.util.WeakHashMap;
import o2.m;
import r2.g;
import y2.k;

/* loaded from: classes.dex */
public class SystemAlarmService extends LifecycleService {

    /* renamed from: d, reason: collision with root package name */
    public static final String f3016d = m.i("SystemAlarmService");

    /* renamed from: b, reason: collision with root package name */
    public g f3017b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3018c;

    public final void a() {
        this.f3018c = true;
        m.g().d(f3016d, "All commands completed in dispatcher", new Throwable[0]);
        String str = k.f19964a;
        HashMap hashMap = new HashMap();
        WeakHashMap weakHashMap = k.f19965b;
        synchronized (weakHashMap) {
            hashMap.putAll(weakHashMap);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                m.g().k(k.f19964a, String.format("WakeLock held for %s", hashMap.get(wakeLock)), new Throwable[0]);
            }
        }
        stopSelf();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onCreate() {
        super.onCreate();
        g gVar = new g(this);
        this.f3017b = gVar;
        if (gVar.f18049j != null) {
            m.g().f(g.f18040k, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            gVar.f18049j = this;
        }
        this.f3018c = false;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f3018c = true;
        this.f3017b.d();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i10) {
        super.onStartCommand(intent, i3, i10);
        if (this.f3018c) {
            m.g().h(f3016d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.f3017b.d();
            g gVar = new g(this);
            this.f3017b = gVar;
            if (gVar.f18049j != null) {
                m.g().f(g.f18040k, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
            } else {
                gVar.f18049j = this;
            }
            this.f3018c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f3017b.b(i10, intent);
        return 3;
    }
}
