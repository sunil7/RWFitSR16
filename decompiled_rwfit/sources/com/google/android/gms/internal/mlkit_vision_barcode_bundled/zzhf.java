package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzc' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class zzhf {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhf[] f9859a;
    public static final zzhf zza;
    public static final zzhf zzb;
    public static final zzhf zzc;
    public static final zzhf zzd;
    public static final zzhf zze;
    public static final zzhf zzf;
    public static final zzhf zzg;
    public static final zzhf zzh;
    public static final zzhf zzi;
    public static final zzhf zzj;
    public static final zzhf zzk;
    public static final zzhf zzl;
    public static final zzhf zzm;
    public static final zzhf zzn;
    public static final zzhf zzo;
    public static final zzhf zzp;
    public static final zzhf zzq;
    public static final zzhf zzr;
    private final zzhg zzt;

    static {
        zzhf zzhfVar = new zzhf("DOUBLE", 0, zzhg.zzd);
        zza = zzhfVar;
        zzhf zzhfVar2 = new zzhf("FLOAT", 1, zzhg.zzc);
        zzb = zzhfVar2;
        zzhg zzhgVar = zzhg.zzb;
        zzhf zzhfVar3 = new zzhf("INT64", 2, zzhgVar);
        zzc = zzhfVar3;
        zzhf zzhfVar4 = new zzhf("UINT64", 3, zzhgVar);
        zzd = zzhfVar4;
        zzhg zzhgVar2 = zzhg.zza;
        zzhf zzhfVar5 = new zzhf("INT32", 4, zzhgVar2);
        zze = zzhfVar5;
        zzhf zzhfVar6 = new zzhf("FIXED64", 5, zzhgVar);
        zzf = zzhfVar6;
        zzhf zzhfVar7 = new zzhf("FIXED32", 6, zzhgVar2);
        zzg = zzhfVar7;
        zzhf zzhfVar8 = new zzhf("BOOL", 7, zzhg.zze);
        zzh = zzhfVar8;
        zzhf zzhfVar9 = new zzhf("STRING", 8, zzhg.zzf);
        zzi = zzhfVar9;
        zzhg zzhgVar3 = zzhg.zzi;
        zzhf zzhfVar10 = new zzhf("GROUP", 9, zzhgVar3);
        zzj = zzhfVar10;
        zzhf zzhfVar11 = new zzhf("MESSAGE", 10, zzhgVar3);
        zzk = zzhfVar11;
        zzhf zzhfVar12 = new zzhf("BYTES", 11, zzhg.zzg);
        zzl = zzhfVar12;
        zzhf zzhfVar13 = new zzhf("UINT32", 12, zzhgVar2);
        zzm = zzhfVar13;
        zzhf zzhfVar14 = new zzhf("ENUM", 13, zzhg.zzh);
        zzn = zzhfVar14;
        zzhf zzhfVar15 = new zzhf("SFIXED32", 14, zzhgVar2);
        zzo = zzhfVar15;
        zzhf zzhfVar16 = new zzhf("SFIXED64", 15, zzhgVar);
        zzp = zzhfVar16;
        zzhf zzhfVar17 = new zzhf("SINT32", 16, zzhgVar2);
        zzq = zzhfVar17;
        zzhf zzhfVar18 = new zzhf("SINT64", 17, zzhgVar);
        zzr = zzhfVar18;
        f9859a = new zzhf[]{zzhfVar, zzhfVar2, zzhfVar3, zzhfVar4, zzhfVar5, zzhfVar6, zzhfVar7, zzhfVar8, zzhfVar9, zzhfVar10, zzhfVar11, zzhfVar12, zzhfVar13, zzhfVar14, zzhfVar15, zzhfVar16, zzhfVar17, zzhfVar18};
    }

    public zzhf(String str, int i3, zzhg zzhgVar) {
        this.zzt = zzhgVar;
    }

    public static zzhf[] values() {
        return (zzhf[]) f9859a.clone();
    }

    public final zzhg zza() {
        return this.zzt;
    }
}
