package com.google.android.gms.internal.mlkit_vision_common;

import java.util.ArrayList;
import okio.ByteString;

/* loaded from: classes.dex */
public abstract class f6 {
    public static void a(long j4, wh.j jVar, int i3, ArrayList arrayList, int i10, int i11, ArrayList arrayList2) {
        ByteString byteString;
        int i12;
        int i13;
        long j10;
        int i14;
        wh.j jVar2;
        ArrayList arrayList3;
        int i15 = i3;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        int i16 = 0;
        int i17 = 1;
        if (!(i10 < i11)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        for (int i18 = i10; i18 < i11; i18++) {
            if (((ByteString) arrayList4.get(i18)).size() < i15) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
        ByteString byteString2 = (ByteString) arrayList.get(i10);
        ByteString byteString3 = (ByteString) arrayList4.get(i11 - 1);
        if (i15 == byteString2.size()) {
            int intValue = ((Number) arrayList5.get(i10)).intValue();
            int i19 = i10 + 1;
            byteString = (ByteString) arrayList4.get(i19);
            i12 = i19;
            i13 = intValue;
        } else {
            byteString = byteString2;
            i12 = i10;
            i13 = -1;
        }
        if (byteString.getByte(i15) == byteString3.getByte(i15)) {
            int min = Math.min(byteString.size(), byteString3.size());
            for (int i20 = i15; i20 < min && byteString.getByte(i20) == byteString3.getByte(i20); i20++) {
                i16++;
            }
            long j11 = 4;
            long j12 = (jVar.f19654b / j11) + j4 + 2 + i16 + 1;
            jVar.c0(-i16);
            jVar.c0(i13);
            int i21 = i15 + i16;
            while (i15 < i21) {
                jVar.c0(byteString.getByte(i15) & 255);
                i15++;
            }
            if (i12 + 1 == i11) {
                if (i21 != ((ByteString) arrayList4.get(i12)).size()) {
                    throw new IllegalStateException("Check failed.");
                }
                jVar.c0(((Number) arrayList5.get(i12)).intValue());
                return;
            } else {
                wh.j jVar3 = new wh.j();
                jVar.c0(((int) ((jVar3.f19654b / j11) + j12)) * (-1));
                a(j12, jVar3, i21, arrayList4, i12, i11, arrayList5);
                jVar.v(jVar3);
                return;
            }
        }
        for (int i22 = i12 + 1; i22 < i11; i22++) {
            if (((ByteString) arrayList4.get(i22 - 1)).getByte(i15) != ((ByteString) arrayList4.get(i22)).getByte(i15)) {
                i17++;
            }
        }
        long j13 = 4;
        long j14 = (jVar.f19654b / j13) + j4 + 2 + (i17 * 2);
        jVar.c0(i17);
        jVar.c0(i13);
        for (int i23 = i12; i23 < i11; i23++) {
            int i24 = ((ByteString) arrayList4.get(i23)).getByte(i15);
            if (i23 == i12 || i24 != ((ByteString) arrayList4.get(i23 - 1)).getByte(i15)) {
                jVar.c0(i24 & 255);
            }
        }
        wh.j jVar4 = new wh.j();
        int i25 = i12;
        while (i25 < i11) {
            byte b3 = ((ByteString) arrayList4.get(i25)).getByte(i15);
            int i26 = i25 + 1;
            int i27 = i26;
            while (true) {
                if (i27 >= i11) {
                    i27 = i11;
                    break;
                } else if (b3 != ((ByteString) arrayList4.get(i27)).getByte(i15)) {
                    break;
                } else {
                    i27++;
                }
            }
            if (i26 == i27 && i15 + 1 == ((ByteString) arrayList4.get(i25)).size()) {
                jVar.c0(((Number) arrayList5.get(i25)).intValue());
                int i28 = i27;
                jVar2 = jVar4;
                arrayList3 = arrayList5;
                i14 = i28;
                j10 = j14;
            } else {
                jVar.c0(((int) ((jVar4.f19654b / j13) + j14)) * (-1));
                ArrayList arrayList6 = arrayList5;
                j10 = j14;
                i14 = i27;
                a(j10, jVar4, i15 + 1, arrayList, i25, i14, arrayList6);
                arrayList4 = arrayList;
                jVar2 = jVar4;
                arrayList3 = arrayList6;
            }
            j14 = j10;
            i25 = i14;
            arrayList5 = arrayList3;
            jVar4 = jVar2;
        }
        jVar.v(jVar4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x011c, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static wh.u b(okio.ByteString... r13) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.f6.b(okio.ByteString[]):wh.u");
    }
}
