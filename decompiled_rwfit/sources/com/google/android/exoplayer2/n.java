package com.google.android.exoplayer2;

import com.google.android.gms.internal.mlkit_vision_barcode.pc;
import java.util.Locale;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final float f8890a;

    /* renamed from: b, reason: collision with root package name */
    public final float f8891b;

    static {
        new n(1.0f, 1.0f);
    }

    public n(float f2, float f10) {
        pc.a(f2 > 0.0f);
        pc.a(f10 > 0.0f);
        this.f8890a = f2;
        this.f8891b = f10;
        Math.round(f2 * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && n.class == obj.getClass()) {
            n nVar = (n) obj;
            if (this.f8890a == nVar.f8890a && this.f8891b == nVar.f8891b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.f8891b) + ((Float.floatToRawIntBits(this.f8890a) + 527) * 31);
    }

    public final String toString() {
        Object[] objArr = {Float.valueOf(this.f8890a), Float.valueOf(this.f8891b)};
        int i3 = i9.g.f14378a;
        return String.format(Locale.US, "PlaybackParameters(speed=%.2f, pitch=%.2f)", objArr);
    }
}
