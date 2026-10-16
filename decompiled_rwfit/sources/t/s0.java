package t;

import android.media.ImageReader;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.Surface;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class s0 implements androidx.camera.core.impl.r0, w {

    /* renamed from: a, reason: collision with root package name */
    public final Object f18393a;

    /* renamed from: b, reason: collision with root package name */
    public final g0.g f18394b;

    /* renamed from: c, reason: collision with root package name */
    public int f18395c;

    /* renamed from: d, reason: collision with root package name */
    public final af.a f18396d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final c f18397f;

    /* renamed from: g, reason: collision with root package name */
    public androidx.camera.core.impl.q0 f18398g;

    /* renamed from: h, reason: collision with root package name */
    public Executor f18399h;

    /* renamed from: i, reason: collision with root package name */
    public final LongSparseArray f18400i;

    /* renamed from: j, reason: collision with root package name */
    public final LongSparseArray f18401j;

    /* renamed from: k, reason: collision with root package name */
    public int f18402k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f18403l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f18404m;

    public s0(int i3, int i10, int i11, int i12) {
        c cVar = new c(ImageReader.newInstance(i3, i10, i11, i12));
        this.f18393a = new Object();
        this.f18394b = new g0.g(this, 1);
        this.f18395c = 0;
        this.f18396d = new af.a(this, 26);
        this.e = false;
        this.f18400i = new LongSparseArray();
        this.f18401j = new LongSparseArray();
        this.f18404m = new ArrayList();
        this.f18397f = cVar;
        this.f18402k = 0;
        this.f18403l = new ArrayList(q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$enqueueImageProxy$1(androidx.camera.core.impl.q0 q0Var) {
        q0Var.c(this);
    }

    @Override // t.w
    public final void a(x xVar) {
        synchronized (this.f18393a) {
            c(xVar);
        }
    }

    public final void c(x xVar) {
        synchronized (this.f18393a) {
            try {
                int indexOf = this.f18403l.indexOf(xVar);
                if (indexOf >= 0) {
                    this.f18403l.remove(indexOf);
                    int i3 = this.f18402k;
                    if (indexOf <= i3) {
                        this.f18402k = i3 - 1;
                    }
                }
                this.f18404m.remove(xVar);
                if (this.f18395c > 0) {
                    f(this.f18397f);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.camera.core.impl.r0
    public final void close() {
        synchronized (this.f18393a) {
            try {
                if (this.e) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.f18403l);
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((p0) obj).close();
                }
                this.f18403l.clear();
                this.f18397f.close();
                this.e = true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void d(a1 a1Var) {
        androidx.camera.core.impl.q0 q0Var;
        Executor executor;
        synchronized (this.f18393a) {
            try {
                if (this.f18403l.size() < q()) {
                    a1Var.addOnImageCloseListener(this);
                    this.f18403l.add(a1Var);
                    q0Var = this.f18398g;
                    executor = this.f18399h;
                } else {
                    com.google.android.gms.internal.mlkit_vision_common.a0.a("TAG", "Maximum image number reached.");
                    a1Var.close();
                    q0Var = null;
                    executor = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (q0Var != null) {
            if (executor != null) {
                executor.execute(new n5.a(6, this, q0Var));
            } else {
                q0Var.c(this);
            }
        }
    }

    @Override // androidx.camera.core.impl.r0
    public final Surface e() {
        Surface e;
        synchronized (this.f18393a) {
            e = this.f18397f.e();
        }
        return e;
    }

    public final void f(androidx.camera.core.impl.r0 r0Var) {
        p0 p0Var;
        synchronized (this.f18393a) {
            try {
                if (this.e) {
                    return;
                }
                int size = this.f18401j.size() + this.f18403l.size();
                if (size >= r0Var.q()) {
                    com.google.android.gms.internal.mlkit_vision_common.a0.a("MetadataImageReader", "Skip to acquire the next image because the acquired image count has reached the max images count.");
                    return;
                }
                do {
                    try {
                        p0Var = r0Var.r();
                        if (p0Var != null) {
                            this.f18395c--;
                            size++;
                            this.f18401j.put(p0Var.u().d(), p0Var);
                            g();
                        }
                    } catch (IllegalStateException e) {
                        if (com.google.android.gms.internal.mlkit_vision_common.a0.d(3, "MetadataImageReader")) {
                            Log.d("MetadataImageReader", "Failed to acquire next image.", e);
                        }
                        p0Var = null;
                    }
                    if (p0Var == null || this.f18395c <= 0) {
                        break;
                    }
                } while (size < r0Var.q());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void g() {
        synchronized (this.f18393a) {
            try {
                for (int size = this.f18400i.size() - 1; size >= 0; size--) {
                    n0 n0Var = (n0) this.f18400i.valueAt(size);
                    long d5 = n0Var.d();
                    p0 p0Var = (p0) this.f18401j.get(d5);
                    if (p0Var != null) {
                        this.f18401j.remove(d5);
                        this.f18400i.removeAt(size);
                        d(new a1(p0Var, null, n0Var));
                    }
                }
                h();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.camera.core.impl.r0, wa.f
    public final int getHeight() {
        int height;
        synchronized (this.f18393a) {
            height = this.f18397f.getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.r0, wa.f
    public final int getWidth() {
        int width;
        synchronized (this.f18393a) {
            width = this.f18397f.getWidth();
        }
        return width;
    }

    public final void h() {
        synchronized (this.f18393a) {
            try {
                if (this.f18401j.size() != 0 && this.f18400i.size() != 0) {
                    long keyAt = this.f18401j.keyAt(0);
                    Long valueOf = Long.valueOf(keyAt);
                    long keyAt2 = this.f18400i.keyAt(0);
                    pd.b(!Long.valueOf(keyAt2).equals(valueOf));
                    if (keyAt2 > keyAt) {
                        for (int size = this.f18401j.size() - 1; size >= 0; size--) {
                            if (this.f18401j.keyAt(size) < keyAt2) {
                                ((p0) this.f18401j.valueAt(size)).close();
                                this.f18401j.removeAt(size);
                            }
                        }
                    } else {
                        for (int size2 = this.f18400i.size() - 1; size2 >= 0; size2--) {
                            if (this.f18400i.keyAt(size2) < keyAt) {
                                this.f18400i.removeAt(size2);
                            }
                        }
                    }
                }
            } finally {
            }
        }
    }

    @Override // androidx.camera.core.impl.r0
    public final p0 k() {
        synchronized (this.f18393a) {
            try {
                if (this.f18403l.isEmpty()) {
                    return null;
                }
                if (this.f18402k >= this.f18403l.size()) {
                    throw new IllegalStateException("Maximum image number reached.");
                }
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                for (int i10 = 0; i10 < this.f18403l.size() - 1; i10++) {
                    if (!this.f18404m.contains(this.f18403l.get(i10))) {
                        arrayList.add((p0) this.f18403l.get(i10));
                    }
                }
                int size = arrayList.size();
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((p0) obj).close();
                }
                int size2 = this.f18403l.size();
                ArrayList arrayList2 = this.f18403l;
                this.f18402k = size2;
                p0 p0Var = (p0) arrayList2.get(size2 - 1);
                this.f18404m.add(p0Var);
                return p0Var;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.camera.core.impl.r0
    public final int m() {
        int m10;
        synchronized (this.f18393a) {
            m10 = this.f18397f.m();
        }
        return m10;
    }

    @Override // androidx.camera.core.impl.r0
    public final void o() {
        synchronized (this.f18393a) {
            this.f18397f.o();
            this.f18398g = null;
            this.f18399h = null;
            this.f18395c = 0;
        }
    }

    @Override // androidx.camera.core.impl.r0
    public final int q() {
        int q5;
        synchronized (this.f18393a) {
            q5 = this.f18397f.q();
        }
        return q5;
    }

    @Override // androidx.camera.core.impl.r0
    public final p0 r() {
        synchronized (this.f18393a) {
            try {
                if (this.f18403l.isEmpty()) {
                    return null;
                }
                if (this.f18402k >= this.f18403l.size()) {
                    throw new IllegalStateException("Maximum image number reached.");
                }
                ArrayList arrayList = this.f18403l;
                int i3 = this.f18402k;
                this.f18402k = i3 + 1;
                p0 p0Var = (p0) arrayList.get(i3);
                this.f18404m.add(p0Var);
                return p0Var;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.camera.core.impl.r0
    public final void t(androidx.camera.core.impl.q0 q0Var, Executor executor) {
        synchronized (this.f18393a) {
            q0Var.getClass();
            this.f18398g = q0Var;
            executor.getClass();
            this.f18399h = executor;
            this.f18397f.t(this.f18396d, executor);
        }
    }
}
