package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes2.dex */
public final class s extends e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f15641a;

    public s(List delegate) {
        kotlin.jvm.internal.e.f(delegate, "delegate");
        this.f15641a = delegate;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List
    public final Object get(int i3) {
        return this.f15641a.get(h.j(i3, this));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.f15641a.size();
    }

    @Override // kotlin.collections.e, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new q(this, 0);
    }

    @Override // kotlin.collections.e, java.util.List
    public final ListIterator listIterator() {
        return new q(this, 0);
    }

    @Override // kotlin.collections.e, java.util.List
    public final ListIterator listIterator(int i3) {
        return new q(this, i3);
    }
}
