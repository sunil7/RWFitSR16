package com.google.zxing.qrcode.encoder;

import a2.g;
import com.autonavi.aps.amapapi.config.Const;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import java.util.ArrayList;
import jd.f;
import ld.d;
import ld.e;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11278a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final f f11279b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f11280c;

    public c(g gVar, f fVar, d dVar) {
        int i3;
        ErrorCorrectionLevel errorCorrectionLevel;
        Mode mode;
        int i10;
        this.f11280c = gVar;
        d dVar2 = dVar;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (dVar2 == null) {
                break;
            }
            int i13 = i11 + dVar2.f15863d;
            Mode mode2 = Mode.BYTE;
            int i14 = dVar2.f15862c;
            d dVar3 = dVar2.e;
            int i15 = i12;
            Mode mode3 = dVar2.f15860a;
            boolean z5 = (mode3 == mode2 && dVar3 == null && i14 != 0) || !(dVar3 == null || i14 == dVar3.f15862c);
            i3 = z5 ? 1 : i15;
            if (dVar3 == null || dVar3.f15860a != mode3 || z5) {
                this.f11278a.add(0, new e(this, mode3, dVar2.f15861b, i14, i13));
                i10 = 0;
            } else {
                i10 = i13;
            }
            if (z5) {
                this.f11278a.add(0, new e(this, Mode.ECI, dVar2.f15861b, dVar2.f15862c, 0));
            }
            i12 = i3;
            dVar2 = dVar3;
            i11 = i10;
        }
        int i16 = i12;
        if (gVar.f32a) {
            e eVar = (e) this.f11278a.get(0);
            if (eVar != null && eVar.f15865a != (mode = Mode.ECI) && i16 != 0) {
                this.f11278a.add(0, new e(this, mode, 0, 0, 0));
            }
            this.f11278a.add(((e) this.f11278a.get(0)).f15865a == Mode.ECI ? 1 : 0, new e(this, Mode.FNC1_FIRST_POSITION, 0, 0, 0));
        }
        int i17 = fVar.f15412a;
        int i18 = 26;
        int i19 = b.f11276a[(i17 <= 9 ? MinimalEncoder$VersionSize.SMALL : i17 <= 26 ? MinimalEncoder$VersionSize.MEDIUM : MinimalEncoder$VersionSize.LARGE).ordinal()];
        if (i19 == 1) {
            i18 = 9;
        } else if (i19 != 2) {
            i3 = 27;
            i18 = 40;
        } else {
            i3 = 10;
        }
        int a3 = a(fVar);
        while (true) {
            errorCorrectionLevel = (ErrorCorrectionLevel) gVar.f35d;
            if (i17 >= i18 || a.d(a3, f.c(i17), errorCorrectionLevel)) {
                break;
            } else {
                i17++;
            }
        }
        while (i17 > i3 && a.d(a3, f.c(i17 - 1), errorCorrectionLevel)) {
            i17--;
        }
        this.f11279b = f.c(i17);
    }

    public final int a(f fVar) {
        ArrayList arrayList = this.f11278a;
        int size = arrayList.size();
        int i3 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            e eVar = (e) obj;
            Mode mode = eVar.f15865a;
            int characterCountBits = mode.getCharacterCountBits(fVar);
            int i11 = characterCountBits + 4;
            int i12 = b.f11277b[mode.ordinal()];
            int i13 = eVar.f15868d;
            if (i12 == 1) {
                i11 += i13 * 13;
            } else if (i12 != 2) {
                if (i12 == 3) {
                    int i14 = ((i13 / 3) * 10) + i11;
                    int i15 = i13 % 3;
                    i11 = i14 + (i15 != 1 ? i15 == 2 ? 7 : 0 : 4);
                } else if (i12 == 4) {
                    i11 += eVar.a() * 8;
                } else if (i12 == 5) {
                    i11 = characterCountBits + 12;
                }
            } else {
                i11 = ((i13 / 2) * 11) + i11 + (i13 % 2 == 1 ? 6 : 0);
            }
            i3 += i11;
        }
        return i3;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = this.f11278a;
        int size = arrayList.size();
        e eVar = null;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            e eVar2 = (e) obj;
            if (eVar != null) {
                sb2.append(Const.STR_MART_COMMA);
            }
            sb2.append(eVar2.toString());
            eVar = eVar2;
        }
        return sb2.toString();
    }
}
