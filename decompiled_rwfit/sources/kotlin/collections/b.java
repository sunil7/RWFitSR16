package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class b implements Iterator, ph.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15627a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f15628b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f15629c;

    public b(Object[] array) {
        kotlin.jvm.internal.e.f(array, "array");
        this.f15629c = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator it;
        switch (this.f15627a) {
            case 0:
                return this.f15628b < ((e) this.f15629c).size();
            case 1:
                return this.f15628b < ((Object[]) this.f15629c).length;
        }
        while (true) {
            int i3 = this.f15628b;
            it = (Iterator) this.f15629c;
            if (i3 > 0 && it.hasNext()) {
                it.next();
                this.f15628b--;
            }
        }
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Iterator it;
        switch (this.f15627a) {
            case 0:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i3 = this.f15628b;
                this.f15628b = i3 + 1;
                return ((e) this.f15629c).get(i3);
            case 1:
                try {
                    Object[] objArr = (Object[]) this.f15629c;
                    int i10 = this.f15628b;
                    this.f15628b = i10 + 1;
                    return objArr[i10];
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.f15628b--;
                    throw new NoSuchElementException(e.getMessage());
                }
        }
        while (true) {
            int i11 = this.f15628b;
            it = (Iterator) this.f15629c;
            if (i11 > 0 && it.hasNext()) {
                it.next();
                this.f15628b--;
            }
        }
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f15627a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(e eVar) {
        this.f15629c = eVar;
    }

    public b(vh.a aVar) {
        this.f15629c = aVar.f19261a.iterator();
        this.f15628b = aVar.f19262b;
    }
}
