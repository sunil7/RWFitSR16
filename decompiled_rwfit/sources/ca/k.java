package ca;

import android.os.Parcel;

/* loaded from: classes.dex */
public final class k extends com.google.android.gms.internal.mlkit_vision_barcode.a {
    public final ba.a B(ba.b bVar, String str, int i3) {
        Parcel y4 = y();
        ea.a.c(y4, bVar);
        y4.writeString(str);
        y4.writeInt(i3);
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
        Parcel m10 = m(y4, 8);
        ba.a A = ba.b.A(m10.readStrongBinder());
        m10.recycle();
        return A;
    }

    public final ba.a D(ba.b bVar, String str, int i3) {
        Parcel y4 = y();
        ea.a.c(y4, bVar);
        y4.writeString(str);
        y4.writeInt(i3);
        Parcel m10 = m(y4, 4);
        ba.a A = ba.b.A(m10.readStrongBinder());
        m10.recycle();
        return A;
    }

    public final ba.a E(ba.b bVar, String str, boolean z5, long j4) {
        Parcel y4 = y();
        ea.a.c(y4, bVar);
        y4.writeString(str);
        y4.writeInt(z5 ? 1 : 0);
        y4.writeLong(j4);
        Parcel m10 = m(y4, 7);
        ba.a A = ba.b.A(m10.readStrongBinder());
        m10.recycle();
        return A;
    }
}
