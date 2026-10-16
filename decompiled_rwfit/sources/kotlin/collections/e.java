package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes2.dex */
public abstract class e extends AbstractCollection implements List {
    public static final a Companion = new a();

    @Override // java.util.List
    public void add(int i3, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i3, Collection<Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        Collection other = (Collection) obj;
        Companion.getClass();
        kotlin.jvm.internal.e.f(other, "other");
        if (size() == other.size()) {
            Iterator it = other.iterator();
            Iterator<E> it2 = iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.e.a(it2.next(), it.next())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        Companion.getClass();
        Iterator<E> it = iterator();
        int i3 = 1;
        while (it.hasNext()) {
            Object next = it.next();
            i3 = (i3 * 31) + (next != null ? next.hashCode() : 0);
        }
        return i3;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        Iterator it = iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (kotlin.jvm.internal.e.a(it.next(), obj)) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<Object> iterator() {
        return new b(this);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.e.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator() {
        return new c(this, 0);
    }

    @Override // java.util.List
    public Object remove(int i3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public Object set(int i3, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<Object> subList(int i3, int i10) {
        return new d(this, i3, i10);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator(int i3) {
        return new c(this, i3);
    }
}
