package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class d extends a implements f {
    public final c B(ba.b bVar, zzah zzahVar) {
        c cVar;
        Parcel y4 = y();
        t.a(y4, bVar);
        y4.writeInt(1);
        zzahVar.writeToParcel(y4, 0);
        Parcel z5 = z(y4, 1);
        IBinder readStrongBinder = z5.readStrongBinder();
        if (readStrongBinder == null) {
            cVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
            cVar = queryLocalInterface instanceof c ? (c) queryLocalInterface : new c(readStrongBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector", 0);
        }
        z5.recycle();
        return cVar;
    }
}
