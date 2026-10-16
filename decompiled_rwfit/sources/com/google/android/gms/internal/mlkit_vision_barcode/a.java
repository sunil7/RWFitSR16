package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9199a;

    /* renamed from: b, reason: collision with root package name */
    public final IBinder f9200b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9201c;

    public /* synthetic */ a(IBinder iBinder, String str, int i3) {
        this.f9199a = i3;
        this.f9200b = iBinder;
        this.f9201c = str;
    }

    public void A(Parcel parcel, int i3) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f9200b.transact(i3, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        switch (this.f9199a) {
        }
        return this.f9200b;
    }

    public Parcel g() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f9201c);
        return obtain;
    }

    public void k(Parcel parcel, int i3) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f9200b.transact(i3, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public Parcel m(Parcel parcel, int i3) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f9200b.transact(i3, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e) {
                obtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }

    public Parcel y() {
        switch (this.f9199a) {
            case 0:
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(this.f9201c);
                return obtain;
            default:
                Parcel obtain2 = Parcel.obtain();
                obtain2.writeInterfaceToken(this.f9201c);
                return obtain2;
        }
    }

    public Parcel z(Parcel parcel, int i3) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f9200b.transact(i3, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e) {
                obtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }
}
