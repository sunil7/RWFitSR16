package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public final class tf {

    /* renamed from: a, reason: collision with root package name */
    public final String f9533a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9534b;

    public tf(String str, int i3) {
        this.f9533a = str;
        this.f9534b = i3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof tf)) {
            return false;
        }
        tf tfVar = (tf) obj;
        return this.f9533a.equals(tfVar.f9533a) && this.f9534b == tfVar.f9534b;
    }

    public final int hashCode() {
        return ((((this.f9533a.hashCode() ^ 1000003) * 1000003) ^ 1231) * 1000003) ^ this.f9534b;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("MLKitLoggingOptions{libraryName=");
        sb2.append(this.f9533a);
        sb2.append(", enableFirelog=true, firelogEventType=");
        return r5.a.e(sb2, this.f9534b, "}");
    }
}
