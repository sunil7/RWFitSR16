package bd;

import com.google.zxing.h;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f3213a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f3214b;

    /* renamed from: c, reason: collision with root package name */
    public final h[] f3215c;

    public c(int i3, int i10, int i11, int i12, int[] iArr) {
        this.f3213a = i3;
        this.f3214b = iArr;
        float f2 = i12;
        this.f3215c = new h[]{new h(i10, f2), new h(i11, f2)};
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && this.f3213a == ((c) obj).f3213a;
    }

    public final int hashCode() {
        return this.f3213a;
    }
}
