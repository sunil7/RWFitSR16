package com.amap.api.col.p0003sl;

/* loaded from: classes.dex */
public class f4 {

    /* renamed from: a, reason: collision with root package name */
    public final double f4071a;

    /* renamed from: b, reason: collision with root package name */
    public final double f4072b;

    /* renamed from: c, reason: collision with root package name */
    public final double f4073c;

    /* renamed from: d, reason: collision with root package name */
    public final double f4074d;
    public final double e;

    /* renamed from: f, reason: collision with root package name */
    public final double f4075f;

    public f4(double d5, double d8, double d10, double d11) {
        this.f4071a = d5;
        this.f4072b = d10;
        this.f4073c = d8;
        this.f4074d = d11;
        this.e = (d5 + d8) / 2.0d;
        this.f4075f = (d10 + d11) / 2.0d;
    }

    public boolean a(double d5, double d8) {
        return this.f4071a <= d5 && d5 <= this.f4073c && this.f4072b <= d8 && d8 <= this.f4074d;
    }

    public boolean a(f4 f4Var) {
        return f4Var.f4071a < this.f4073c && this.f4071a < f4Var.f4073c && f4Var.f4072b < this.f4074d && this.f4072b < f4Var.f4074d;
    }
}
