package rg;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;

/* loaded from: classes2.dex */
public abstract class y implements a0 {
    public final void b(z zVar) {
        xg.c.b(zVar, "subscriber is null");
        try {
            c(zVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th2) {
            ad.a(th2);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public abstract void c(z zVar);
}
