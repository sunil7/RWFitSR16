package c1;

import android.graphics.Insets;

/* loaded from: classes.dex */
public final class c {
    public static final c e = new c(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f3354a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3355b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3356c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3357d;

    public c(int i3, int i10, int i11, int i12) {
        this.f3354a = i3;
        this.f3355b = i10;
        this.f3356c = i11;
        this.f3357d = i12;
    }

    public static c a(int i3, int i10, int i11, int i12) {
        return (i3 == 0 && i10 == 0 && i11 == 0 && i12 == 0) ? e : new c(i3, i10, i11, i12);
    }

    public static c b(Insets insets) {
        int i3;
        int i10;
        int i11;
        int i12;
        i3 = insets.left;
        i10 = insets.top;
        i11 = insets.right;
        i12 = insets.bottom;
        return a(i3, i10, i11, i12);
    }

    public final Insets c() {
        return b.a(this.f3354a, this.f3355b, this.f3356c, this.f3357d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f3357d == cVar.f3357d && this.f3354a == cVar.f3354a && this.f3356c == cVar.f3356c && this.f3355b == cVar.f3355b;
    }

    public final int hashCode() {
        return (((((this.f3354a * 31) + this.f3355b) * 31) + this.f3356c) * 31) + this.f3357d;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Insets{left=");
        sb2.append(this.f3354a);
        sb2.append(", top=");
        sb2.append(this.f3355b);
        sb2.append(", right=");
        sb2.append(this.f3356c);
        sb2.append(", bottom=");
        return android.support.v4.media.session.e.m(sb2, this.f3357d, '}');
    }
}
