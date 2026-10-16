package org.joda.time;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes2.dex */
public class IllegalInstantException extends IllegalArgumentException {
    private static final long serialVersionUID = 2858712538216L;

    public IllegalInstantException(String str) {
        super(str);
    }

    public static boolean isIllegalInstant(Throwable th2) {
        if (th2 instanceof IllegalInstantException) {
            return true;
        }
        if (th2.getCause() == null || th2.getCause() == th2) {
            return false;
        }
        return isIllegalInstant(th2.getCause());
    }

    public IllegalInstantException(long j4, String str) {
        super(l0.o("Illegal instant due to time zone offset transition (daylight savings time 'gap'): ", org.joda.time.format.a.a("yyyy-MM-dd'T'HH:mm:ss.SSS").d(new Instant(j4)), str != null ? l0.o(" (", str, ")") : ""));
    }
}
