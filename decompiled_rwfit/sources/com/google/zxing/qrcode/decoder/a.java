package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import jd.d;
import jd.f;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final sc.b f11264a;

    /* renamed from: b, reason: collision with root package name */
    public f f11265b;

    /* renamed from: c, reason: collision with root package name */
    public d f11266c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11267d;

    public a(sc.b bVar) {
        int i3 = bVar.f18222b;
        if (i3 < 21 || (i3 & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.f11264a = bVar;
    }

    public final int a(int i3, int i10, int i11) {
        boolean z5 = this.f11267d;
        sc.b bVar = this.f11264a;
        return z5 ? bVar.b(i10, i3) : bVar.b(i3, i10) ? (i11 << 1) | 1 : i11 << 1;
    }

    public final d b() {
        d dVar = this.f11266c;
        if (dVar != null) {
            return dVar;
        }
        int i3 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < 6; i11++) {
            i10 = a(i11, 8, i10);
        }
        int a3 = a(8, 7, a(8, 8, a(7, 8, i10)));
        for (int i12 = 5; i12 >= 0; i12--) {
            a3 = a(8, i12, a3);
        }
        int i13 = this.f11264a.f18222b;
        int i14 = i13 - 7;
        for (int i15 = i13 - 1; i15 >= i14; i15--) {
            i3 = a(8, i15, i3);
        }
        for (int i16 = i13 - 8; i16 < i13; i16++) {
            i3 = a(i16, 8, i3);
        }
        d a10 = d.a(a3, i3);
        if (a10 == null) {
            a10 = d.a(a3 ^ 21522, i3 ^ 21522);
        }
        this.f11266c = a10;
        if (a10 != null) {
            return a10;
        }
        throw FormatException.getFormatInstance();
    }

    public final f c() {
        f fVar = this.f11265b;
        if (fVar != null) {
            return fVar;
        }
        int i3 = this.f11264a.f18222b;
        int i10 = (i3 - 17) / 4;
        if (i10 <= 6) {
            return f.c(i10);
        }
        int i11 = i3 - 11;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 5; i14 >= 0; i14--) {
            for (int i15 = i3 - 9; i15 >= i11; i15--) {
                i13 = a(i15, i14, i13);
            }
        }
        f b3 = f.b(i13);
        if (b3 != null && (b3.f15412a * 4) + 17 == i3) {
            this.f11265b = b3;
            return b3;
        }
        for (int i16 = 5; i16 >= 0; i16--) {
            for (int i17 = i3 - 9; i17 >= i11; i17--) {
                i12 = a(i16, i17, i12);
            }
        }
        f b10 = f.b(i12);
        if (b10 == null || (b10.f15412a * 4) + 17 != i3) {
            throw FormatException.getFormatInstance();
        }
        this.f11265b = b10;
        return b10;
    }

    public final void d() {
        if (this.f11266c == null) {
            return;
        }
        DataMask dataMask = DataMask.values()[this.f11266c.f15410b];
        sc.b bVar = this.f11264a;
        dataMask.unmaskBitMatrix(bVar, bVar.f18222b);
    }
}
