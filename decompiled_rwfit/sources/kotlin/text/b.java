package kotlin.text;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.f0;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class b implements Iterator, ph.a {

    /* renamed from: a, reason: collision with root package name */
    public int f15659a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f15660b;

    /* renamed from: c, reason: collision with root package name */
    public int f15661c;

    /* renamed from: d, reason: collision with root package name */
    public th.c f15662d;
    public final /* synthetic */ ef.i e;

    public b(ef.i iVar) {
        this.e = iVar;
        iVar.getClass();
        int length = ((CharSequence) iVar.f12629b).length();
        if (length < 0) {
            throw new IllegalArgumentException(l0.k(length, "Cannot coerce value to an empty range: maximum ", " is less than minimum 0."));
        }
        length = length >= 0 ? 0 : length;
        this.f15660b = length;
        this.f15661c = length;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.jvm.internal.Lambda, oh.p] */
    public final void a() {
        int i3 = this.f15661c;
        if (i3 < 0) {
            this.f15659a = 0;
            this.f15662d = null;
            return;
        }
        ef.i iVar = this.e;
        iVar.getClass();
        CharSequence charSequence = (CharSequence) iVar.f12629b;
        if (i3 > charSequence.length()) {
            this.f15662d = new th.c(this.f15660b, m.g(charSequence), 1);
            this.f15661c = -1;
        } else {
            Pair pair = (Pair) ((Lambda) iVar.f12630c).invoke(charSequence, Integer.valueOf(this.f15661c));
            if (pair == null) {
                this.f15662d = new th.c(this.f15660b, m.g(charSequence), 1);
                this.f15661c = -1;
            } else {
                int intValue = ((Number) pair.component1()).intValue();
                int intValue2 = ((Number) pair.component2()).intValue();
                this.f15662d = f0.b(this.f15660b, intValue);
                int i10 = intValue + intValue2;
                this.f15660b = i10;
                this.f15661c = i10 + (intValue2 == 0 ? 1 : 0);
            }
        }
        this.f15659a = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f15659a == -1) {
            a();
        }
        return this.f15659a == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f15659a == -1) {
            a();
        }
        if (this.f15659a == 0) {
            throw new NoSuchElementException();
        }
        th.c cVar = this.f15662d;
        kotlin.jvm.internal.e.d(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.f15662d = null;
        this.f15659a = -1;
        return cVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
