package vh;

import java.util.Iterator;
import java.util.NoSuchElementException;
import oh.l;

/* loaded from: classes2.dex */
public final class b implements Iterator, ph.a {

    /* renamed from: a, reason: collision with root package name */
    public Object f19263a;

    /* renamed from: b, reason: collision with root package name */
    public int f19264b = -2;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o4.c f19265c;

    public b(o4.c cVar) {
        this.f19265c = cVar;
    }

    public final void a() {
        Object invoke;
        int i3 = this.f19264b;
        o4.c cVar = this.f19265c;
        if (i3 == -2) {
            invoke = ((oh.a) cVar.f16732a).invoke();
        } else {
            l lVar = (l) cVar.f16733b;
            Object obj = this.f19263a;
            kotlin.jvm.internal.e.c(obj);
            invoke = lVar.invoke(obj);
        }
        this.f19263a = invoke;
        this.f19264b = invoke == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f19264b < 0) {
            a();
        }
        return this.f19264b == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f19264b < 0) {
            a();
        }
        if (this.f19264b == 0) {
            throw new NoSuchElementException();
        }
        Object obj = this.f19263a;
        kotlin.jvm.internal.e.d(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
        this.f19264b = -1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
