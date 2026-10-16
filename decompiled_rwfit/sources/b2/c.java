package b2;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f3095a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean[] f3096b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f3097c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3098d;
    public boolean e;

    public c(int i3) {
        long[] jArr = new long[i3];
        this.f3095a = jArr;
        boolean[] zArr = new boolean[i3];
        this.f3096b = zArr;
        this.f3097c = new int[i3];
        Arrays.fill(jArr, 0L);
        Arrays.fill(zArr, false);
    }

    public final int[] a() {
        synchronized (this) {
            try {
                if (this.f3098d && !this.e) {
                    int length = this.f3095a.length;
                    int i3 = 0;
                    while (true) {
                        int i10 = 1;
                        if (i3 >= length) {
                            this.e = true;
                            this.f3098d = false;
                            return this.f3097c;
                        }
                        boolean z5 = this.f3095a[i3] > 0;
                        boolean[] zArr = this.f3096b;
                        if (z5 != zArr[i3]) {
                            int[] iArr = this.f3097c;
                            if (!z5) {
                                i10 = 2;
                            }
                            iArr[i3] = i10;
                        } else {
                            this.f3097c[i3] = 0;
                        }
                        zArr[i3] = z5;
                        i3++;
                    }
                }
                return null;
            } finally {
            }
        }
    }
}
