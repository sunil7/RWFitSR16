package q9;

import android.os.Parcel;
import com.google.android.gms.common.internal.zax;

/* loaded from: classes.dex */
public final class j extends com.google.android.gms.internal.mlkit_vision_barcode.a {
    public final ba.a B(ba.b bVar, zax zaxVar) {
        Parcel g10 = g();
        da.a.d(g10, bVar);
        da.a.c(g10, zaxVar);
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f9200b.transact(2, g10, obtain, 0);
                obtain.readException();
                g10.recycle();
                ba.a A = ba.b.A(obtain.readStrongBinder());
                obtain.recycle();
                return A;
            } catch (RuntimeException e) {
                obtain.recycle();
                throw e;
            }
        } catch (Throwable th2) {
            g10.recycle();
            throw th2;
        }
    }
}
