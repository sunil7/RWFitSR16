package th;

import com.google.android.gms.internal.mlkit_vision_barcode.od;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class a implements Iterable, ph.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f18633a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18634b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18635c;

    public a(int i3, int i10, int i11) {
        if (i11 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i11 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f18633a = i3;
        this.f18634b = od.a(i3, i10, i11);
        this.f18635c = i11;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (isEmpty() && ((a) obj).isEmpty()) {
            return true;
        }
        a aVar = (a) obj;
        return this.f18633a == aVar.f18633a && this.f18634b == aVar.f18634b && this.f18635c == aVar.f18635c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f18633a * 31) + this.f18634b) * 31) + this.f18635c;
    }

    public boolean isEmpty() {
        int i3 = this.f18635c;
        int i10 = this.f18634b;
        int i11 = this.f18633a;
        return i3 > 0 ? i11 > i10 : i11 < i10;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new b(this.f18633a, this.f18634b, this.f18635c);
    }

    public String toString() {
        StringBuilder sb2;
        int i3 = this.f18634b;
        int i10 = this.f18633a;
        int i11 = this.f18635c;
        if (i11 > 0) {
            sb2 = new StringBuilder();
            sb2.append(i10);
            sb2.append("..");
            sb2.append(i3);
            sb2.append(" step ");
            sb2.append(i11);
        } else {
            sb2 = new StringBuilder();
            sb2.append(i10);
            sb2.append(" downTo ");
            sb2.append(i3);
            sb2.append(" step ");
            sb2.append(-i11);
        }
        return sb2.toString();
    }
}
