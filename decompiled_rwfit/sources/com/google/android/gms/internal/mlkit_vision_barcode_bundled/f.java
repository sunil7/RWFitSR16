package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class f implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9779a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f9779a) {
            case 0:
                int t8 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String[] strArr = null;
                int i3 = 0;
                while (parcel.dataPosition() < t8) {
                    int readInt = parcel.readInt();
                    char c9 = (char) readInt;
                    if (c9 == 1) {
                        i3 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt);
                    } else if (c9 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt);
                    } else {
                        strArr = com.google.android.gms.internal.mlkit_vision_common.t.h(parcel, readInt);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t8);
                return new zzam(strArr, i3);
            case 1:
                int t10 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str = null;
                String str2 = null;
                byte[] bArr = null;
                Point[] pointArr = null;
                zzar zzarVar = null;
                zzau zzauVar = null;
                zzav zzavVar = null;
                zzax zzaxVar = null;
                zzaw zzawVar = null;
                zzas zzasVar = null;
                zzao zzaoVar = null;
                zzap zzapVar = null;
                zzaq zzaqVar = null;
                int i10 = 0;
                int i11 = 0;
                while (parcel.dataPosition() < t10) {
                    int readInt2 = parcel.readInt();
                    switch ((char) readInt2) {
                        case 1:
                            i10 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt2);
                            break;
                        case 2:
                            str = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt2);
                            break;
                        case 3:
                            str2 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt2);
                            break;
                        case 4:
                            bArr = com.google.android.gms.internal.mlkit_vision_common.t.c(parcel, readInt2);
                            break;
                        case 5:
                            pointArr = (Point[]) com.google.android.gms.internal.mlkit_vision_common.t.i(parcel, readInt2, Point.CREATOR);
                            break;
                        case 6:
                            i11 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt2);
                            break;
                        case 7:
                            zzarVar = (zzar) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt2, zzar.CREATOR);
                            break;
                        case '\b':
                            zzauVar = (zzau) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt2, zzau.CREATOR);
                            break;
                        case '\t':
                            zzavVar = (zzav) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt2, zzav.CREATOR);
                            break;
                        case '\n':
                            zzaxVar = (zzax) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt2, zzax.CREATOR);
                            break;
                        case 11:
                            zzawVar = (zzaw) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt2, zzaw.CREATOR);
                            break;
                        case '\f':
                            zzasVar = (zzas) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt2, zzas.CREATOR);
                            break;
                        case '\r':
                            zzaoVar = (zzao) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt2, zzao.CREATOR);
                            break;
                        case 14:
                            zzapVar = (zzap) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt2, zzap.CREATOR);
                            break;
                        case 15:
                            zzaqVar = (zzaq) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt2, zzaq.CREATOR);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt2);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t10);
                return new zzay(i10, str, str2, bArr, pointArr, i11, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar);
            case 2:
                int t11 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                int i12 = 0;
                boolean z5 = false;
                while (parcel.dataPosition() < t11) {
                    int readInt3 = parcel.readInt();
                    char c10 = (char) readInt3;
                    if (c10 == 1) {
                        i12 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt3);
                    } else if (c10 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt3);
                    } else {
                        z5 = com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt3);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t11);
                return new zzba(i12, z5);
            case 3:
                int t12 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                boolean z6 = false;
                zzbt zzbtVar = null;
                zzbv zzbvVar = null;
                while (parcel.dataPosition() < t12) {
                    int readInt4 = parcel.readInt();
                    char c11 = (char) readInt4;
                    if (c11 == 1) {
                        zzbtVar = (zzbt) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt4, zzbt.CREATOR);
                    } else if (c11 == 2) {
                        zzbvVar = (zzbv) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt4, zzbv.CREATOR);
                    } else if (c11 == 3) {
                        com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt4);
                    } else if (c11 != 4) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt4);
                    } else {
                        z6 = com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt4);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t12);
                return new zzbc(zzbtVar, zzbvVar, z6);
            case 4:
                int t13 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                zzbr zzbrVar = null;
                while (parcel.dataPosition() < t13) {
                    int readInt5 = parcel.readInt();
                    if (((char) readInt5) != 1) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt5);
                    } else {
                        zzbrVar = (zzbr) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt5, zzbr.CREATOR);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t13);
                return new zzbe(zzbrVar);
            case 5:
                int t14 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str3 = null;
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                boolean z8 = false;
                while (parcel.dataPosition() < t14) {
                    int readInt6 = parcel.readInt();
                    switch ((char) readInt6) {
                        case 1:
                            i13 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt6);
                            break;
                        case 2:
                            i14 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt6);
                            break;
                        case 3:
                            i15 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt6);
                            break;
                        case 4:
                            i16 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt6);
                            break;
                        case 5:
                            i17 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt6);
                            break;
                        case 6:
                            i18 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt6);
                            break;
                        case 7:
                            z8 = com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt6);
                            break;
                        case '\b':
                            str3 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt6);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt6);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t14);
                return new zzan(i13, i14, i15, i16, i17, i18, z8, str3);
            case 6:
                int t15 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str4 = null;
                String str5 = null;
                String str6 = null;
                String str7 = null;
                String str8 = null;
                zzan zzanVar = null;
                zzan zzanVar2 = null;
                while (parcel.dataPosition() < t15) {
                    int readInt7 = parcel.readInt();
                    switch ((char) readInt7) {
                        case 1:
                            str4 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt7);
                            break;
                        case 2:
                            str5 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt7);
                            break;
                        case 3:
                            str6 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt7);
                            break;
                        case 4:
                            str7 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt7);
                            break;
                        case 5:
                            str8 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt7);
                            break;
                        case 6:
                            zzanVar = (zzan) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt7, zzan.CREATOR);
                            break;
                        case 7:
                            zzanVar2 = (zzan) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt7, zzan.CREATOR);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt7);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t15);
                return new zzao(str4, str5, str6, str7, str8, zzanVar, zzanVar2);
            case 7:
                int t16 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                zzat zzatVar = null;
                String str9 = null;
                String str10 = null;
                zzau[] zzauVarArr = null;
                zzar[] zzarVarArr = null;
                String[] strArr2 = null;
                zzam[] zzamVarArr = null;
                while (parcel.dataPosition() < t16) {
                    int readInt8 = parcel.readInt();
                    switch ((char) readInt8) {
                        case 1:
                            zzatVar = (zzat) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt8, zzat.CREATOR);
                            break;
                        case 2:
                            str9 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt8);
                            break;
                        case 3:
                            str10 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt8);
                            break;
                        case 4:
                            zzauVarArr = (zzau[]) com.google.android.gms.internal.mlkit_vision_common.t.i(parcel, readInt8, zzau.CREATOR);
                            break;
                        case 5:
                            zzarVarArr = (zzar[]) com.google.android.gms.internal.mlkit_vision_common.t.i(parcel, readInt8, zzar.CREATOR);
                            break;
                        case 6:
                            strArr2 = com.google.android.gms.internal.mlkit_vision_common.t.h(parcel, readInt8);
                            break;
                        case 7:
                            zzamVarArr = (zzam[]) com.google.android.gms.internal.mlkit_vision_common.t.i(parcel, readInt8, zzam.CREATOR);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt8);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t16);
                return new zzap(zzatVar, str9, str10, zzauVarArr, zzarVarArr, strArr2, zzamVarArr);
            case 8:
                int t17 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str11 = null;
                String str12 = null;
                String str13 = null;
                String str14 = null;
                String str15 = null;
                String str16 = null;
                String str17 = null;
                String str18 = null;
                String str19 = null;
                String str20 = null;
                String str21 = null;
                String str22 = null;
                String str23 = null;
                String str24 = null;
                while (parcel.dataPosition() < t17) {
                    int readInt9 = parcel.readInt();
                    switch ((char) readInt9) {
                        case 1:
                            str11 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt9);
                            break;
                        case 2:
                            str12 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt9);
                            break;
                        case 3:
                            str13 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt9);
                            break;
                        case 4:
                            str14 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt9);
                            break;
                        case 5:
                            str15 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt9);
                            break;
                        case 6:
                            str16 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt9);
                            break;
                        case 7:
                            str17 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt9);
                            break;
                        case '\b':
                            str18 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt9);
                            break;
                        case '\t':
                            str19 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt9);
                            break;
                        case '\n':
                            str20 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt9);
                            break;
                        case 11:
                            str21 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt9);
                            break;
                        case '\f':
                            str22 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt9);
                            break;
                        case '\r':
                            str23 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt9);
                            break;
                        case 14:
                            str24 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt9);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt9);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t17);
                return new zzaq(str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24);
            case 9:
                int t18 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str25 = null;
                String str26 = null;
                int i19 = 0;
                String str27 = null;
                while (parcel.dataPosition() < t18) {
                    int readInt10 = parcel.readInt();
                    char c12 = (char) readInt10;
                    if (c12 == 1) {
                        i19 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt10);
                    } else if (c12 == 2) {
                        str25 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt10);
                    } else if (c12 == 3) {
                        str27 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt10);
                    } else if (c12 != 4) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt10);
                    } else {
                        str26 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt10);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t18);
                return new zzar(i19, str25, str27, str26);
            case 10:
                int t19 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                double d5 = 0.0d;
                double d8 = 0.0d;
                while (parcel.dataPosition() < t19) {
                    int readInt11 = parcel.readInt();
                    char c13 = (char) readInt11;
                    if (c13 == 1) {
                        d5 = com.google.android.gms.internal.mlkit_vision_common.t.m(parcel, readInt11);
                    } else if (c13 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt11);
                    } else {
                        d8 = com.google.android.gms.internal.mlkit_vision_common.t.m(parcel, readInt11);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t19);
                return new zzas(d5, d8);
            case 11:
                int t20 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                boolean z10 = false;
                boolean z11 = false;
                boolean z12 = false;
                float f2 = 0.0f;
                byte[] bArr2 = null;
                while (parcel.dataPosition() < t20) {
                    int readInt12 = parcel.readInt();
                    char c14 = (char) readInt12;
                    if (c14 == 1) {
                        z10 = com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt12);
                    } else if (c14 == 2) {
                        bArr2 = com.google.android.gms.internal.mlkit_vision_common.t.c(parcel, readInt12);
                    } else if (c14 == 3) {
                        z11 = com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt12);
                    } else if (c14 == 4) {
                        com.google.android.gms.internal.mlkit_vision_common.t.u(parcel, readInt12, 4);
                        f2 = parcel.readFloat();
                    } else if (c14 != 5) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt12);
                    } else {
                        z12 = com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt12);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t20);
                return new zzbr(z10, bArr2, z11, f2, z12);
            case 12:
                int t21 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                int i20 = 0;
                float[] fArr = null;
                boolean z13 = false;
                while (parcel.dataPosition() < t21) {
                    int readInt13 = parcel.readInt();
                    char c15 = (char) readInt13;
                    if (c15 == 1) {
                        fArr = com.google.android.gms.internal.mlkit_vision_common.t.d(parcel, readInt13);
                    } else if (c15 == 2) {
                        i20 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt13);
                    } else if (c15 != 3) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt13);
                    } else {
                        z13 = com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt13);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t21);
                return new zzbt(fArr, i20, z13);
            case 13:
                int t22 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                float[] fArr2 = null;
                while (parcel.dataPosition() < t22) {
                    int readInt14 = parcel.readInt();
                    if (((char) readInt14) != 1) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt14);
                    } else {
                        fArr2 = com.google.android.gms.internal.mlkit_vision_common.t.d(parcel, readInt14);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t22);
                return new zzbv(fArr2);
            case 14:
                int t23 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str28 = null;
                String str29 = null;
                String str30 = null;
                String str31 = null;
                String str32 = null;
                String str33 = null;
                String str34 = null;
                while (parcel.dataPosition() < t23) {
                    int readInt15 = parcel.readInt();
                    switch ((char) readInt15) {
                        case 1:
                            str28 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt15);
                            break;
                        case 2:
                            str29 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt15);
                            break;
                        case 3:
                            str30 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt15);
                            break;
                        case 4:
                            str31 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt15);
                            break;
                        case 5:
                            str32 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt15);
                            break;
                        case 6:
                            str33 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt15);
                            break;
                        case 7:
                            str34 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt15);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt15);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t23);
                return new zzat(str28, str29, str30, str31, str32, str33, str34);
            case 15:
                int t24 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str35 = null;
                int i21 = 0;
                while (parcel.dataPosition() < t24) {
                    int readInt16 = parcel.readInt();
                    char c16 = (char) readInt16;
                    if (c16 == 1) {
                        i21 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt16);
                    } else if (c16 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt16);
                    } else {
                        str35 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt16);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t24);
                return new zzau(i21, str35);
            case 16:
                int t25 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str36 = null;
                String str37 = null;
                while (parcel.dataPosition() < t25) {
                    int readInt17 = parcel.readInt();
                    char c17 = (char) readInt17;
                    if (c17 == 1) {
                        str36 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt17);
                    } else if (c17 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt17);
                    } else {
                        str37 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt17);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t25);
                return new zzav(str36, str37);
            case 17:
                int t26 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str38 = null;
                String str39 = null;
                while (parcel.dataPosition() < t26) {
                    int readInt18 = parcel.readInt();
                    char c18 = (char) readInt18;
                    if (c18 == 1) {
                        str38 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt18);
                    } else if (c18 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt18);
                    } else {
                        str39 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt18);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t26);
                return new zzaw(str38, str39);
            case 18:
                int t27 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                int i22 = 0;
                String str40 = null;
                String str41 = null;
                while (parcel.dataPosition() < t27) {
                    int readInt19 = parcel.readInt();
                    char c19 = (char) readInt19;
                    if (c19 == 1) {
                        str40 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt19);
                    } else if (c19 == 2) {
                        str41 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt19);
                    } else if (c19 != 3) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt19);
                    } else {
                        i22 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt19);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t27);
                return new zzax(str40, str41, i22);
            default:
                int t28 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                long j4 = 0;
                int i23 = 0;
                int i24 = 0;
                int i25 = 0;
                int i26 = 0;
                while (parcel.dataPosition() < t28) {
                    int readInt20 = parcel.readInt();
                    char c20 = (char) readInt20;
                    if (c20 == 1) {
                        i23 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt20);
                    } else if (c20 == 2) {
                        i24 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt20);
                    } else if (c20 == 3) {
                        i25 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt20);
                    } else if (c20 == 4) {
                        i26 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt20);
                    } else if (c20 != 5) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt20);
                    } else {
                        j4 = com.google.android.gms.internal.mlkit_vision_common.t.p(parcel, readInt20);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t28);
                return new zzcc(j4, i23, i24, i25, i26);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        switch (this.f9779a) {
            case 0:
                return new zzam[i3];
            case 1:
                return new zzay[i3];
            case 2:
                return new zzba[i3];
            case 3:
                return new zzbc[i3];
            case 4:
                return new zzbe[i3];
            case 5:
                return new zzan[i3];
            case 6:
                return new zzao[i3];
            case 7:
                return new zzap[i3];
            case 8:
                return new zzaq[i3];
            case 9:
                return new zzar[i3];
            case 10:
                return new zzas[i3];
            case 11:
                return new zzbr[i3];
            case 12:
                return new zzbt[i3];
            case 13:
                return new zzbv[i3];
            case 14:
                return new zzat[i3];
            case 15:
                return new zzau[i3];
            case 16:
                return new zzav[i3];
            case 17:
                return new zzaw[i3];
            case 18:
                return new zzax[i3];
            default:
                return new zzcc[i3];
        }
    }
}
