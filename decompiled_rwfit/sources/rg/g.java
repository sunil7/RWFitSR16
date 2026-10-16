package rg;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;

/* loaded from: classes2.dex */
public abstract class g implements i {
    public final void b(h hVar) {
        xg.c.b(hVar, "observer is null");
        try {
            c(hVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th2) {
            ad.a(th2);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public abstract void c(h hVar);
}
