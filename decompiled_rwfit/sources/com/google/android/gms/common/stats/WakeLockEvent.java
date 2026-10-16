package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_common.u;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import y9.b;

@Deprecated
/* loaded from: classes.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new b();

    /* renamed from: a, reason: collision with root package name */
    public final int f9163a;
    private final long zzb;
    private final int zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final int zzg;

    @Nullable
    private final List zzh;
    private final String zzi;
    private final long zzj;
    private final int zzk;
    private final String zzl;
    private final float zzm;
    private final long zzn;
    private final boolean zzo;

    public WakeLockEvent(int i3, long j4, int i10, String str, int i11, ArrayList arrayList, String str2, long j10, int i12, String str3, String str4, float f2, long j11, String str5, boolean z5) {
        this.f9163a = i3;
        this.zzb = j4;
        this.zzc = i10;
        this.zzd = str;
        this.zze = str3;
        this.zzf = str5;
        this.zzg = i11;
        this.zzh = arrayList;
        this.zzi = str2;
        this.zzj = j10;
        this.zzk = i12;
        this.zzl = str4;
        this.zzm = f2;
        this.zzn = j11;
        this.zzo = z5;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int b() {
        return this.zzc;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long h() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String i() {
        List list = this.zzh;
        String join = list == null ? "" : TextUtils.join(Const.STR_MART_COMMA, list);
        int i3 = this.zzk;
        String str = this.zze;
        String str2 = this.zzl;
        float f2 = this.zzm;
        String str3 = this.zzf;
        int i10 = this.zzg;
        String str4 = this.zzd;
        boolean z5 = this.zzo;
        StringBuilder sb2 = new StringBuilder("\t");
        sb2.append(str4);
        sb2.append("\t");
        sb2.append(i10);
        sb2.append("\t");
        sb2.append(join);
        sb2.append("\t");
        sb2.append(i3);
        sb2.append("\t");
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        sb2.append("\t");
        if (str2 == null) {
            str2 = "";
        }
        sb2.append(str2);
        sb2.append("\t");
        sb2.append(f2);
        sb2.append("\t");
        sb2.append(str3 != null ? str3 : "");
        sb2.append("\t");
        sb2.append(z5);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f9163a);
        long j4 = this.zzb;
        u.k(parcel, 2, 8);
        parcel.writeLong(j4);
        u.e(parcel, 4, this.zzd);
        int i11 = this.zzg;
        u.k(parcel, 5, 4);
        parcel.writeInt(i11);
        List<String> list = this.zzh;
        if (list != null) {
            int i12 = u.i(parcel, 6);
            parcel.writeStringList(list);
            u.j(parcel, i12);
        }
        long j10 = this.zzj;
        u.k(parcel, 8, 8);
        parcel.writeLong(j10);
        u.e(parcel, 10, this.zze);
        int i13 = this.zzc;
        u.k(parcel, 11, 4);
        parcel.writeInt(i13);
        u.e(parcel, 12, this.zzi);
        u.e(parcel, 13, this.zzl);
        int i14 = this.zzk;
        u.k(parcel, 14, 4);
        parcel.writeInt(i14);
        float f2 = this.zzm;
        u.k(parcel, 15, 4);
        parcel.writeFloat(f2);
        long j11 = this.zzn;
        u.k(parcel, 16, 8);
        parcel.writeLong(j11);
        u.e(parcel, 17, this.zzf);
        boolean z5 = this.zzo;
        u.k(parcel, 18, 4);
        parcel.writeInt(z5 ? 1 : 0);
        u.j(parcel, i10);
    }
}
