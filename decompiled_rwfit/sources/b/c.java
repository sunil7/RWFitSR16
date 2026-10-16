package b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.os.ResultReceiver;

/* loaded from: classes.dex */
public final class c extends Binder implements b {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f3039b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ResultReceiver f3040a;

    public c(ResultReceiver resultReceiver) {
        this.f3040a = resultReceiver;
        attachInterface(this, "android.support.v4.os.IResultReceiver");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i10) {
        if (i3 >= 1 && i3 <= 16777215) {
            parcel.enforceInterface("android.support.v4.os.IResultReceiver");
        }
        if (i3 == 1598968902) {
            parcel2.writeString("android.support.v4.os.IResultReceiver");
            return true;
        }
        if (i3 != 1) {
            return super.onTransact(i3, parcel, parcel2, i10);
        }
        x(parcel.readInt(), (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
        return true;
    }

    @Override // b.b
    public final void x(int i3, Bundle bundle) {
        this.f3040a.a(i3, bundle);
    }
}
