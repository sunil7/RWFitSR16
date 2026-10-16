package rg;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;

/* loaded from: classes2.dex */
public abstract class a implements c {
    public final void b(b bVar) {
        xg.c.b(bVar, "s is null");
        try {
            c(bVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th2) {
            ad.a(th2);
            a1.b(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public abstract void c(b bVar);
}
