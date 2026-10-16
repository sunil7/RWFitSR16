package q9;

import android.os.Parcel;

/* loaded from: classes.dex */
public final class z extends com.google.android.gms.internal.mlkit_vision_barcode.a implements l {
    @Override // q9.l
    public final int b() {
        Parcel m10 = m(y(), 2);
        int readInt = m10.readInt();
        m10.recycle();
        return readInt;
    }

    @Override // q9.l
    public final ba.a o() {
        Parcel m10 = m(y(), 1);
        ba.a A = ba.b.A(m10.readStrongBinder());
        m10.recycle();
        return A;
    }
}
