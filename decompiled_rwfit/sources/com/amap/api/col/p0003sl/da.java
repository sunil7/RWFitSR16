package com.amap.api.col.p0003sl;

import android.os.Build;
import r5.a;

/* loaded from: classes.dex */
public enum da {
    MIUI(n9.b("IeGlhb21p")),
    Flyme(n9.b("IbWVpenU")),
    RH(n9.b("IaHVhd2Vp")),
    ColorOS(n9.b("Ib3Bwbw")),
    FuntouchOS(n9.b("Idml2bw")),
    SmartisanOS(n9.b("Mc21hcnRpc2Fu")),
    AmigoOS(n9.b("IYW1pZ28")),
    EUI(n9.b("IbGV0dg")),
    Sense(n9.b("EaHRj")),
    LG(n9.b("EbGdl")),
    Google(n9.b("IZ29vZ2xl")),
    NubiaUI(n9.b("IbnViaWE")),
    Other("");


    /* renamed from: a, reason: collision with root package name */
    private String f3919a;

    /* renamed from: b, reason: collision with root package name */
    private int f3920b;

    /* renamed from: c, reason: collision with root package name */
    private String f3921c;

    /* renamed from: d, reason: collision with root package name */
    private String f3922d;
    private String e = Build.MANUFACTURER;

    da(String str) {
        this.f3919a = str;
    }

    public final String a() {
        return this.f3919a;
    }

    public final String b() {
        return this.f3921c;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ROM{name='");
        sb2.append(name());
        sb2.append("',versionCode=");
        sb2.append(this.f3920b);
        sb2.append(", versionName='");
        sb2.append(this.f3922d);
        sb2.append("',ma=");
        sb2.append(this.f3919a);
        sb2.append("',manufacturer=");
        return a.f(sb2, this.e, "'}");
    }

    public final void a(int i3) {
        this.f3920b = i3;
    }

    public final void b(String str) {
        this.f3922d = str;
    }

    public final void a(String str) {
        this.f3921c = str;
    }
}
