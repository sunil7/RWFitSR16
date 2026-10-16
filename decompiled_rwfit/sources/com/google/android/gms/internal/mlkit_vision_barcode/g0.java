package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public final class g0 implements j0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f9302a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfd f9303b;

    public g0(int i3, zzfd zzfdVar) {
        this.f9302a = i3;
        this.f9303b = zzfdVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return j0.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        g0 g0Var = (g0) ((j0) obj);
        return this.f9302a == g0Var.f9302a && this.f9303b.equals(g0Var.f9303b);
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.f9302a ^ 14552422) + (this.f9303b.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f9302a + "intEncoding=" + this.f9303b + ')';
    }
}
