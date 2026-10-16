package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class g extends Binder implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9301a;

    public g(String str, int i3) {
        this.f9301a = i3;
        switch (i3) {
            case 2:
                attachInterface(this, str);
                break;
            default:
                attachInterface(this, str);
                break;
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        int i3 = this.f9301a;
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i10) {
        switch (this.f9301a) {
            case 1:
                if (i3 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i3, parcel, parcel2, i10)) {
                    return true;
                }
                return y(i3, parcel, parcel2);
            case 2:
                if (i3 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i3, parcel, parcel2, i10)) {
                    return true;
                }
                return z(i3, parcel, parcel2);
            default:
                return super.onTransact(i3, parcel, parcel2, i10);
        }
    }

    public abstract boolean y(int i3, Parcel parcel, Parcel parcel2);

    public boolean z(int i3, Parcel parcel, Parcel parcel2) {
        return false;
    }
}
