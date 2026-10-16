package ld;

import a2.g;
import com.google.zxing.qrcode.decoder.Mode;
import jd.f;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Mode f15860a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15861b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15862c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15863d;
    public final d e;

    /* renamed from: f, reason: collision with root package name */
    public final int f15864f;

    public d(g gVar, Mode mode, int i3, int i10, int i11, d dVar, f fVar) {
        this.f15860a = mode;
        this.f15861b = i3;
        Mode mode2 = Mode.BYTE;
        int i12 = (mode == mode2 || dVar == null) ? i10 : dVar.f15862c;
        this.f15862c = i12;
        this.f15863d = i11;
        this.e = dVar;
        boolean z5 = false;
        int i13 = dVar != null ? dVar.f15864f : 0;
        if ((mode == mode2 && dVar == null && i12 != 0) || (dVar != null && i12 != dVar.f15862c)) {
            z5 = true;
        }
        i13 = (dVar == null || mode != dVar.f15860a || z5) ? i13 + mode.getCharacterCountBits(fVar) + 4 : i13;
        int i14 = com.google.zxing.qrcode.encoder.b.f11277b[mode.ordinal()];
        if (i14 == 1) {
            i13 += 13;
        } else if (i14 == 2) {
            i13 += i11 == 1 ? 6 : 11;
        } else if (i14 == 3) {
            i13 += i11 != 1 ? i11 == 2 ? 7 : 10 : 4;
        } else if (i14 == 4) {
            i13 += ((String) gVar.f33b).substring(i3, i11 + i3).getBytes(((sc.e) gVar.f34c).f18238a[i10].charset()).length * 8;
            if (z5) {
                i13 += 12;
            }
        }
        this.f15864f = i13;
    }
}
