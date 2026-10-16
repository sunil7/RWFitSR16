package kotlin.collections;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class c extends b implements ListIterator {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f15630d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, int i3) {
        super(eVar);
        this.f15630d = eVar;
        a aVar = e.Companion;
        int size = eVar.size();
        aVar.getClass();
        if (i3 < 0 || i3 > size) {
            throw new IndexOutOfBoundsException(l0.i(i3, size, "index: ", ", size: "));
        }
        this.f15628b = i3;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f15628b > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f15628b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f15628b - 1;
        this.f15628b = i3;
        return this.f15630d.get(i3);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f15628b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
