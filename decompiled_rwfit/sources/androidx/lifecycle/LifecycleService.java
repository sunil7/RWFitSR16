package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes.dex */
public class LifecycleService extends Service implements s {

    /* renamed from: a, reason: collision with root package name */
    public final de.o f2332a = new de.o(this);

    @Override // androidx.lifecycle.s
    public final n getLifecycle() {
        return (u) this.f2332a.f12377b;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        this.f2332a.J(Lifecycle$Event.ON_START);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f2332a.J(Lifecycle$Event.ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_STOP;
        de.o oVar = this.f2332a;
        oVar.J(lifecycle$Event);
        oVar.J(Lifecycle$Event.ON_DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i3) {
        this.f2332a.J(Lifecycle$Event.ON_START);
        super.onStart(intent, i3);
    }
}
