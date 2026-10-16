package z3;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class a extends WeakReference {

    /* renamed from: a, reason: collision with root package name */
    public final m f20206a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f20207b;

    /* renamed from: c, reason: collision with root package name */
    public s f20208c;

    public a(m mVar, n nVar, ReferenceQueue referenceQueue) {
        super(nVar, referenceQueue);
        t4.f.c(mVar, "Argument must not be null");
        this.f20206a = mVar;
        boolean z5 = nVar.f20277a;
        this.f20208c = null;
        this.f20207b = z5;
    }
}
