package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class i1 {

    /* renamed from: a, reason: collision with root package name */
    public final a1 f9795a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9796b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f9797c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9798d;

    public i1(a1 a1Var, String str, Object[] objArr) {
        this.f9795a = a1Var;
        this.f9796b = str;
        this.f9797c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f9798d = charAt;
            return;
        }
        int i3 = charAt & 8191;
        int i10 = 13;
        int i11 = 1;
        while (true) {
            int i12 = i11 + 1;
            char charAt2 = str.charAt(i11);
            if (charAt2 < 55296) {
                this.f9798d = i3 | (charAt2 << i10);
                return;
            } else {
                i3 |= (charAt2 & 8191) << i10;
                i10 += 13;
                i11 = i12;
            }
        }
    }

    public final int a() {
        int i3 = this.f9798d;
        if ((i3 & 1) != 0) {
            return 1;
        }
        return (i3 & 4) == 4 ? 3 : 2;
    }
}
