package t;

import android.util.Range;
import android.util.Size;
import android.view.Surface;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class f1 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f18319a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Size f18320b;

    /* renamed from: c, reason: collision with root package name */
    public final t f18321c;

    /* renamed from: d, reason: collision with root package name */
    public final androidx.camera.core.impl.v f18322d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final n0.i f18323f;

    /* renamed from: g, reason: collision with root package name */
    public final androidx.concurrent.futures.b f18324g;

    /* renamed from: h, reason: collision with root package name */
    public final n0.i f18325h;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.concurrent.futures.b f18326i;

    /* renamed from: j, reason: collision with root package name */
    public final androidx.concurrent.futures.b f18327j;

    /* renamed from: k, reason: collision with root package name */
    public final androidx.camera.core.impl.s0 f18328k;

    /* renamed from: l, reason: collision with root package name */
    public l f18329l;

    /* renamed from: m, reason: collision with root package name */
    public e1 f18330m;

    /* renamed from: n, reason: collision with root package name */
    public Executor f18331n;

    static {
        Range range = androidx.camera.core.impl.h.f1404f;
    }

    public f1(Size size, androidx.camera.core.impl.v vVar, boolean z5, t tVar, c0.i iVar) {
        this.f18320b = size;
        this.f18322d = vVar;
        this.e = z5;
        this.f18321c = tVar;
        final String str = "SurfaceRequest[size: " + size + ", id: " + hashCode() + "]";
        final AtomicReference atomicReference = new AtomicReference(null);
        final int i3 = 0;
        n0.i a3 = ve.a(new n0.g() { // from class: t.c1
            @Override // n0.g
            public final Object b(androidx.concurrent.futures.b bVar) {
                switch (i3) {
                    case 0:
                        atomicReference.set(bVar);
                        return r5.a.f(new StringBuilder(), str, "-cancellation");
                    case 1:
                        atomicReference.set(bVar);
                        return r5.a.f(new StringBuilder(), str, "-status");
                    default:
                        atomicReference.set(bVar);
                        return r5.a.f(new StringBuilder(), str, "-Surface");
                }
            }
        });
        androidx.concurrent.futures.b bVar = (androidx.concurrent.futures.b) atomicReference.get();
        bVar.getClass();
        this.f18327j = bVar;
        final AtomicReference atomicReference2 = new AtomicReference(null);
        final int i10 = 1;
        n0.i a10 = ve.a(new n0.g() { // from class: t.c1
            @Override // n0.g
            public final Object b(androidx.concurrent.futures.b bVar2) {
                switch (i10) {
                    case 0:
                        atomicReference2.set(bVar2);
                        return r5.a.f(new StringBuilder(), str, "-cancellation");
                    case 1:
                        atomicReference2.set(bVar2);
                        return r5.a.f(new StringBuilder(), str, "-status");
                    default:
                        atomicReference2.set(bVar2);
                        return r5.a.f(new StringBuilder(), str, "-Surface");
                }
            }
        });
        this.f18325h = a10;
        a10.a(new x.h(0, a10, new androidx.camera.core.d(0, bVar, a3)), a6.a());
        androidx.concurrent.futures.b bVar2 = (androidx.concurrent.futures.b) atomicReference2.get();
        bVar2.getClass();
        final AtomicReference atomicReference3 = new AtomicReference(null);
        final int i11 = 2;
        n0.i a11 = ve.a(new n0.g() { // from class: t.c1
            @Override // n0.g
            public final Object b(androidx.concurrent.futures.b bVar22) {
                switch (i11) {
                    case 0:
                        atomicReference3.set(bVar22);
                        return r5.a.f(new StringBuilder(), str, "-cancellation");
                    case 1:
                        atomicReference3.set(bVar22);
                        return r5.a.f(new StringBuilder(), str, "-status");
                    default:
                        atomicReference3.set(bVar22);
                        return r5.a.f(new StringBuilder(), str, "-Surface");
                }
            }
        });
        this.f18323f = a11;
        androidx.concurrent.futures.b bVar3 = (androidx.concurrent.futures.b) atomicReference3.get();
        bVar3.getClass();
        this.f18324g = bVar3;
        androidx.camera.core.impl.s0 s0Var = new androidx.camera.core.impl.s0(this, size);
        this.f18328k = s0Var;
        ob.a d5 = x.i.d(s0Var.e);
        a11.a(new x.h(0, a11, new androidx.camera.core.e(d5, bVar2, str)), a6.a());
        d5.a(new c0.c(this, 1), a6.a());
        w.a a12 = a6.a();
        AtomicReference atomicReference4 = new AtomicReference(null);
        n0.i a13 = ve.a(new c0.b(21, this, atomicReference4));
        a13.a(new x.h(0, a13, new mc.g(iVar, 16)), a12);
        androidx.concurrent.futures.b bVar4 = (androidx.concurrent.futures.b) atomicReference4.get();
        bVar4.getClass();
        this.f18326i = bVar4;
    }

    public final void a(final Surface surface, Executor executor, final k1.a aVar) {
        if (!this.f18324g.a(surface)) {
            n0.i iVar = this.f18323f;
            if (!iVar.isCancelled()) {
                pd.f(null, iVar.f16358b.isDone());
                try {
                    iVar.get();
                    final int i3 = 0;
                    executor.execute(new Runnable() { // from class: t.d1
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i3) {
                                case 0:
                                    aVar.f(new k(3, surface));
                                    break;
                                default:
                                    aVar.f(new k(4, surface));
                                    break;
                            }
                        }
                    });
                    return;
                } catch (InterruptedException | ExecutionException unused) {
                    final int i10 = 1;
                    executor.execute(new Runnable() { // from class: t.d1
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i10) {
                                case 0:
                                    aVar.f(new k(3, surface));
                                    break;
                                default:
                                    aVar.f(new k(4, surface));
                                    break;
                            }
                        }
                    });
                    return;
                }
            }
        }
        androidx.camera.core.d dVar = new androidx.camera.core.d(1, aVar, surface);
        n0.i iVar2 = this.f18325h;
        iVar2.a(new x.h(0, iVar2, dVar), executor);
    }

    public final void b(Executor executor, e1 e1Var) {
        l lVar;
        synchronized (this.f18319a) {
            this.f18330m = e1Var;
            this.f18331n = executor;
            lVar = this.f18329l;
        }
        if (lVar != null) {
            executor.execute(new b1(e1Var, lVar, 1));
        }
    }

    public final void c() {
        final String str = "Surface request will not complete.";
        this.f18324g.b(new Exception(str) { // from class: androidx.camera.core.impl.DeferrableSurface$SurfaceUnavailableException
        });
    }
}
