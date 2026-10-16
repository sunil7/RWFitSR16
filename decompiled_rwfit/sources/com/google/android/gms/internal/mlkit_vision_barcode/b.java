package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9230a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f9230a) {
            case 0:
                int t8 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str = null;
                String str2 = null;
                int i3 = 0;
                String str3 = null;
                while (parcel.dataPosition() < t8) {
                    int readInt = parcel.readInt();
                    char c9 = (char) readInt;
                    if (c9 == 2) {
                        i3 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt);
                    } else if (c9 == 3) {
                        str = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt);
                    } else if (c9 == 4) {
                        str3 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt);
                    } else if (c9 != 5) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt);
                    } else {
                        str2 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t8);
                zzn zznVar = new zzn();
                zznVar.zza = i3;
                zznVar.zzb = str;
                zznVar.zzc = str3;
                zznVar.zzd = str2;
                return zznVar;
            case 1:
                int t10 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                double d5 = 0.0d;
                double d8 = 0.0d;
                while (parcel.dataPosition() < t10) {
                    int readInt2 = parcel.readInt();
                    char c10 = (char) readInt2;
                    if (c10 == 2) {
                        d5 = com.google.android.gms.internal.mlkit_vision_common.t.m(parcel, readInt2);
                    } else if (c10 != 3) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt2);
                    } else {
                        d8 = com.google.android.gms.internal.mlkit_vision_common.t.m(parcel, readInt2);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t10);
                zzo zzoVar = new zzo();
                zzoVar.zza = d5;
                zzoVar.zzb = d8;
                return zzoVar;
            case 2:
                int t11 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str4 = null;
                String str5 = null;
                String str6 = null;
                String str7 = null;
                String str8 = null;
                String str9 = null;
                String str10 = null;
                while (parcel.dataPosition() < t11) {
                    int readInt3 = parcel.readInt();
                    switch ((char) readInt3) {
                        case 2:
                            str4 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt3);
                            break;
                        case 3:
                            str5 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt3);
                            break;
                        case 4:
                            str6 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt3);
                            break;
                        case 5:
                            str7 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt3);
                            break;
                        case 6:
                            str8 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt3);
                            break;
                        case 7:
                            str9 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt3);
                            break;
                        case '\b':
                            str10 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt3);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt3);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t11);
                zzp zzpVar = new zzp();
                zzpVar.zza = str4;
                zzpVar.zzb = str5;
                zzpVar.zzc = str6;
                zzpVar.zzd = str7;
                zzpVar.zze = str8;
                zzpVar.zzf = str9;
                zzpVar.zzg = str10;
                return zzpVar;
            case 3:
                int t12 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str11 = null;
                int i10 = 0;
                while (parcel.dataPosition() < t12) {
                    int readInt4 = parcel.readInt();
                    char c11 = (char) readInt4;
                    if (c11 == 2) {
                        i10 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt4);
                    } else if (c11 != 3) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt4);
                    } else {
                        str11 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt4);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t12);
                zzq zzqVar = new zzq();
                zzqVar.zza = i10;
                zzqVar.zzb = str11;
                return zzqVar;
            case 4:
                int t13 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str12 = null;
                String str13 = null;
                while (parcel.dataPosition() < t13) {
                    int readInt5 = parcel.readInt();
                    char c12 = (char) readInt5;
                    if (c12 == 2) {
                        str12 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt5);
                    } else if (c12 != 3) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt5);
                    } else {
                        str13 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt5);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t13);
                zzr zzrVar = new zzr();
                zzrVar.zza = str12;
                zzrVar.zzb = str13;
                return zzrVar;
            case 5:
                int t14 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str14 = null;
                String str15 = null;
                while (parcel.dataPosition() < t14) {
                    int readInt6 = parcel.readInt();
                    char c13 = (char) readInt6;
                    if (c13 == 2) {
                        str14 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt6);
                    } else if (c13 != 3) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt6);
                    } else {
                        str15 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt6);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t14);
                zzs zzsVar = new zzs();
                zzsVar.zza = str14;
                zzsVar.zzb = str15;
                return zzsVar;
            case 6:
                int t15 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                int i11 = 0;
                String str16 = null;
                String str17 = null;
                while (parcel.dataPosition() < t15) {
                    int readInt7 = parcel.readInt();
                    char c14 = (char) readInt7;
                    if (c14 == 2) {
                        str16 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt7);
                    } else if (c14 == 3) {
                        str17 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt7);
                    } else if (c14 != 4) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt7);
                    } else {
                        i11 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt7);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t15);
                zzt zztVar = new zzt();
                zztVar.zza = str16;
                zztVar.zzb = str17;
                zztVar.zzc = i11;
                return zztVar;
            case 7:
                int t16 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                int i12 = 0;
                boolean z5 = false;
                while (parcel.dataPosition() < t16) {
                    int readInt8 = parcel.readInt();
                    char c15 = (char) readInt8;
                    if (c15 == 2) {
                        i12 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt8);
                    } else if (c15 != 3) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt8);
                    } else {
                        z5 = com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt8);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t16);
                zzah zzahVar = new zzah();
                zzahVar.zza = i12;
                zzahVar.zzb = z5;
                return zzahVar;
            case 8:
                int t17 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                long j4 = 0;
                while (parcel.dataPosition() < t17) {
                    int readInt9 = parcel.readInt();
                    char c16 = (char) readInt9;
                    if (c16 == 2) {
                        i13 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt9);
                    } else if (c16 == 3) {
                        i14 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt9);
                    } else if (c16 == 4) {
                        i15 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt9);
                    } else if (c16 == 5) {
                        j4 = com.google.android.gms.internal.mlkit_vision_common.t.p(parcel, readInt9);
                    } else if (c16 != 6) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt9);
                    } else {
                        i16 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt9);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t17);
                return new zzan(j4, i13, i14, i15, i16);
            case 9:
                int t18 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String[] strArr = null;
                int i17 = 0;
                while (parcel.dataPosition() < t18) {
                    int readInt10 = parcel.readInt();
                    char c17 = (char) readInt10;
                    if (c17 == 2) {
                        i17 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt10);
                    } else if (c17 != 3) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt10);
                    } else {
                        strArr = com.google.android.gms.internal.mlkit_vision_common.t.h(parcel, readInt10);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t18);
                zzi zziVar = new zzi();
                zziVar.zza = i17;
                zziVar.zzb = strArr;
                return zziVar;
            case 10:
                int t19 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                double d10 = 0.0d;
                int i18 = 0;
                boolean z6 = false;
                String str18 = null;
                String str19 = null;
                Point[] pointArr = null;
                zzn zznVar2 = null;
                zzq zzqVar2 = null;
                zzr zzrVar2 = null;
                zzt zztVar2 = null;
                byte[] bArr = null;
                zzo zzoVar2 = null;
                zzs zzsVar2 = null;
                zzk zzkVar = null;
                zzl zzlVar = null;
                zzm zzmVar = null;
                int i19 = 0;
                while (parcel.dataPosition() < t19) {
                    int readInt11 = parcel.readInt();
                    zzt zztVar3 = zztVar2;
                    switch ((char) readInt11) {
                        case 2:
                            i18 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt11);
                            break;
                        case 3:
                            str18 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt11);
                            break;
                        case 4:
                            str19 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt11);
                            break;
                        case 5:
                            i19 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt11);
                            break;
                        case 6:
                            pointArr = (Point[]) com.google.android.gms.internal.mlkit_vision_common.t.i(parcel, readInt11, Point.CREATOR);
                            break;
                        case 7:
                            zznVar2 = (zzn) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt11, zzn.CREATOR);
                            break;
                        case '\b':
                            zzqVar2 = (zzq) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt11, zzq.CREATOR);
                            break;
                        case '\t':
                            zzrVar2 = (zzr) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt11, zzr.CREATOR);
                            break;
                        case '\n':
                            zztVar2 = (zzt) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt11, zzt.CREATOR);
                            continue;
                        case 11:
                            zzsVar2 = (zzs) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt11, zzs.CREATOR);
                            break;
                        case '\f':
                            zzoVar2 = (zzo) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt11, zzo.CREATOR);
                            break;
                        case '\r':
                            zzkVar = (zzk) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt11, zzk.CREATOR);
                            break;
                        case 14:
                            zzlVar = (zzl) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt11, zzl.CREATOR);
                            break;
                        case 15:
                            zzmVar = (zzm) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt11, zzm.CREATOR);
                            break;
                        case 16:
                            bArr = com.google.android.gms.internal.mlkit_vision_common.t.c(parcel, readInt11);
                            break;
                        case 17:
                            z6 = com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt11);
                            break;
                        case 18:
                            d10 = com.google.android.gms.internal.mlkit_vision_common.t.m(parcel, readInt11);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt11);
                            break;
                    }
                    zztVar2 = zztVar3;
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t19);
                zzu zzuVar = new zzu();
                zzuVar.zza = i18;
                zzuVar.zzb = str18;
                zzuVar.zzo = bArr;
                zzuVar.zzc = str19;
                zzuVar.zzd = i19;
                zzuVar.zze = pointArr;
                zzuVar.zzp = z6;
                zzuVar.zzq = d10;
                zzuVar.zzf = zznVar2;
                zzuVar.zzg = zzqVar2;
                zzuVar.zzh = zzrVar2;
                zzuVar.zzi = zztVar2;
                zzuVar.zzj = zzsVar2;
                zzuVar.zzk = zzoVar2;
                zzuVar.zzl = zzkVar;
                zzuVar.zzm = zzlVar;
                zzuVar.zzn = zzmVar;
                return zzuVar;
            case 11:
                int t20 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str20 = null;
                int i20 = 0;
                int i21 = 0;
                int i22 = 0;
                int i23 = 0;
                int i24 = 0;
                int i25 = 0;
                boolean z8 = false;
                while (parcel.dataPosition() < t20) {
                    int readInt12 = parcel.readInt();
                    switch ((char) readInt12) {
                        case 2:
                            i20 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt12);
                            break;
                        case 3:
                            i21 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt12);
                            break;
                        case 4:
                            i22 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt12);
                            break;
                        case 5:
                            i23 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt12);
                            break;
                        case 6:
                            i24 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt12);
                            break;
                        case 7:
                            i25 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt12);
                            break;
                        case '\b':
                            z8 = com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt12);
                            break;
                        case '\t':
                            str20 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt12);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt12);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t20);
                zzj zzjVar = new zzj();
                zzjVar.zza = i20;
                zzjVar.zzb = i21;
                zzjVar.zzc = i22;
                zzjVar.zzd = i23;
                zzjVar.zze = i24;
                zzjVar.zzf = i25;
                zzjVar.zzg = z8;
                zzjVar.zzh = str20;
                return zzjVar;
            case 12:
                int t21 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str21 = null;
                String str22 = null;
                String str23 = null;
                String str24 = null;
                String str25 = null;
                zzj zzjVar2 = null;
                zzj zzjVar3 = null;
                while (parcel.dataPosition() < t21) {
                    int readInt13 = parcel.readInt();
                    switch ((char) readInt13) {
                        case 2:
                            str21 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt13);
                            break;
                        case 3:
                            str22 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt13);
                            break;
                        case 4:
                            str23 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt13);
                            break;
                        case 5:
                            str24 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt13);
                            break;
                        case 6:
                            str25 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt13);
                            break;
                        case 7:
                            zzjVar2 = (zzj) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt13, zzj.CREATOR);
                            break;
                        case '\b':
                            zzjVar3 = (zzj) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt13, zzj.CREATOR);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt13);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t21);
                zzk zzkVar2 = new zzk();
                zzkVar2.zza = str21;
                zzkVar2.zzb = str22;
                zzkVar2.zzc = str23;
                zzkVar2.zzd = str24;
                zzkVar2.zze = str25;
                zzkVar2.zzf = zzjVar2;
                zzkVar2.zzg = zzjVar3;
                return zzkVar2;
            case 13:
                int t22 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String[] strArr2 = null;
                int i26 = 0;
                while (parcel.dataPosition() < t22) {
                    int readInt14 = parcel.readInt();
                    char c18 = (char) readInt14;
                    if (c18 == 1) {
                        i26 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt14);
                    } else if (c18 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt14);
                    } else {
                        strArr2 = com.google.android.gms.internal.mlkit_vision_common.t.h(parcel, readInt14);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t22);
                return new zzxp(strArr2, i26);
            case 14:
                int t23 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                zzp zzpVar2 = null;
                String str26 = null;
                String str27 = null;
                zzq[] zzqVarArr = null;
                zzn[] zznVarArr = null;
                String[] strArr3 = null;
                zzi[] zziVarArr = null;
                while (parcel.dataPosition() < t23) {
                    int readInt15 = parcel.readInt();
                    switch ((char) readInt15) {
                        case 2:
                            zzpVar2 = (zzp) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt15, zzp.CREATOR);
                            break;
                        case 3:
                            str26 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt15);
                            break;
                        case 4:
                            str27 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt15);
                            break;
                        case 5:
                            zzqVarArr = (zzq[]) com.google.android.gms.internal.mlkit_vision_common.t.i(parcel, readInt15, zzq.CREATOR);
                            break;
                        case 6:
                            zznVarArr = (zzn[]) com.google.android.gms.internal.mlkit_vision_common.t.i(parcel, readInt15, zzn.CREATOR);
                            break;
                        case 7:
                            strArr3 = com.google.android.gms.internal.mlkit_vision_common.t.h(parcel, readInt15);
                            break;
                        case '\b':
                            zziVarArr = (zzi[]) com.google.android.gms.internal.mlkit_vision_common.t.i(parcel, readInt15, zzi.CREATOR);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt15);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t23);
                zzl zzlVar2 = new zzl();
                zzlVar2.zza = zzpVar2;
                zzlVar2.zzb = str26;
                zzlVar2.zzc = str27;
                zzlVar2.zzd = zzqVarArr;
                zzlVar2.zze = zznVarArr;
                zzlVar2.zzf = strArr3;
                zzlVar2.zzg = zziVarArr;
                return zzlVar2;
            case 15:
                int t24 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str28 = null;
                String str29 = null;
                byte[] bArr2 = null;
                Point[] pointArr2 = null;
                zzxu zzxuVar = null;
                zzxx zzxxVar = null;
                zzxy zzxyVar = null;
                zzya zzyaVar = null;
                zzxz zzxzVar = null;
                zzxv zzxvVar = null;
                zzxr zzxrVar = null;
                zzxs zzxsVar = null;
                zzxt zzxtVar = null;
                int i27 = 0;
                int i28 = 0;
                while (parcel.dataPosition() < t24) {
                    int readInt16 = parcel.readInt();
                    switch ((char) readInt16) {
                        case 1:
                            i27 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt16);
                            break;
                        case 2:
                            str28 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt16);
                            break;
                        case 3:
                            str29 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt16);
                            break;
                        case 4:
                            bArr2 = com.google.android.gms.internal.mlkit_vision_common.t.c(parcel, readInt16);
                            break;
                        case 5:
                            pointArr2 = (Point[]) com.google.android.gms.internal.mlkit_vision_common.t.i(parcel, readInt16, Point.CREATOR);
                            break;
                        case 6:
                            i28 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt16);
                            break;
                        case 7:
                            zzxuVar = (zzxu) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt16, zzxu.CREATOR);
                            break;
                        case '\b':
                            zzxxVar = (zzxx) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt16, zzxx.CREATOR);
                            break;
                        case '\t':
                            zzxyVar = (zzxy) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt16, zzxy.CREATOR);
                            break;
                        case '\n':
                            zzyaVar = (zzya) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt16, zzya.CREATOR);
                            break;
                        case 11:
                            zzxzVar = (zzxz) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt16, zzxz.CREATOR);
                            break;
                        case '\f':
                            zzxvVar = (zzxv) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt16, zzxv.CREATOR);
                            break;
                        case '\r':
                            zzxrVar = (zzxr) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt16, zzxr.CREATOR);
                            break;
                        case 14:
                            zzxsVar = (zzxs) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt16, zzxs.CREATOR);
                            break;
                        case 15:
                            zzxtVar = (zzxt) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt16, zzxt.CREATOR);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt16);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t24);
                return new zzyb(i27, str28, str29, bArr2, pointArr2, i28, zzxuVar, zzxxVar, zzxyVar, zzyaVar, zzxzVar, zzxvVar, zzxrVar, zzxsVar, zzxtVar);
            case 16:
                int t25 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                int i29 = 0;
                boolean z10 = false;
                while (parcel.dataPosition() < t25) {
                    int readInt17 = parcel.readInt();
                    char c19 = (char) readInt17;
                    if (c19 == 1) {
                        i29 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt17);
                    } else if (c19 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt17);
                    } else {
                        z10 = com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt17);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t25);
                return new zzyd(i29, z10);
            case 17:
                int t26 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str30 = null;
                int i30 = 0;
                int i31 = 0;
                int i32 = 0;
                int i33 = 0;
                int i34 = 0;
                int i35 = 0;
                boolean z11 = false;
                while (parcel.dataPosition() < t26) {
                    int readInt18 = parcel.readInt();
                    switch ((char) readInt18) {
                        case 1:
                            i30 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt18);
                            break;
                        case 2:
                            i31 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt18);
                            break;
                        case 3:
                            i32 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt18);
                            break;
                        case 4:
                            i33 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt18);
                            break;
                        case 5:
                            i34 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt18);
                            break;
                        case 6:
                            i35 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt18);
                            break;
                        case 7:
                            z11 = com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt18);
                            break;
                        case '\b':
                            str30 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt18);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt18);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t26);
                return new zzxq(i30, i31, i32, i33, i34, i35, z11, str30);
            case 18:
                int t27 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str31 = null;
                String str32 = null;
                String str33 = null;
                String str34 = null;
                String str35 = null;
                zzxq zzxqVar = null;
                zzxq zzxqVar2 = null;
                while (parcel.dataPosition() < t27) {
                    int readInt19 = parcel.readInt();
                    switch ((char) readInt19) {
                        case 1:
                            str31 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt19);
                            break;
                        case 2:
                            str32 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt19);
                            break;
                        case 3:
                            str33 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt19);
                            break;
                        case 4:
                            str34 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt19);
                            break;
                        case 5:
                            str35 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt19);
                            break;
                        case 6:
                            zzxqVar = (zzxq) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt19, zzxq.CREATOR);
                            break;
                        case 7:
                            zzxqVar2 = (zzxq) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt19, zzxq.CREATOR);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt19);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t27);
                return new zzxr(str31, str32, str33, str34, str35, zzxqVar, zzxqVar2);
            case 19:
                int t28 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                zzxw zzxwVar = null;
                String str36 = null;
                String str37 = null;
                zzxx[] zzxxVarArr = null;
                zzxu[] zzxuVarArr = null;
                String[] strArr4 = null;
                zzxp[] zzxpVarArr = null;
                while (parcel.dataPosition() < t28) {
                    int readInt20 = parcel.readInt();
                    switch ((char) readInt20) {
                        case 1:
                            zzxwVar = (zzxw) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt20, zzxw.CREATOR);
                            break;
                        case 2:
                            str36 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt20);
                            break;
                        case 3:
                            str37 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt20);
                            break;
                        case 4:
                            zzxxVarArr = (zzxx[]) com.google.android.gms.internal.mlkit_vision_common.t.i(parcel, readInt20, zzxx.CREATOR);
                            break;
                        case 5:
                            zzxuVarArr = (zzxu[]) com.google.android.gms.internal.mlkit_vision_common.t.i(parcel, readInt20, zzxu.CREATOR);
                            break;
                        case 6:
                            strArr4 = com.google.android.gms.internal.mlkit_vision_common.t.h(parcel, readInt20);
                            break;
                        case 7:
                            zzxpVarArr = (zzxp[]) com.google.android.gms.internal.mlkit_vision_common.t.i(parcel, readInt20, zzxp.CREATOR);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt20);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t28);
                return new zzxs(zzxwVar, str36, str37, zzxxVarArr, zzxuVarArr, strArr4, zzxpVarArr);
            case 20:
                int t29 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str38 = null;
                String str39 = null;
                String str40 = null;
                String str41 = null;
                String str42 = null;
                String str43 = null;
                String str44 = null;
                String str45 = null;
                String str46 = null;
                String str47 = null;
                String str48 = null;
                String str49 = null;
                String str50 = null;
                String str51 = null;
                while (parcel.dataPosition() < t29) {
                    int readInt21 = parcel.readInt();
                    switch ((char) readInt21) {
                        case 1:
                            str38 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt21);
                            break;
                        case 2:
                            str39 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt21);
                            break;
                        case 3:
                            str40 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt21);
                            break;
                        case 4:
                            str41 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt21);
                            break;
                        case 5:
                            str42 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt21);
                            break;
                        case 6:
                            str43 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt21);
                            break;
                        case 7:
                            str44 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt21);
                            break;
                        case '\b':
                            str45 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt21);
                            break;
                        case '\t':
                            str46 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt21);
                            break;
                        case '\n':
                            str47 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt21);
                            break;
                        case 11:
                            str48 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt21);
                            break;
                        case '\f':
                            str49 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt21);
                            break;
                        case '\r':
                            str50 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt21);
                            break;
                        case 14:
                            str51 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt21);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt21);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t29);
                return new zzxt(str38, str39, str40, str41, str42, str43, str44, str45, str46, str47, str48, str49, str50, str51);
            case 21:
                int t30 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str52 = null;
                String str53 = null;
                int i36 = 0;
                String str54 = null;
                while (parcel.dataPosition() < t30) {
                    int readInt22 = parcel.readInt();
                    char c20 = (char) readInt22;
                    if (c20 == 1) {
                        i36 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt22);
                    } else if (c20 == 2) {
                        str52 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt22);
                    } else if (c20 == 3) {
                        str54 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt22);
                    } else if (c20 != 4) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt22);
                    } else {
                        str53 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt22);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t30);
                return new zzxu(i36, str52, str54, str53);
            case 22:
                int t31 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                double d11 = 0.0d;
                double d12 = 0.0d;
                while (parcel.dataPosition() < t31) {
                    int readInt23 = parcel.readInt();
                    char c21 = (char) readInt23;
                    if (c21 == 1) {
                        d11 = com.google.android.gms.internal.mlkit_vision_common.t.m(parcel, readInt23);
                    } else if (c21 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt23);
                    } else {
                        d12 = com.google.android.gms.internal.mlkit_vision_common.t.m(parcel, readInt23);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t31);
                return new zzxv(d11, d12);
            case 23:
                int t32 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str55 = null;
                String str56 = null;
                String str57 = null;
                String str58 = null;
                String str59 = null;
                String str60 = null;
                String str61 = null;
                while (parcel.dataPosition() < t32) {
                    int readInt24 = parcel.readInt();
                    switch ((char) readInt24) {
                        case 1:
                            str55 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt24);
                            break;
                        case 2:
                            str56 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt24);
                            break;
                        case 3:
                            str57 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt24);
                            break;
                        case 4:
                            str58 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt24);
                            break;
                        case 5:
                            str59 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt24);
                            break;
                        case 6:
                            str60 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt24);
                            break;
                        case 7:
                            str61 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt24);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt24);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t32);
                return new zzxw(str55, str56, str57, str58, str59, str60, str61);
            case 24:
                int t33 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str62 = null;
                int i37 = 0;
                while (parcel.dataPosition() < t33) {
                    int readInt25 = parcel.readInt();
                    char c22 = (char) readInt25;
                    if (c22 == 1) {
                        i37 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt25);
                    } else if (c22 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt25);
                    } else {
                        str62 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt25);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t33);
                return new zzxx(i37, str62);
            case 25:
                int t34 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str63 = null;
                String str64 = null;
                while (parcel.dataPosition() < t34) {
                    int readInt26 = parcel.readInt();
                    char c23 = (char) readInt26;
                    if (c23 == 1) {
                        str63 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt26);
                    } else if (c23 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt26);
                    } else {
                        str64 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt26);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t34);
                return new zzxy(str63, str64);
            case 26:
                int t35 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str65 = null;
                String str66 = null;
                while (parcel.dataPosition() < t35) {
                    int readInt27 = parcel.readInt();
                    char c24 = (char) readInt27;
                    if (c24 == 1) {
                        str65 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt27);
                    } else if (c24 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt27);
                    } else {
                        str66 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt27);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t35);
                return new zzxz(str65, str66);
            case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                int t36 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                int i38 = 0;
                String str67 = null;
                String str68 = null;
                while (parcel.dataPosition() < t36) {
                    int readInt28 = parcel.readInt();
                    char c25 = (char) readInt28;
                    if (c25 == 1) {
                        str67 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt28);
                    } else if (c25 == 2) {
                        str68 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt28);
                    } else if (c25 != 3) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt28);
                    } else {
                        i38 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt28);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t36);
                return new zzya(str67, str68, i38);
            case Const.ANDROID_VERSION_28 /* 28 */:
                int t37 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                long j10 = 0;
                int i39 = 0;
                int i40 = 0;
                int i41 = 0;
                int i42 = 0;
                while (parcel.dataPosition() < t37) {
                    int readInt29 = parcel.readInt();
                    char c26 = (char) readInt29;
                    if (c26 == 1) {
                        i39 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt29);
                    } else if (c26 == 2) {
                        i40 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt29);
                    } else if (c26 == 3) {
                        i41 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt29);
                    } else if (c26 == 4) {
                        i42 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt29);
                    } else if (c26 != 5) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt29);
                    } else {
                        j10 = com.google.android.gms.internal.mlkit_vision_common.t.p(parcel, readInt29);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t37);
                return new zzyu(j10, i39, i40, i41, i42);
            default:
                int t38 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                String str69 = null;
                String str70 = null;
                String str71 = null;
                String str72 = null;
                String str73 = null;
                String str74 = null;
                String str75 = null;
                String str76 = null;
                String str77 = null;
                String str78 = null;
                String str79 = null;
                String str80 = null;
                String str81 = null;
                String str82 = null;
                while (parcel.dataPosition() < t38) {
                    int readInt30 = parcel.readInt();
                    String str83 = str81;
                    switch ((char) readInt30) {
                        case 2:
                            str69 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt30);
                            break;
                        case 3:
                            str70 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt30);
                            break;
                        case 4:
                            str71 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt30);
                            break;
                        case 5:
                            str72 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt30);
                            break;
                        case 6:
                            str73 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt30);
                            break;
                        case 7:
                            str74 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt30);
                            break;
                        case '\b':
                            str75 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt30);
                            break;
                        case '\t':
                            str76 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt30);
                            break;
                        case '\n':
                            str77 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt30);
                            break;
                        case 11:
                            str78 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt30);
                            break;
                        case '\f':
                            str79 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt30);
                            break;
                        case '\r':
                            str80 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt30);
                            break;
                        case 14:
                            str81 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt30);
                            continue;
                        case 15:
                            str82 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt30);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt30);
                            break;
                    }
                    str81 = str83;
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t38);
                zzm zzmVar2 = new zzm();
                zzmVar2.zza = str69;
                zzmVar2.zzb = str70;
                zzmVar2.zzc = str71;
                zzmVar2.zzd = str72;
                zzmVar2.zze = str73;
                zzmVar2.zzf = str74;
                zzmVar2.zzg = str75;
                zzmVar2.zzh = str76;
                zzmVar2.zzi = str77;
                zzmVar2.zzj = str78;
                zzmVar2.zzk = str79;
                zzmVar2.zzl = str80;
                zzmVar2.zzm = str81;
                zzmVar2.zzn = str82;
                return zzmVar2;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        switch (this.f9230a) {
            case 0:
                return new zzn[i3];
            case 1:
                return new zzo[i3];
            case 2:
                return new zzp[i3];
            case 3:
                return new zzq[i3];
            case 4:
                return new zzr[i3];
            case 5:
                return new zzs[i3];
            case 6:
                return new zzt[i3];
            case 7:
                return new zzah[i3];
            case 8:
                return new zzan[i3];
            case 9:
                return new zzi[i3];
            case 10:
                return new zzu[i3];
            case 11:
                return new zzj[i3];
            case 12:
                return new zzk[i3];
            case 13:
                return new zzxp[i3];
            case 14:
                return new zzl[i3];
            case 15:
                return new zzyb[i3];
            case 16:
                return new zzyd[i3];
            case 17:
                return new zzxq[i3];
            case 18:
                return new zzxr[i3];
            case 19:
                return new zzxs[i3];
            case 20:
                return new zzxt[i3];
            case 21:
                return new zzxu[i3];
            case 22:
                return new zzxv[i3];
            case 23:
                return new zzxw[i3];
            case 24:
                return new zzxx[i3];
            case 25:
                return new zzxy[i3];
            case 26:
                return new zzxz[i3];
            case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                return new zzya[i3];
            case Const.ANDROID_VERSION_28 /* 28 */:
                return new zzyu[i3];
            default:
                return new zzm[i3];
        }
    }
}
