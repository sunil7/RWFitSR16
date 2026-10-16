package androidx.camera.lifecycle;

import androidx.activity.ComponentActivity;
import androidx.camera.core.internal.CameraUseCaseAdapter$CameraException;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.s;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import f8.f;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.EmptyList;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1552a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f1553b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f1554c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f1555d = new ArrayDeque();
    public f e;

    public final void a(LifecycleCamera lifecycleCamera, EmptyList emptyList, Collection collection, f fVar) {
        ComponentActivity componentActivity;
        synchronized (this.f1552a) {
            try {
                pd.b(!collection.isEmpty());
                this.e = fVar;
                synchronized (lifecycleCamera.f1544a) {
                    componentActivity = lifecycleCamera.f1545b;
                }
                LifecycleCameraRepository$LifecycleCameraRepositoryObserver c9 = c(componentActivity);
                if (c9 == null) {
                    return;
                }
                Set set = (Set) this.f1554c.get(c9);
                f fVar2 = this.e;
                if (fVar2 == null || fVar2.f13516b != 2) {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        LifecycleCamera lifecycleCamera2 = (LifecycleCamera) this.f1553b.get((a) it.next());
                        lifecycleCamera2.getClass();
                        if (!lifecycleCamera2.equals(lifecycleCamera) && !lifecycleCamera2.i().isEmpty()) {
                            throw new IllegalArgumentException("Multiple LifecycleCameras with use cases are registered to the same LifecycleOwner.");
                        }
                    }
                }
                try {
                    synchronized (lifecycleCamera.f1546c.f19847k) {
                    }
                    y.e eVar = lifecycleCamera.f1546c;
                    synchronized (eVar.f19847k) {
                        eVar.f19845i = emptyList;
                    }
                    synchronized (lifecycleCamera.f1544a) {
                        lifecycleCamera.f1546c.c(collection);
                    }
                    if (componentActivity.f333d.f2390b.isAtLeast(Lifecycle$State.STARTED)) {
                        f(componentActivity);
                    }
                } catch (CameraUseCaseAdapter$CameraException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final LifecycleCamera b(ComponentActivity componentActivity, y.e eVar) {
        synchronized (this.f1552a) {
            try {
                pd.a("LifecycleCamera already exists for the given LifecycleOwner and set of cameras", this.f1553b.get(new a(componentActivity, eVar.e)) == null);
                LifecycleCamera lifecycleCamera = new LifecycleCamera(componentActivity, eVar);
                if (((ArrayList) eVar.v()).isEmpty()) {
                    lifecycleCamera.j();
                }
                if (componentActivity.f333d.f2390b == Lifecycle$State.DESTROYED) {
                    return lifecycleCamera;
                }
                e(lifecycleCamera);
                return lifecycleCamera;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final LifecycleCameraRepository$LifecycleCameraRepositoryObserver c(s sVar) {
        synchronized (this.f1552a) {
            try {
                for (LifecycleCameraRepository$LifecycleCameraRepositoryObserver lifecycleCameraRepository$LifecycleCameraRepositoryObserver : this.f1554c.keySet()) {
                    if (sVar.equals(lifecycleCameraRepository$LifecycleCameraRepositoryObserver.f1549b)) {
                        return lifecycleCameraRepository$LifecycleCameraRepositoryObserver;
                    }
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean d(s sVar) {
        synchronized (this.f1552a) {
            try {
                LifecycleCameraRepository$LifecycleCameraRepositoryObserver c9 = c(sVar);
                if (c9 == null) {
                    return false;
                }
                Iterator it = ((Set) this.f1554c.get(c9)).iterator();
                while (it.hasNext()) {
                    LifecycleCamera lifecycleCamera = (LifecycleCamera) this.f1553b.get((a) it.next());
                    lifecycleCamera.getClass();
                    if (!lifecycleCamera.i().isEmpty()) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void e(LifecycleCamera lifecycleCamera) {
        ComponentActivity componentActivity;
        synchronized (this.f1552a) {
            try {
                synchronized (lifecycleCamera.f1544a) {
                    componentActivity = lifecycleCamera.f1545b;
                }
                y.e eVar = lifecycleCamera.f1546c;
                a aVar = new a(componentActivity, y.e.s(eVar.f19853q, eVar.r));
                LifecycleCameraRepository$LifecycleCameraRepositoryObserver c9 = c(componentActivity);
                Set hashSet = c9 != null ? (Set) this.f1554c.get(c9) : new HashSet();
                hashSet.add(aVar);
                this.f1553b.put(aVar, lifecycleCamera);
                if (c9 == null) {
                    LifecycleCameraRepository$LifecycleCameraRepositoryObserver lifecycleCameraRepository$LifecycleCameraRepositoryObserver = new LifecycleCameraRepository$LifecycleCameraRepositoryObserver(componentActivity, this);
                    this.f1554c.put(lifecycleCameraRepository$LifecycleCameraRepositoryObserver, hashSet);
                    componentActivity.f333d.a(lifecycleCameraRepository$LifecycleCameraRepositoryObserver);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void f(s sVar) {
        synchronized (this.f1552a) {
            try {
                if (d(sVar)) {
                    if (this.f1555d.isEmpty()) {
                        this.f1555d.push(sVar);
                    } else {
                        f fVar = this.e;
                        if (fVar == null || fVar.f13516b != 2) {
                            s sVar2 = (s) this.f1555d.peek();
                            if (!sVar.equals(sVar2)) {
                                h(sVar2);
                                this.f1555d.remove(sVar);
                                this.f1555d.push(sVar);
                            }
                        }
                    }
                    j(sVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void g(s sVar) {
        synchronized (this.f1552a) {
            try {
                this.f1555d.remove(sVar);
                h(sVar);
                if (!this.f1555d.isEmpty()) {
                    j((s) this.f1555d.peek());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void h(s sVar) {
        synchronized (this.f1552a) {
            try {
                LifecycleCameraRepository$LifecycleCameraRepositoryObserver c9 = c(sVar);
                if (c9 == null) {
                    return;
                }
                Iterator it = ((Set) this.f1554c.get(c9)).iterator();
                while (it.hasNext()) {
                    LifecycleCamera lifecycleCamera = (LifecycleCamera) this.f1553b.get((a) it.next());
                    lifecycleCamera.getClass();
                    lifecycleCamera.j();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void i() {
        ComponentActivity componentActivity;
        synchronized (this.f1552a) {
            Iterator it = this.f1553b.keySet().iterator();
            while (it.hasNext()) {
                LifecycleCamera lifecycleCamera = (LifecycleCamera) this.f1553b.get((a) it.next());
                synchronized (lifecycleCamera.f1544a) {
                    y.e eVar = lifecycleCamera.f1546c;
                    eVar.y((ArrayList) eVar.v());
                }
                synchronized (lifecycleCamera.f1544a) {
                    componentActivity = lifecycleCamera.f1545b;
                }
                g(componentActivity);
            }
        }
    }

    public final void j(s sVar) {
        synchronized (this.f1552a) {
            try {
                Iterator it = ((Set) this.f1554c.get(c(sVar))).iterator();
                while (it.hasNext()) {
                    LifecycleCamera lifecycleCamera = (LifecycleCamera) this.f1553b.get((a) it.next());
                    lifecycleCamera.getClass();
                    if (!lifecycleCamera.i().isEmpty()) {
                        lifecycleCamera.k();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
