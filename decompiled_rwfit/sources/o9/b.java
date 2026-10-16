package o9;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class b implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    public static final b e = new b();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f16844a = new AtomicBoolean();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f16845b = new AtomicBoolean();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f16846c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public boolean f16847d = false;

    public final void a(boolean z5) {
        synchronized (e) {
            try {
                ArrayList arrayList = this.f16846c;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    c5.b bVar = ((m) obj).f16868a.f16862m;
                    bVar.sendMessage(bVar.obtainMessage(1, Boolean.valueOf(z5)));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.f16845b;
        boolean compareAndSet = this.f16844a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (compareAndSet) {
            a(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.f16845b;
        boolean compareAndSet = this.f16844a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (compareAndSet) {
            a(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i3) {
        if (i3 == 20 && this.f16844a.compareAndSet(false, true)) {
            this.f16845b.set(true);
            a(true);
        }
    }
}
