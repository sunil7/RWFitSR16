package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class eb {

    /* renamed from: a, reason: collision with root package name */
    public final zzqi f9284a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f9285b;

    public /* synthetic */ eb(ef.i iVar) {
        this.f9284a = (zzqi) iVar.f12629b;
        this.f9285b = (Integer) iVar.f12630c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof eb)) {
            return false;
        }
        eb ebVar = (eb) obj;
        return q9.n.h(this.f9284a, ebVar.f9284a) && q9.n.h(this.f9285b, ebVar.f9285b) && q9.n.h(null, null) && q9.n.h(null, null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9284a, this.f9285b, null, null});
    }
}
