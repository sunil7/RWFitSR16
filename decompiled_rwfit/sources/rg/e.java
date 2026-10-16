package rg;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;

/* loaded from: classes2.dex */
public abstract class e implements ci.a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f18125a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public final void a(f fVar) {
        try {
            b(fVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th2) {
            ad.a(th2);
            a1.b(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public abstract void b(f fVar);
}
