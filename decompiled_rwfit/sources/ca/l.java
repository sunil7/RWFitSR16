package ca;

import android.os.Parcel;

/* loaded from: classes.dex */
public final class l extends com.google.android.gms.internal.mlkit_vision_barcode.a {
    public final ba.a B(ba.b bVar, String str, int i3, ba.b bVar2) {
        Parcel y4 = y();
        ea.a.c(y4, bVar);
        y4.writeString(str);
        y4.writeInt(i3);
        ea.a.c(y4, bVar2);
        Parcel m10 = m(y4, 2);
        ba.a A = ba.b.A(m10.readStrongBinder());
        m10.recycle();
        return A;
    }

    public final ba.a C(ba.b bVar, String str, int i3, ba.b bVar2) {
        Parcel y4 = y();
        ea.a.c(y4, bVar);
        y4.writeString(str);
        y4.writeInt(i3);
        ea.a.c(y4, bVar2);
        Parcel m10 = m(y4, 3);
        ba.a A = ba.b.A(m10.readStrongBinder());
        m10.recycle();
        return A;
    }
}
