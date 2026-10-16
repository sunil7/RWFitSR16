package androidx.camera.lifecycle;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.d0;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
class LifecycleCameraRepository$LifecycleCameraRepositoryObserver implements r {

    /* renamed from: a, reason: collision with root package name */
    public final b f1548a;

    /* renamed from: b, reason: collision with root package name */
    public final s f1549b;

    public LifecycleCameraRepository$LifecycleCameraRepositoryObserver(s sVar, b bVar) {
        this.f1549b = sVar;
        this.f1548a = bVar;
    }

    @d0(Lifecycle$Event.ON_DESTROY)
    public void onDestroy(s sVar) {
        b bVar = this.f1548a;
        synchronized (bVar.f1552a) {
            try {
                LifecycleCameraRepository$LifecycleCameraRepositoryObserver c9 = bVar.c(sVar);
                if (c9 == null) {
                    return;
                }
                bVar.g(sVar);
                Iterator it = ((Set) bVar.f1554c.get(c9)).iterator();
                while (it.hasNext()) {
                    bVar.f1553b.remove((a) it.next());
                }
                bVar.f1554c.remove(c9);
                c9.f1549b.getLifecycle().b(c9);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @d0(Lifecycle$Event.ON_START)
    public void onStart(s sVar) {
        this.f1548a.f(sVar);
    }

    @d0(Lifecycle$Event.ON_STOP)
    public void onStop(s sVar) {
        this.f1548a.g(sVar);
    }
}
