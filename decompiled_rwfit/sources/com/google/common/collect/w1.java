package com.google.common.collect;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.jb;
import com.google.android.gms.internal.mlkit_vision_barcode.kb;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class w1 {

    /* renamed from: a, reason: collision with root package name */
    public transient Object[] f11139a;

    /* renamed from: b, reason: collision with root package name */
    public transient int[] f11140b;

    /* renamed from: c, reason: collision with root package name */
    public transient int f11141c;

    /* renamed from: d, reason: collision with root package name */
    public transient int f11142d;
    public transient int[] e;

    /* renamed from: f, reason: collision with root package name */
    public transient long[] f11143f;

    /* renamed from: g, reason: collision with root package name */
    public transient float f11144g;

    /* renamed from: h, reason: collision with root package name */
    public transient int f11145h;

    public final void a(int i3) {
        if (i3 > this.f11143f.length) {
            i(i3);
        }
        if (i3 >= this.f11145h) {
            j(Math.max(2, Integer.highestOneBit(i3 - 1) << 1));
        }
    }

    public final int b(Object obj) {
        int d5 = d(obj);
        if (d5 == -1) {
            return 0;
        }
        return this.f11140b[d5];
    }

    public final int c(int i3) {
        kb.d(i3, this.f11141c);
        return this.f11140b[i3];
    }

    public final int d(Object obj) {
        int o3 = h.o(obj);
        int i3 = this.e[(r1.length - 1) & o3];
        while (i3 != -1) {
            long j4 = this.f11143f[i3];
            if (((int) (j4 >>> 32)) == o3 && jb.a(obj, this.f11139a[i3])) {
                return i3;
            }
            i3 = (int) j4;
        }
        return -1;
    }

    public final void e(int i3) {
        kb.c("Initial capacity must be non-negative", i3 >= 0);
        int f2 = h.f(i3, 1.0f);
        int[] iArr = new int[f2];
        Arrays.fill(iArr, -1);
        this.e = iArr;
        this.f11144g = 1.0f;
        this.f11139a = new Object[i3];
        this.f11140b = new int[i3];
        long[] jArr = new long[i3];
        Arrays.fill(jArr, -1L);
        this.f11143f = jArr;
        this.f11145h = Math.max(1, (int) (f2 * 1.0f));
    }

    public final int f(int i3, Object obj) {
        long j4;
        if (i3 <= 0) {
            throw new IllegalArgumentException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "count must be positive but was: "));
        }
        long[] jArr = this.f11143f;
        Object[] objArr = this.f11139a;
        int[] iArr = this.f11140b;
        int o3 = h.o(obj);
        int[] iArr2 = this.e;
        int length = (iArr2.length - 1) & o3;
        int i10 = this.f11141c;
        int i11 = iArr2[length];
        if (i11 == -1) {
            iArr2[length] = i10;
            j4 = 4294967295L;
        } else {
            while (true) {
                long j10 = jArr[i11];
                j4 = 4294967295L;
                if (((int) (j10 >>> 32)) == o3 && jb.a(obj, objArr[i11])) {
                    int i12 = iArr[i11];
                    iArr[i11] = i3;
                    return i12;
                }
                int i13 = (int) j10;
                if (i13 == -1) {
                    jArr[i11] = ((-4294967296L) & j10) | (i10 & 4294967295L);
                    break;
                }
                i11 = i13;
            }
        }
        int i14 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        if (i10 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i15 = i10 + 1;
        int length2 = this.f11143f.length;
        if (i15 > length2) {
            int max = Math.max(1, length2 >>> 1) + length2;
            if (max >= 0) {
                i14 = max;
            }
            if (i14 != length2) {
                i(i14);
            }
        }
        this.f11143f[i10] = (o3 << 32) | j4;
        this.f11139a[i10] = obj;
        this.f11140b[i10] = i3;
        this.f11141c = i15;
        if (i10 >= this.f11145h) {
            j(this.e.length * 2);
        }
        this.f11142d++;
        return 0;
    }

    public final int g(Object obj, int i3) {
        int i10;
        long[] jArr;
        long j4;
        int length = (r2.length - 1) & i3;
        int i11 = this.e[length];
        if (i11 == -1) {
            return 0;
        }
        int i12 = -1;
        while (true) {
            if (((int) (this.f11143f[i11] >>> 32)) == i3 && jb.a(obj, this.f11139a[i11])) {
                int[] iArr = this.f11140b;
                int i13 = iArr[i11];
                if (i12 == -1) {
                    this.e[length] = (int) this.f11143f[i11];
                    i10 = 0;
                } else {
                    long[] jArr2 = this.f11143f;
                    i10 = 0;
                    jArr2[i12] = (((int) jArr2[i11]) & 4294967295L) | (jArr2[i12] & (-4294967296L));
                }
                int i14 = this.f11141c - 1;
                if (i11 < i14) {
                    Object[] objArr = this.f11139a;
                    objArr[i11] = objArr[i14];
                    iArr[i11] = iArr[i14];
                    objArr[i14] = null;
                    iArr[i14] = i10;
                    long[] jArr3 = this.f11143f;
                    long j10 = jArr3[i14];
                    jArr3[i11] = j10;
                    jArr3[i14] = -1;
                    int[] iArr2 = this.e;
                    int length2 = ((int) (j10 >>> 32)) & (iArr2.length - 1);
                    int i15 = iArr2[length2];
                    if (i15 == i14) {
                        iArr2[length2] = i11;
                    } else {
                        while (true) {
                            jArr = this.f11143f;
                            j4 = jArr[i15];
                            int i16 = (int) j4;
                            if (i16 == i14) {
                                break;
                            }
                            i15 = i16;
                        }
                        jArr[i15] = (j4 & (-4294967296L)) | (i11 & 4294967295L);
                    }
                } else {
                    this.f11139a[i11] = null;
                    iArr[i11] = i10;
                    this.f11143f[i11] = -1;
                }
                this.f11141c--;
                this.f11142d++;
                return i13;
            }
            int i17 = (int) this.f11143f[i11];
            if (i17 == -1) {
                return 0;
            }
            i12 = i11;
            i11 = i17;
        }
    }

    public final int h(int i3) {
        return g(this.f11139a[i3], (int) (this.f11143f[i3] >>> 32));
    }

    public final void i(int i3) {
        this.f11139a = Arrays.copyOf(this.f11139a, i3);
        this.f11140b = Arrays.copyOf(this.f11140b, i3);
        long[] jArr = this.f11143f;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i3);
        if (i3 > length) {
            Arrays.fill(copyOf, length, i3, -1L);
        }
        this.f11143f = copyOf;
    }

    public final void j(int i3) {
        if (this.e.length >= 1073741824) {
            this.f11145h = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            return;
        }
        int i10 = ((int) (i3 * this.f11144g)) + 1;
        int[] iArr = new int[i3];
        Arrays.fill(iArr, -1);
        long[] jArr = this.f11143f;
        int i11 = i3 - 1;
        for (int i12 = 0; i12 < this.f11141c; i12++) {
            int i13 = (int) (jArr[i12] >>> 32);
            int i14 = i13 & i11;
            int i15 = iArr[i14];
            iArr[i14] = i12;
            jArr[i12] = (i13 << 32) | (i15 & 4294967295L);
        }
        this.f11145h = i10;
        this.e = iArr;
    }
}
