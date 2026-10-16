package uc;

import android.support.v4.media.session.e;
import com.google.mlkit.common.MlKitException;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: h, reason: collision with root package name */
    public static final a f19032h = new a(4201, 4096, 1);

    /* renamed from: i, reason: collision with root package name */
    public static final a f19033i = new a(1033, 1024, 1);

    /* renamed from: j, reason: collision with root package name */
    public static final a f19034j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f19035k;

    /* renamed from: l, reason: collision with root package name */
    public static final a f19036l;

    /* renamed from: m, reason: collision with root package name */
    public static final a f19037m;

    /* renamed from: n, reason: collision with root package name */
    public static final a f19038n;

    /* renamed from: o, reason: collision with root package name */
    public static final a f19039o;

    /* renamed from: a, reason: collision with root package name */
    public final int[] f19040a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f19041b;

    /* renamed from: c, reason: collision with root package name */
    public final b f19042c;

    /* renamed from: d, reason: collision with root package name */
    public final b f19043d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final int f19044f;

    /* renamed from: g, reason: collision with root package name */
    public final int f19045g;

    static {
        a aVar = new a(67, 64, 1);
        f19034j = aVar;
        f19035k = new a(19, 16, 1);
        f19036l = new a(285, 256, 0);
        a aVar2 = new a(MlKitException.LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE, 256, 1);
        f19037m = aVar2;
        f19038n = aVar2;
        f19039o = aVar;
    }

    public a(int i3, int i10, int i11) {
        this.f19044f = i3;
        this.e = i10;
        this.f19045g = i11;
        this.f19040a = new int[i10];
        this.f19041b = new int[i10];
        int i12 = 1;
        for (int i13 = 0; i13 < i10; i13++) {
            this.f19040a[i13] = i12;
            i12 *= 2;
            if (i12 >= i10) {
                i12 = (i12 ^ i3) & (i10 - 1);
            }
        }
        for (int i14 = 0; i14 < i10 - 1; i14++) {
            this.f19041b[this.f19040a[i14]] = i14;
        }
        this.f19042c = new b(this, new int[]{0});
        this.f19043d = new b(this, new int[]{1});
    }

    public final b a(int i3, int i10) {
        if (i3 < 0) {
            throw new IllegalArgumentException();
        }
        if (i10 == 0) {
            return this.f19042c;
        }
        int[] iArr = new int[i3 + 1];
        iArr[0] = i10;
        return new b(this, iArr);
    }

    public final int b(int i3) {
        if (i3 == 0) {
            throw new ArithmeticException();
        }
        return this.f19040a[(this.e - this.f19041b[i3]) - 1];
    }

    public final int c(int i3, int i10) {
        if (i3 == 0 || i10 == 0) {
            return 0;
        }
        int[] iArr = this.f19041b;
        return this.f19040a[(iArr[i3] + iArr[i10]) % (this.e - 1)];
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("GF(0x");
        sb2.append(Integer.toHexString(this.f19044f));
        sb2.append(',');
        return e.m(sb2, this.e, ')');
    }
}
