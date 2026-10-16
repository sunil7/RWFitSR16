package com.google.android.gms.internal.mlkit_vision_common;

/* loaded from: classes.dex */
public final class c implements e {

    /* renamed from: a, reason: collision with root package name */
    public final int f9874a;

    /* renamed from: b, reason: collision with root package name */
    public final zzah f9875b;

    public c(int i3, zzah zzahVar) {
        this.f9874a = i3;
        this.f9875b = zzahVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return e.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        c cVar = (c) ((e) obj);
        return this.f9874a == cVar.f9874a && this.f9875b.equals(cVar.f9875b);
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.f9874a ^ 14552422) + (this.f9875b.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f9874a + "intEncoding=" + this.f9875b + ')';
    }
}
