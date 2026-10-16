package gd;

import ef.i;

/* loaded from: classes.dex */
public final class a {
    public static final a e = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f14050a = new int[929];

    /* renamed from: b, reason: collision with root package name */
    public final int[] f14051b = new int[929];

    /* renamed from: c, reason: collision with root package name */
    public final i f14052c;

    /* renamed from: d, reason: collision with root package name */
    public final i f14053d;

    public a() {
        int i3 = 1;
        for (int i10 = 0; i10 < 929; i10++) {
            this.f14050a[i10] = i3;
            i3 = (i3 * 3) % 929;
        }
        for (int i11 = 0; i11 < 928; i11++) {
            this.f14051b[this.f14050a[i11]] = i11;
        }
        this.f14052c = new i(this, new int[]{0});
        this.f14053d = new i(this, new int[]{1});
    }

    public final int a(int i3, int i10) {
        return (i3 + i10) % 929;
    }

    public final int b(int i3) {
        if (i3 == 0) {
            throw new ArithmeticException();
        }
        return this.f14050a[928 - this.f14051b[i3]];
    }

    public final int c(int i3, int i10) {
        if (i3 == 0 || i10 == 0) {
            return 0;
        }
        int[] iArr = this.f14051b;
        return this.f14050a[(iArr[i3] + iArr[i10]) % 928];
    }
}
