package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class j extends g implements k {
    public static k asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.barcode.aidls.IBarcodeScannerCreator");
        return queryLocalInterface instanceof k ? (k) queryLocalInterface : new i(iBinder);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.g
    public final boolean g(int i3, Parcel parcel, Parcel parcel2) {
        if (i3 != 1) {
            return false;
        }
        ba.a A = ba.b.A(parcel.readStrongBinder());
        zzba zzbaVar = (zzba) l.a(parcel, zzba.CREATOR);
        l.b(parcel);
        IInterface newBarcodeScanner = newBarcodeScanner(A, zzbaVar);
        parcel2.writeNoException();
        if (newBarcodeScanner == null) {
            parcel2.writeStrongBinder(null);
            return true;
        }
        parcel2.writeStrongBinder(((g) newBarcodeScanner).asBinder());
        return true;
    }
}
