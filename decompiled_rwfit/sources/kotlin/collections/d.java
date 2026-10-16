package kotlin.collections;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class d extends e implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final e f15631a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15632b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15633c;

    public d(e eVar, int i3, int i10) {
        this.f15631a = eVar;
        this.f15632b = i3;
        a aVar = e.Companion;
        int size = eVar.size();
        aVar.getClass();
        if (i3 < 0 || i10 > size) {
            StringBuilder s7 = l0.s(i3, "fromIndex: ", i10, ", toIndex: ", ", size: ");
            s7.append(size);
            throw new IndexOutOfBoundsException(s7.toString());
        }
        if (i3 > i10) {
            throw new IllegalArgumentException(l0.i(i3, i10, "fromIndex: ", " > toIndex: "));
        }
        this.f15633c = i10 - i3;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        a aVar = e.Companion;
        int i10 = this.f15633c;
        aVar.getClass();
        a.a(i3, i10);
        return this.f15631a.get(this.f15632b + i3);
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.f15633c;
    }
}
