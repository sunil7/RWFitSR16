package t;

import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class x implements p0 {

    /* renamed from: b, reason: collision with root package name */
    public final p0 f18423b;

    /* renamed from: a, reason: collision with root package name */
    public final Object f18422a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f18424c = new HashSet();

    public x(p0 p0Var) {
        this.f18423b = p0Var;
    }

    public void addOnImageCloseListener(w wVar) {
        synchronized (this.f18422a) {
            this.f18424c.add(wVar);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        HashSet hashSet;
        this.f18423b.close();
        synchronized (this.f18422a) {
            hashSet = new HashSet(this.f18424c);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((w) it.next()).a(this);
        }
    }

    @Override // t.p0
    public int getHeight() {
        return this.f18423b.getHeight();
    }

    @Override // t.p0
    public int getWidth() {
        return this.f18423b.getWidth();
    }

    @Override // t.p0
    public final int n() {
        return this.f18423b.n();
    }

    @Override // t.p0
    public final n6.a[] o() {
        return this.f18423b.o();
    }

    @Override // t.p0
    public n0 u() {
        return this.f18423b.u();
    }
}
