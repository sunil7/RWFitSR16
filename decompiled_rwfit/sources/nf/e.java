package nf;

import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import ff.s;
import ia.h;
import ia.m;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Callable;
import qf.i;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: h, reason: collision with root package name */
    public static final ef.b f16609h = ef.b.a(e.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public final s f16610a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f16611b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public boolean f16612c = false;

    /* renamed from: d, reason: collision with root package name */
    public final Object f16613d = new Object();
    public CameraState e;

    /* renamed from: f, reason: collision with root package name */
    public CameraState f16614f;

    /* renamed from: g, reason: collision with root package name */
    public int f16615g;

    public e(s sVar) {
        this.f16610a = sVar;
        CameraState cameraState = CameraState.OFF;
        this.e = cameraState;
        this.f16614f = cameraState;
        this.f16615g = 0;
    }

    public static void a(e eVar, b bVar) {
        if (!eVar.f16612c) {
            throw new IllegalStateException("mJobRunning was not true after completing job=" + bVar.f16596a);
        }
        eVar.f16612c = false;
        eVar.f16611b.remove(bVar);
        eVar.f16610a.f13671a.f13645a.f17956c.postDelayed(new androidx.activity.e(eVar, 22), 0L);
    }

    public final m b(long j4, String str, Callable callable, boolean z5) {
        f16609h.b(1, str.toUpperCase(), "- Scheduling.");
        b bVar = new b(System.currentTimeMillis() + j4, str, callable, z5);
        synchronized (this.f16613d) {
            this.f16611b.addLast(bVar);
            i iVar = this.f16610a.f13671a.f13645a;
            iVar.f17956c.postDelayed(new androidx.activity.e(this, 22), j4);
        }
        return bVar.f16597b.f14382a;
    }

    public final m c(CameraState cameraState, CameraState cameraState2, boolean z5, Callable callable) {
        String str;
        int i3 = this.f16615g + 1;
        this.f16615g = i3;
        this.f16614f = cameraState2;
        boolean isAtLeast = cameraState2.isAtLeast(cameraState);
        boolean z6 = !isAtLeast;
        if (isAtLeast) {
            str = cameraState.name() + " >> " + cameraState2.name();
        } else {
            str = cameraState.name() + " << " + cameraState2.name();
        }
        String str2 = str;
        m b3 = b(0L, str2, new c(this, cameraState, str2, cameraState2, callable, z6), z5);
        d6.a aVar = new d6.a(this, i3);
        b3.getClass();
        b3.f14399b.f(new ia.i(h.f14383a, aVar));
        b3.k();
        return b3;
    }

    public final void d(String str, CameraState cameraState, Runnable runnable) {
        b(0L, str, new a(new d(this, cameraState, runnable, 0), 0), true);
    }

    public final void e(int i3, String str) {
        synchronized (this.f16613d) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator it = this.f16611b.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (bVar.f16596a.equals(str)) {
                        arrayList.add(bVar);
                    }
                }
                f16609h.b(0, "trim: name=", str, "scheduled=", Integer.valueOf(arrayList.size()), "allowed=", Integer.valueOf(i3));
                int max = Math.max(arrayList.size() - i3, 0);
                if (max > 0) {
                    Collections.reverse(arrayList);
                    Iterator it2 = arrayList.subList(0, max).iterator();
                    while (it2.hasNext()) {
                        this.f16611b.remove((b) it2.next());
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
