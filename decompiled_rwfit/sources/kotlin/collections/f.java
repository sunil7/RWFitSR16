package kotlin.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class f implements Collection, ph.a {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f15634a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f15635b;

    public f(Object[] values, boolean z5) {
        kotlin.jvm.internal.e.f(values, "values");
        this.f15634a = values;
        this.f15635b = z5;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        int i3;
        Object[] objArr = this.f15634a;
        kotlin.jvm.internal.e.f(objArr, "<this>");
        if (obj == null) {
            int length = objArr.length;
            i3 = 0;
            while (i3 < length) {
                if (objArr[i3] == null) {
                    break;
                }
                i3++;
            }
            i3 = -1;
        } else {
            int length2 = objArr.length;
            for (int i10 = 0; i10 < length2; i10++) {
                if (obj.equals(objArr[i10])) {
                    i3 = i10;
                    break;
                }
            }
            i3 = -1;
        }
        return i3 >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection elements) {
        kotlin.jvm.internal.e.f(elements, "elements");
        Collection collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f15634a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        Object[] array = this.f15634a;
        kotlin.jvm.internal.e.f(array, "array");
        return new b(array);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f15634a.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        Object[] objArr = this.f15634a;
        kotlin.jvm.internal.e.f(objArr, "<this>");
        if (this.f15635b && objArr.getClass().equals(Object[].class)) {
            return objArr;
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        kotlin.jvm.internal.e.e(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] array) {
        kotlin.jvm.internal.e.f(array, "array");
        return kotlin.jvm.internal.e.o(this, array);
    }
}
